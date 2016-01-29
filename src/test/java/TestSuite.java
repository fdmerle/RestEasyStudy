import org.testng.annotations.Test;

/**
 * Created by dmytro_moskalenko2 on 1/20/2016.
 */
public class TestSuite extends MainTest{

    @Test
    public void test() {

        senderObject.temperatureObtaining( "01/30/2016","Wroclaw");
        senderObject.warmestCityObtaining("01/30/2016");

        /*Assert.assertEquals(senderObject.requestSender("01/25/2016", "Krakow"),8);
        Assert.assertEquals(senderObject.requestSender("01/25/2016", "Wroclaw"),11);
        Assert.assertEquals(senderObject.requestSender("01/25/2016", "Gdansk"),8);*/
        //Assert.assertEquals(senderObject.returnWarmestCity("01/25/2016"),"Krakow");
    }
}
