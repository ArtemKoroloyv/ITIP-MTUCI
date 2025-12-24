import java.util.List;
import java.util.stream.Collectors;

public class TransformProcessor {
    @DataProcessor(order = 2, chunkable = true)
    public List<String> toUpper(List<String> data) {
        return data.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
    }
}
