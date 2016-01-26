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
        try {
            WeatherObject resultObj = mapper.readValue(reqResult, WeatherObject.class);
            System.out.println(resultObj.getTemp());
            return resultObj.getTemp();
        } catch (IOException e1) {
            e1.printStackTrace();
            return -1000;
        }
    }

    public String returnWarmestCity(String Date) {

        int i;
        List<WeatherObject> respondObject = new ArrayList<WeatherObject>();
        urlStr = urlBuilder.returnUrl(Date);

        try {
            respondElement = new JSONObject(getRequest.sendGetRequest(urlStr));
        } catch (JSONException e) {
            e.printStackTrace();
        }

        JSONArray result = null;
        try {
            result = respondElement.getJSONArray("list");
        } catch (JSONException e1) {
            e1.printStackTrace();
        }


        for (i = 0; i < result.length(); i++) {
            try {
                WeatherObject resultObj = null;
                try {
                    resultObj = mapper.readValue(result.get(i).toString(), WeatherObject.class);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                respondObject.add(resultObj);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }

        Collections.sort(respondObject, new WeatherObject());

        System.out.println(respondObject.get(0).getName());
        return respondObject.get(0).getName();

    }

}


