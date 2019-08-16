package ng.sterling.footballfixtures.utils;

import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

/**
 * Author: Oluwatobi Adenekan
 * date:    15/08/2019
 **/

public class DateTimeUtil {


    public static String format(Date date, String format) {
        return new SimpleDateFormat(format).format(date);
    }

    public static Date parseString(String dateString, String format) {
        try {
            Date parse = new SimpleDateFormat(format).parse(dateString);
            return parse;
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return null;
    }


    public static String format(String date, String formatFrom, String formatTo) {
        Date dateType = parseString(date, formatFrom);
        Format formatter = new SimpleDateFormat(formatTo);
        return ((SimpleDateFormat) formatter).format(dateType);
    }
}
