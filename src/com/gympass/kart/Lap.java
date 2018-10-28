package com.gympass.kart;

import java.util.Date;

public class Lap {
    private int number;
    private Date duration;
    private Date time;
    private float averageSpeed;
    private Pilot pilot;
    private Race race;

    protected Lap(Date time, int number, Date duration, float averageSpeed){
        this.time = time;
        this.number = number;
        this.duration = duration;
        this.averageSpeed = averageSpeed;
    }

    public Date getDuration() {
        return duration;
    }

    public void setDuration(Date duration) {
        this.duration = duration;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public float getAverageSpeed(){
        return averageSpeed;
    }

    public void setAverageSpeed(float averageSpeed){
        this.averageSpeed = averageSpeed;
    }

    public Pilot getPilot() {
        return pilot;
    }

    public void setPilot(Pilot pilot) {
        this.pilot = pilot;
    }

    public Race getRace() {
        return race;
    }

    public void setRace(Race race) {
        this.race = race;
    }

    public int getNumber() {

        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
