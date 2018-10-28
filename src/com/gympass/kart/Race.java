package com.gympass.kart;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Race {
    private String name;
    private Date date;
    private String place;
    private ArrayList<Lap> laps;
    private ArrayList<Pilot> pilots;

    protected Race(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public ArrayList<Lap> getLaps() {
        return laps;
    }

    public void setLaps(ArrayList<Lap> laps) {
        this.laps = laps;
    }

    public ArrayList<Pilot> getPilots() {
        return pilots;
    }

    public void setPilots(ArrayList<Pilot> pilots) {
        this.pilots = pilots;
    }

    public void addPilot(Pilot pilot){
        pilots.add(pilot);
    }

    public void addLap(Lap lap){
        laps.add(lap);
    }
}
