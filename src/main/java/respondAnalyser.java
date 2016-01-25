import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by dmytro_moskalenko2 on 1/20/2016.
 */
public class respondAnalyser {
    private UrlBuilder urlBuilder = new UrlBuilder();
    private String url;
    private RestEasySender getRequest = new RestEasySender();
    private JSONObject respondElement = null;
    public int ReturnTemperature(String Date, String City){


        url = urlBuilder.returnUrl(City, Date);
        int temperature=0;
        try {
            temperature=new JSONObject(getRequest.SendGetRequest(url)).getJSONObject("main").getInt("temp");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        System.out.println(temperature);
        return temperature;
    }

    public String returnWarmestCity(String Date){

        int i;
        List<WeatherObject> respondObject = new ArrayList<WeatherObject>();
        url = urlBuilder.returnUrl(Date);

        try {
            respondElement = new JSONObject(getRequest.SendGetRequest(url));

        JSONArray result = respondElement.getJSONArray("list");
        for (i = 0; i < result.length(); i++) {
            JSONObject cityResult = result.getJSONObject(i).getJSONObject("main");
            respondObject.add(new WeatherObject(result.getJSONObject(i).getString("name"), cityResult.getInt("temp_min")));
        }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Collections.sort(respondObject, new WeatherObject());
        System.out.println(respondObject.get(0).getCityName());
        return respondObject.get(0).getCityName();

    }

}
