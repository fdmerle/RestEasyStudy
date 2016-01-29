import com.fasterxml.jackson.annotation.JsonFormat;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonSetter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;


/**
 * Created by dmytro_moskalenko2 on 1/28/2016.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherListElement {
    private TemperatureElement temp;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd,HH:00", timezone = "CET")
    private Long dt;
    private String dtInReadableView;

    @JsonSetter("temp")
    public void setTemp(TemperatureElement _temp) {
        temp = _temp;
    }

    public TemperatureElement getTemp() {
        return temp;
    }

    @JsonSetter("dt")
    public void dtSetter(Long _dt) {
        dt = _dt;
    }


    public long getDt() {

        return dt;

    }

    public String getDtInReadableView() {

        DateFormat df = new SimpleDateFormat("MM/dd/yyyy");

        String dtInReadableView = df.format(dt * 1000);

        return dtInReadableView;
    }

}
