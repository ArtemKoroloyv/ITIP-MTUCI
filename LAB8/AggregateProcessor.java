import java.util.List;
import java.util.stream.Collectors;

public class AggregateProcessor {
    @DataProcessor(order = 3, chunkable = false)
    public List<String> distinctAll(List<String> data) {
        return data.stream()
                .distinct()
                .collect(Collectors.toList());
    }
}
