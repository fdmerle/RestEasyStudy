import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by dmytro_moskalenko2 on 1/20/2016.
 */
public class TestSuite extends MainTest{

    @Test
    public void test() {

        senderObject.ReturnTemperature("01/30/2016", "Krakow");
        senderObject.ReturnTemperature("Yesterday", "Krakow");
        senderObject.returnWarmestCity("Yesterday");

        Assert.assertEquals(senderObject.ReturnTemperature("01/30/2016", "Krakow")<100,true);
        Assert.assertEquals(senderObject.returnWarmestCity("Yesterday").equals("Krakow"),true);

    }
}
