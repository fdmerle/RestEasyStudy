import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonSetter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dmytro_moskalenko2 on 1/28/2016.
 */
@JsonIgnoreProperties(ignoreUnknown = true)

public class JsonRespondObject {
    private List<WeatherListElement> listElement =new ArrayList<WeatherListElement>();
    @JsonSetter("list")
    public void setListElement(List<WeatherListElement> _listElement) {
        listElement = _listElement;
    }
    public List<WeatherListElement> getListElement(){
        return listElement;
    }

    public WeatherListElement returnElementByDate(String date){
        for(WeatherListElement item:listElement){
            if (item.getDtInReadableView().equals(date)){
                return item;
            }
        }
        return null;
    }
}
