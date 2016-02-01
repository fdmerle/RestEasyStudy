import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by dmytro_moskalenko2 on 1/20/2016.
 */
public class TestSuite extends MainTest {

    @Test
    public void test() {


        Assert.assertEquals(senderObject.warmestCityObtaining("Tomorrow"), "Wroclaw");
        Assert.assertTrue(senderObject.temperatureObtaining("02/05/2016", "Wroclaw") > -100);
        Assert.assertTrue(senderObject.temperatureObtaining("02/05/2016", "Wroclaw") < 100);
        Assert.assertTrue(senderObject.temperatureObtaining("Today", "Wroclaw") < 100);
        Assert.assertEquals(senderObject.temperatureObtaining("Tomorrow", "Wroclaw"), 12.94);
        Assert.assertEquals(senderObject.temperatureObtaining("Today", "Wroclaw"), 8.74);
    }


}
