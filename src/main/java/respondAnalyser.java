import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by dmytro_moskalenko2 on 1/20/2016.
 */

public class RespondAnalyser {
    private UrlBuilder urlBuilder = new UrlBuilder();
    private String urlStr;
    private RestEasySender getRequest = new RestEasySender();
    private JSONObject respondElement = null;
    private ObjectMapper mapper = new ObjectMapper();

    public int returnTemperature(String Date, String City) {
        urlStr = urlBuilder.returnUrl(City, Date);
        String reqResult = getRequest.sendGetRequest(urlStr);
        return temperatureParsing(reqResult);
    }

    public String returnWarmestCity(String Date) {
        urlStr = urlBuilder.returnUrl(Date);
        return warmestCityParsing(urlStr);
    }

    private int temperatureParsing(String JSONRespond) {
        try {
            WeatherObject resultObj = mapper.readValue(JSONRespond, WeatherObject.class);
            System.out.println(resultObj.getTemp());
            return resultObj.getTemp();
        } catch (IOException e1) {
            e1.printStackTrace();
            return -1000;
        }
    }

    private String warmestCityParsing(String JSONRespond) {
        int i;
        JSONArray result = null;
        List<WeatherObject> respondObject = new ArrayList<WeatherObject>();
        try {
            respondElement = new JSONObject(getRequest.sendGetRequest(JSONRespond));
            result = respondElement.getJSONArray("list");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        for (i = 0; i < result.length(); i++) {

            WeatherObject resultObj = null;

            try {
                resultObj = mapper.readValue(result.get(i).toString(), WeatherObject.class);
            } catch (IOException | JSONException e) {
                e.printStackTrace();
            }
            respondObject.add(resultObj);
        }
        Collections.sort(respondObject, new WeatherObject());
        System.out.println(respondObject.get(0).getName());
        return respondObject.get(0).getName();
    }
}


