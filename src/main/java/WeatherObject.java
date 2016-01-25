
import java.util.Comparator;


/**
 * Created by dmytro_moskalenko2 on 1/18/2016.
 */
public class WeatherObject implements Comparator<WeatherObject> {
    private String city;
    private int temperature;

    WeatherObject(String inputCity, int imputTemperature) {
        city = inputCity;
        temperature = imputTemperature;
    }

    WeatherObject() {
    }

    public String getCityName() {
        return city;
    }

    public int getTemperatureValue() {
        return temperature;
    }


    public int compare(WeatherObject o1, WeatherObject o2) {
        return o2.temperature - o1.temperature;
    }
}


