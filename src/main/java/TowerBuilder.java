import java.util.Collections;

public class TowerBuilder {

    public static String[] TowerBuilder(int nFloors)
    {
        String[] result = new String[nFloors];
        int max = 1 + (2 * nFloors - 2);
        for (int i = 1; i <= nFloors; i++) {
            int countOfAsterisks = 1 + (2 * i - 2);
            int whitespaces = (max-countOfAsterisks)/2;
            String whitespacePart = String.join("", Collections.nCopies(whitespaces, " "));
            String payloadPart = String.join("", Collections.nCopies(countOfAsterisks, "*"));
            result[i-1] = whitespacePart + payloadPart + whitespacePart;
        }
        return result;
    }

}
