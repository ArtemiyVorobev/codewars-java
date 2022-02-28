import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TowerBuilderTest {

    @Test
    public void BasicTests() {
        assertEquals(String.join(",", "*"), String.join(",", TowerBuilder.TowerBuilder(1)));
        assertEquals(String.join(",", " * ", "***"), String.join(",", TowerBuilder.TowerBuilder(2)));
        assertEquals(String.join(",", "  *  ", " *** ", "*****"), String.join(",", TowerBuilder.TowerBuilder(3)));
    }

}