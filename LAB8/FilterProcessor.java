import java.util.List;
import java.util.stream.Collectors;

public class FilterProcessor {
    @DataProcessor(order = 1, chunkable = true)
    public List<String> filterShort(List<String> data) {
        return data.stream()
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .filter(s -> s.length() >= 4)
                .collect(Collectors.toList());
    }
}
