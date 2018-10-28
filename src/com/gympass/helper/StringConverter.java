package com.gympass.helper;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringConverter {

    //example of format  1:02.852
    public static Date convertToDuration(String duration){
        DateFormat dateFormat = new SimpleDateFormat("mm:ss.SSS");
        return convertToDateTime(duration, dateFormat);
    }

    //example of format  23:49:08.277
    public static Date convertToTime(String time){
        DateFormat dateFormat = new SimpleDateFormat("hh:mm:ss.SSS");
        return convertToDateTime(time, dateFormat);
    }

    private static Date convertToDateTime(String dateTime, DateFormat dateFormat){
        try {
            Date date = dateFormat.parse(dateTime);
            return date;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static float convertToAverageSpeed(String string){
        string = string.replace(',','.');
        return Float.parseFloat(string);
    }




}
