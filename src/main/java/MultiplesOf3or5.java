import java.util.stream.IntStream;

public class MultiplesOf3or5 {

    public int solution(int number) {
        return IntStream.range(3, number).
                filter(value -> value % 3 == 0 || value % 5 == 0 )
                .sum();
    }
}
