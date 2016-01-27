import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by dmytro_moskalenko2 on 12/23/2015.
 */
public class UrlBuilder {
    private String serviceUrl = "http://api.openweathermap.org/data/2.5/";
    private String serviceToken = "7e6c68e6843af56620fcd8e6a14d62b1";
    private String selectedCountry = "pl";
    private String dateForUrl;
    private List<String> cities = new ArrayList<String>() {{
        add("3094802");
        add("3081368");
        add("3099434");
    }};

    private String cityCodes = "";


    public String returnUrl(String requestCity, String requestDate) {
        dateForUrl = getDateString(requestDate);
        return serviceUrl + "weather?q=" + requestCity + "," + selectedCountry + "&units=metric&APPID=" + serviceToken;
    }

    public String returnUrl(String requestDate) {
        cityCodes = "";


        for (String item : cities) {
            cityCodes = cityCodes + item + ",";
        }
        cityCodes = cityCodes.substring(0, cityCodes.length() - 1);


        dateForUrl = getDateString(requestDate);
        return serviceUrl + "group?id=" + cityCodes + "&units=metric&APPID=" + serviceToken;
    }


    private String getDateString(String date) {


        switch (date) {

            case "Yesterday":
                return dateCalculation(-1);

            case "Today":
                return dateCalculation(0);

            case "Tomorrow":
                return dateCalculation(1);

            default:
                if (isDateValidFormat("MM/dd/yyyy", date)) {
                    return date;

                }
        }
        return " ";
    }


    private boolean isDateValidFormat(String format, String value) {
        Date date = null;

        SimpleDateFormat sdf = new SimpleDateFormat(format);
        try {
            date = sdf.parse(value);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (!value.equals(sdf.format(date))) {
            date = null;
        }

        return date != null;
    }

    private String dateCalculation(int divDate) {

        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, divDate);
        return dateFormat.format(cal.getTime());

    }
}

