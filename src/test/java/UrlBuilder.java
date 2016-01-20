import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by dmytro_moskalenko2 on 12/23/2015.
 */
public class UrlBuilder {
    private String serviceUrl = "http://api.openweathermap.org/data/2.5/";
    private String serviceToken = "7e6c68e6843af56620fcd8e6a14d62b1";
    private String selectedCountry = "pl";
    private String dateForUrl;

    public String returnUrl(String requestCity, String requestDate) {
        dateForUrl = getDateString(requestDate);
        return serviceUrl + "weather?q=" + requestCity + "," + selectedCountry + "&units=metric&APPID=" + serviceToken;
    }

    public String returnUrl(String requestDate) {
        String krakowCityCode = "3094802";
        String wroclawCityCode = "3081368";
        String gdanskCityCode = "3099434";
        String cityCodes = krakowCityCode + "," + gdanskCityCode + "," + wroclawCityCode;
        dateForUrl = getDateString(requestDate);
        return serviceUrl + "group?id=" + cityCodes + "," + "&units=metric&APPID=" + serviceToken;
    }

    private String getDateString(String Date) {
        int divDate = 0;
        if (isDateValidFormat("MM/dd/yyyy", Date)) {
            return Date;
        } else {
            if (Date.equals("Yesterday")) {
                divDate = -1;

            } else if (Date.equals("Today")) {
                divDate = 0;

            } else if (Date.equals("Tomorrow")) {
                divDate = 1;

            } else {
                throw new IllegalArgumentException();
            }
            DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
            Calendar cal = Calendar.getInstance();
            cal.add(Calendar.DATE, divDate);
            return dateFormat.format(cal.getTime());
        }

    }

    private static boolean isDateValidFormat(String format, String value) {
        Date date = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            date = sdf.parse(value);
            if (!value.equals(sdf.format(date))) {
                date = null;
            }
        } catch (ParseException ex) {
            //           ex.printStackTrace();
        }
        return date != null;
    }
}

