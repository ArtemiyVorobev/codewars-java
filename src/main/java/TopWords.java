import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class TopWords {
    
    public static List<String> top3(String s) {
        System.out.println("input: " + s);
        String inputString = s.toLowerCase().chars().map(ch -> {
            if (ch != 39 && !(ch >= 97 && ch <= 122)) {
                return 32;
            }
            return ch;
        }).collect(StringBuilder::new,
                StringBuilder::appendCodePoint, StringBuilder::append).toString();
        String[] splitInput = inputString.trim().split("\\s");
        Map<String, Integer> resultMap = new LinkedHashMap<>();
        for (String inputWord : splitInput) {
            OptionalInt foundLetters = inputWord.chars().filter(value -> (value >= 97 && value <= 122) || (value >= 48 && value <= 57)).findAny();
            if (foundLetters.isPresent()) {
                String sanitized = inputWord.chars().filter(value -> (value >= 97 && value <= 122) || value == 39 || (value >= 48 && value <= 57))
                        .collect(StringBuilder::new,
                        StringBuilder::appendCodePoint, StringBuilder::append).toString();
                if (resultMap.containsKey(sanitized)){
                    Integer count = resultMap.get(sanitized);
                    resultMap.put(sanitized, count+1);
                } else {
                    resultMap.put(sanitized, 1);
                }
            }
        }
        List<Map.Entry<String, Integer>> list = new ArrayList<>(resultMap.entrySet());
        list.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        List<String> result = new ArrayList();
        int count = 0;
        for (Map.Entry<String, Integer> entry : list) {
            if (count < 3) {
                result.add(entry.getKey());
            }
            count++;
        }
        return result;
    }

    public static List<String> top4(String s) {
        return Arrays.stream(s.toLowerCase().split("[^a-z|']"))
                .filter(o -> !o.isEmpty() && !o.replace("'","").isEmpty())
                .collect(groupingBy(Function.identity(), Collectors.counting())).entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .map(Map.Entry::getKey)
                .limit(3)
                .collect(Collectors.toList());
    }
}