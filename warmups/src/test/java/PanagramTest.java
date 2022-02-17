import static org.junit.jupiter.api.Assertions.*;

class PanagramTest {

    @org.junit.jupiter.api.Test
    void panagram() {
        Panagram png;
        png = new Panagram();
        assertTrue(png.isPanagram("abcdefghijklmnopqrstuvwxyz"));
        assertFalse(png.isPanagram("While Jodi is fun, she is reserved and respectful"));
        assertTrue(png.isPanagram("the quick brown fox jumped over the lazy dogs."));

        //right clicked on the red
        // context actions
        // add maven dependency
        // added first one (5.6.1) ** maybe
    }
}