import org.junit.Test;

import static org.junit.Assert.*;

public class MultiplesOf3or5Test {

    @Test
    public void solutionTest() {
        assertEquals(23, new MultiplesOf3or5().solution(10));
    }
}