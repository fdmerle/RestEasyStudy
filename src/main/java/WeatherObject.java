import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonSetter;

import java.util.Comparator;

/**
 * Created by dmytro_moskalenko2 on 1/18/2016.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
//implements Comparator<WeatherObject>
public class WeatherObject implements Comparator<WeatherObject> {
    private String name;

    @JsonSetter("name")
    public void setName(String _name){
        name=_name;
    }
    public String getName (){
        return name;
    }
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class main{
        private int temp;
        public void setTemp(int _temp){
            temp=_temp;
        }
    }
    private main main;
    @JsonSetter("main")
    public void setTemp(main _main){
        main=_main;
    }
    public int getTemp(){
        return main.temp;
    }
    public int compare(WeatherObject o1, WeatherObject o2) {
        return o2.getTemp() - o1.getTemp();
    }

}


