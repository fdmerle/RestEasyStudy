import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by dmytro_moskalenko2 on 1/20/2016.
 */
public class RespondAnalyser {
    UrlBuilder urlBuilder = new UrlBuilder();
    String url;
    RestEasySender getRequest = new RestEasySender();

    public int ReturnTemperasture(String Date, String City) throws JSONException {


        url = urlBuilder.returnUrl(City, Date);
        JSONObject respondObject = new JSONObject(getRequest.SendGetRequest(url));
        JSONObject temperatureGroup = respondObject.getJSONObject("main");
        int temperature = temperatureGroup.getInt("temp");
        System.out.println(temperature);
        return temperature;
    }

    public String ReturnWarmestCity(String Date) throws JSONException {

        int i;
        List<WeatherObject> respondObject = new ArrayList<WeatherObject>();
        url = urlBuilder.returnUrl(Date);
        JSONObject respondElement = new JSONObject(getRequest.SendGetRequest(url));
        JSONArray result = respondElement.getJSONArray("list");
        for (i = 0; i < result.length(); i++) {
            JSONObject cityResult = result.getJSONObject(i).getJSONObject("main");
            respondObject.add(new WeatherObject(result.getJSONObject(i).getString("name"), cityResult.getInt("temp_min")));
        }
        Collections.sort(respondObject, new WeatherObject());
        System.out.println(respondObject.get(0).getCityName());
        return respondObject.get(0).getCityName();

    }

}
