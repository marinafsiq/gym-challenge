package com.gympass.helper;

import com.gympass.kart.Lap;
import com.gympass.kart.Pilot;

import java.util.ArrayList;
import java.util.HashMap;

public class PrintHelper {

    public static void bestLap(Lap bestLap){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\nBest Lap");
        stringBuilder.append("\nNumber: ");
        stringBuilder.append(bestLap.getNumber());
        stringBuilder.append("\nTime: ");
        stringBuilder.append(StringConverter.convertTimeToString(bestLap.getTime()));
        stringBuilder.append("\nDuration: ");
        stringBuilder.append(String.format("%s", StringConverter.convertDurationToString(bestLap.getDuration())));
        stringBuilder.append("\nAverage Speed: ");
        stringBuilder.append(bestLap.getAverageSpeed());

        System.out.println(stringBuilder.toString());

    }

    public static void bestLapOfEachPilot(HashMap<String, Lap> laps){
        for (String key : laps.keySet()) {
            System.out.print("\nPilot: " + key);
            bestLap(laps.get(key));
        }

    }

    public static void result(ArrayList<Pilot> result){
        int counter = 1;
        System.out.println("Position | Pilot Code |   Pilot Name   | Completed Laps | Race Total Time");
        for (Pilot pilot : result) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(String.format("%4d",counter++));
            stringBuilder.append(String.format("%13d",pilot.getCode()));
            stringBuilder.append(String.format("%20s",pilot.getName()));
            stringBuilder.append(String.format("%12d", pilot.getNumberOfLaps()));
            stringBuilder.append(String.format("%21s", StringConverter.convertDurationToString(pilot.getRaceTotalTime())));//21

            System.out.println(stringBuilder.toString());

        }

    }

    public static void averageSpeed(HashMap<String, Float> speeds){
        for (String key : speeds.keySet()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Pilot: ").append(key)
                    .append(" \tAverage Speed: ").append(speeds.get(key));
            System.out.println(stringBuilder.toString());
        }

    }

    public static void timeAfterWinner(HashMap<String, Long> timeDiff){
        for (String key : timeDiff.keySet()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Pilot: ").append(key)
                    .append(" \tTime Difference from winner: ").append(StringConverter.convertDurationToString(timeDiff.get(key)));
            System.out.println(stringBuilder);
        }
    }
}
