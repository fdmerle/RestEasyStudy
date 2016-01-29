import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by dmytro_moskalenko2 on 1/20/2016.
 */

public class RespondAnalyser {

    private UrlBuilder urlBuilder = new UrlBuilder();
    private RestEasySender getRequest = new RestEasySender();
    private ObjectMapper mapper = new ObjectMapper();

    private String requestSender( String city,String date) {
        return getRequest.sendGetRequest(urlBuilder.returnUrl(city, date));
    }

    private JsonRespondObject objectForTemperatureObtaining(String reqResult) {

        try {
            return mapper.readValue(reqResult, JsonRespondObject.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public double temperatureObtaining(String _date, String city) {
        String date=urlBuilder.getDateString(_date);
        String jsonText = requestSender(city, date);
        JsonRespondObject allObjects = objectForTemperatureObtaining(jsonText);
        WeatherListElement objectForCurrentDate = allObjects.returnElementByDate(date);
        double temperature = objectForCurrentDate.getTemp().getDayTemp();
        System.out.println(temperature);
        return temperature;

    }


    public String warmestCityObtaining(String _date) {
        String date=urlBuilder.getDateString(_date);
        List <PairsOfCityTemperature> element= new ArrayList<>();
        ArrayList<String> cities = new ArrayList<String>() {{
            add("Krakow");
            add("Wroclaw");
            add("Gdansk");
        }};
        for(String item:cities){
            element.add(new PairsOfCityTemperature(item,temperatureObtaining(date,item)));
       }
        Collections.sort(element);
        System.out.println(element.get(0).getCity());
        return element.get(0).getCity();
    }

}


