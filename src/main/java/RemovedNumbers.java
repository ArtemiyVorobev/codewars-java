import java.util.ArrayList;
import java.util.List;

public class RemovedNumbers {

    public static List<long[]> removNb(long n) {
        List<long[]> result = new ArrayList<>();
        long sum = (n*(n+1))/2;

        for (long a = 1; a < n; a++) {
            long b = ((sum-a) / (a+1)) <= n ? ((sum-a) / (a+1)) : 0;
            if (b == 0) {
                continue;
            }
            if((sum - a - b) == (a * b)){
                result.add(new long[]{a, b});
            }
        }
        return result;
    }
}