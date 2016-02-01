import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonSetter;

/**
 * Created by dmytro_moskalenko2 on 1/28/2016.
 */
@JsonIgnoreProperties(ignoreUnknown = true)

public class TemperatureElement {
    private double dayTemp;

    @JsonSetter("day")
    public void setDayTemp(double _dayTemp) {
        dayTemp = _dayTemp;
    }

    public double getDayTemp() {
        return dayTemp;
    }
}
