import java.io.*;
import java.lang.reflect.Method;
import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class DataManager {

    private List<String> data = new ArrayList<>();
    private final List<MethodHolder> pipeline = new ArrayList<>();

    private static class MethodHolder {
        final Object processor;
        final Method method;
        final int order;
        final boolean chunkable;

        MethodHolder(Object processor, Method method, int order, boolean chunkable) {
            this.processor = processor;
            this.method = method;
            this.order = order;
            this.chunkable = chunkable;
        }
    }

    public void registerDataProcessor(Object processor) {
        boolean found = false;

        for (Method m : processor.getClass().getDeclaredMethods()) {
            if (m.isAnnotationPresent(DataProcessor.class)) {
                DataProcessor ann = m.getAnnotation(DataProcessor.class);
                m.setAccessible(true);
                pipeline.add(new MethodHolder(processor, m, ann.order(), ann.chunkable()));
                found = true;
            }
        }

        if (!found) {
            System.out.println("Предупреждение: нет методов с @DataProcessor у "
                    + processor.getClass().getSimpleName());
        }
    }

    public boolean loadData(String source) {
        try (BufferedReader br = new BufferedReader(new FileReader(source))) {
            data = br.lines().collect(Collectors.toList());
            return true;
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден: " + source);
            return false;
        } catch (IOException e) {
            System.out.println("Ошибка чтения файла: " + source);
            return false;
        }
    }

    public void processData() {
        pipeline.sort(Comparator.comparingInt(h -> h.order));

        ExecutorService executor = Executors.newFixedThreadPool(
                Math.max(2, Runtime.getRuntime().availableProcessors())
        );

        try {
            for (MethodHolder stage : pipeline) {
                if (data.isEmpty()) break;

                if (!stage.chunkable) {
                    Future<List<String>> f = executor.submit(() -> invoke(stage, data));
                    data = f.get();
                } else {
                    List<List<String>> chunks = splitIntoChunks(data,
                            Math.max(2, Runtime.getRuntime().availableProcessors()));

                    List<Future<List<String>>> futures = new ArrayList<>();
                    for (List<String> chunk : chunks) {
                        futures.add(executor.submit(() -> invoke(stage, chunk)));
                    }

                    List<String> merged = new ArrayList<>();
                    for (Future<List<String>> f : futures) merged.addAll(f.get());

                    data = merged;
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Обработка прервана");
        } catch (ExecutionException e) {
            System.out.println("Ошибка в обработчике: " + e.getCause());
        } finally {
            executor.shutdown();
        }
    }

    @SuppressWarnings("unchecked")
    private List<String> invoke(MethodHolder stage, List<String> input) throws Exception {
        return (List<String>) stage.method.invoke(stage.processor, input);
    }

    private List<List<String>> splitIntoChunks(List<String> src, int parts) {
        int n = src.size();
        int chunkSize = Math.max(1, (n + parts - 1) / parts);

        List<List<String>> res = new ArrayList<>();
        for (int i = 0; i < n; i += chunkSize) {
            res.add(src.subList(i, Math.min(n, i + chunkSize)));
        }
        return res;
    }

    public void saveData(String destination) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(destination))) {
            for (String line : data) {
                bw.write(line);
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Ошибка записи файла: " + destination);
        }
    }
}
