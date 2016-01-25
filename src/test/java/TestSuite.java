import org.testng.annotations.Test;

/**
 * Created by dmytro_moskalenko2 on 1/20/2016.
 */
public class TestSuite extends MainTest{

    @Test
    public void test() {

        senderObject.ReturnTemperature("01/30/2016", "Krakow");
        senderObject.ReturnTemperature("Yesterday", "Krakow");
        senderObject.ReturnWarmestCity("Yesterday");
    }
}
