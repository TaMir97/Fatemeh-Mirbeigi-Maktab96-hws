package streamImplementations;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SecondQuestion {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("Amir", "Mohammad", "Reza", "Mahdi", "Ali", "Taher", "Mojtaba");
        Map<Integer, List<String>> groupedStrings = strings.stream()
                .collect(Collectors.groupingBy(String::length));

        groupedStrings.values().forEach(System.out::println);
        groupedStrings.forEach((length, group) -> System.out.println(length + ": " + group));

    }

}
