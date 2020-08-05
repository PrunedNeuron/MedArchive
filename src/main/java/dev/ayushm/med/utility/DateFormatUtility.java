package dev.ayushm.med.utility;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatUtility {

    public static String formatIntoWords(Date date) {
        SimpleDateFormat df = new SimpleDateFormat("dd MMMM, yyyy");
        return df.format(date);
    }

}
