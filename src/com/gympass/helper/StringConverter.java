package com.gympass.helper;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class StringConverter {

    /*
    //example of format  1:02.852
    public static Date convertToDuration(String duration){
        DateFormat dateFormat = new SimpleDateFormat("mm:ss.SSS");
        return convertToDateTime(duration, dateFormat);
    }
    */

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


    //example of format  1:02.852
    public static Duration convertToDuration(String duration){
        String[] fields = duration.split("[:.]");

        String str = String.format("PT%sM%sS", fields[0], fields[1]);
        Duration dur = Duration.parse(str);
        dur = dur.plusMillis(Long.parseLong(fields[2]));
        return dur;
        //return Duration.parse(String.format("P%dM%dS", fields[0], fields[1])).plusMillis(Long.parseLong(fields[2]));
    }

    public static String convertDurationToString(Duration duration){
        long totalInSeconds = duration.getSeconds();
        long minutes = (int)(totalInSeconds/60);
        long seconds = (totalInSeconds % 60);
        long millisec = (int)duration.getNano()/(1000000); //converting nanoseconds to milliseconds

        String oi = String.format("%d:%d.%d", minutes, seconds, millisec);
        return oi;
    }

    public static String convertDurationToString(long duration){
        return convertDurationToString(Duration.ofMillis(duration));
    }

    public static String convertTimeToString(Date time){
        String pattern = "hh:mm:ss.ms";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

        String date = simpleDateFormat.format(time);
        return date;
    }




}
