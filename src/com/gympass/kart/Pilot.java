package com.gympass.kart;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;

public class Pilot {
    private int code;
    private String name;
    private ArrayList<Lap> laps = new ArrayList<Lap>();

    public Pilot(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Lap> getLaps() {
        return laps;
    }

    public void setLaps(ArrayList<Lap> laps) {
        this.laps = laps;
    }

    public void addLap(Lap lap){
        laps.add(lap);
    }

    public int getNumberOfLaps(){
        return laps.size();
    }

    public Lap getLastLap(){
        int counter = laps.size();
        for (int i=counter-1; i>=0; i--) {
            Lap lap = laps.get(i);
            if(lap.getNumber() == counter)
                return lap;
        }

        //if problem finding last lap by lap number, find last lap by biggest time
        return getLastLapByTime();
    }

    public Lap getLastLapByTime(){
        Lap firstLapInArray = laps.get(0);
        Date biggestTime = firstLapInArray.getTime();
        Lap lastLap = null;

        for (Lap lap : laps) {
            if(lap.getTime().compareTo(biggestTime) > 0) {
                biggestTime = lap.getTime();
                lastLap = lap;
            }
        }
        return lastLap;
    }

    public Duration getRaceTotalTime(){
        Duration totalTime = Duration.ofMinutes(0);
        for (Lap lap : laps) {
            totalTime = totalTime.plus(lap.getDuration());
        }
        return totalTime;
    }

}
