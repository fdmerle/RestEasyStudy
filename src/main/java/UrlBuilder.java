import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by dmytro_moskalenko2 on 12/23/2015.
 */
public class UrlBuilder {


    public String returnUrl(String requestCity) {
        String serviceUrl = "http://api.openweathermap.org/data/2.5/";
        String serviceToken = "7e6c68e6843af56620fcd8e6a14d62b1";
        System.out.println(serviceUrl + "forecast/daily?q=" + requestCity + "&cnt=16&units=metric&APPID=" + serviceToken);
        return serviceUrl + "forecast/daily?q=" + requestCity + "&cnt=16&units=metric&APPID=" + serviceToken;
    }


    public String getDateString(String date) {


        switch (date) {

            case "Yesterday":
                return dateCalculation(-1);

            case "Today":
                return dateCalculation(0);

            case "Tomorrow":
                return dateCalculation(1);

        }
        if (isDateValidFormat("MM/dd/yyyy", date)) {
            return date;
        } else
            return " ";

    }


    private boolean isDateValidFormat(String format, String value) {

        SimpleDateFormat sdf = new SimpleDateFormat(format);
        try {
            sdf.parse(value);
            return true;
        } catch (ParseException e) {
            e.printStackTrace();
            return false;
        }

    }

    private String dateCalculation(int divDate) {

        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, divDate);
        return dateFormat.format(cal.getTime());

    }
}

