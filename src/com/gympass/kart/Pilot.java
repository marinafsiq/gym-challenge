package com.gympass.kart;

import java.util.ArrayList;

public class Pilot {
    private int code;
    private String name;
    //private ArrayList<Race> races;
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

    /*
    public ArrayList<Race> getRaces() {
        return races;
    }

    public void setRaces(ArrayList<Race> races) {
        this.races = races;
    }
    */

    public ArrayList<Lap> getLaps() {
        return laps;
    }

    public void setLaps(ArrayList<Lap> laps) {
        this.laps = laps;
    }

    public void addLap(Lap lap){
        laps.add(lap);
    }
}
