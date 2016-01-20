import org.codehaus.jettison.json.JSONException;
import org.testng.annotations.Test;

/**
 * Created by dmytro_moskalenko2 on 1/20/2016.
 */
public class TestSuite extends MainTest{

    @Test
    public void test() throws JSONException {

        senderObject.ReturnTemperasture("Yesterday","Krakow");
        senderObject.ReturnWarmestCity("Yesterday");
    }
}
