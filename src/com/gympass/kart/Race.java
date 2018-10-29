package com.gympass.kart;

import com.gympass.helper.PrintHelper;
import com.gympass.helper.StringConverter;

import java.time.Duration;
import java.util.*;

public class Race {
    private String name;
    private Date date;
    private String place;
    private ArrayList<Lap> laps = new ArrayList<Lap>();
    private ArrayList<Pilot> pilots = new ArrayList<Pilot>();

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

    public boolean containsPilot(int code){
        for (Pilot pilot: pilots) {
            if (pilot.getCode() == code)
                return true;
        }
        return false;
    }

    public Pilot getPilotById(int code){
        for (Pilot pilot: pilots) {
            if (pilot.getCode() == code)
                return pilot;
        }
        return null;
    }

    public ArrayList<Pilot> getResult(){
        ArrayList<Pilot> result = (ArrayList<Pilot>)pilots.clone();
        result.sort(byLapsAndTime);
        return result;
    }

    //Descobrir a melhor volta da corrida
    //Teria que checar se existem laps identicos
    public Lap findBestLapInRace(){
        return findBestLapInSet(laps);
    }

    public Lap findBestLapInSet(ArrayList<Lap> laps){
        Lap bestLap = laps.get(0);
        Duration smallestTime = bestLap.getDuration();

        for (Lap lap : laps) {
            if(lap.getDuration().compareTo(smallestTime) < 0) {
                smallestTime = lap.getDuration();
                bestLap = lap;
            }
        }
        return bestLap;
    }

    //Descobrir a melhor volta de cada piloto
    public HashMap<String, Lap> bestLapOfEachPilot(){
        HashMap<String, Lap> laps = new HashMap<String, Lap>();
        for (Pilot pilot : pilots) {
            laps.put(pilot.getName(), findBestLapInSet(pilot.getLaps()));
        }
        return laps;
    }

    //Calcular a velocidade média de cada piloto durante toda corrida
    public HashMap<String, Float> calculatePilotsAverageSpeed(){
        HashMap<String, Float> averageSpeed = new HashMap<String, Float>();
        for (Pilot pilot : pilots) {
            float avgSpeed = calculatePilotAverageSpeed(pilot);
            averageSpeed.put(pilot.getName(), avgSpeed);
        }
        return averageSpeed;
    }

    public float calculatePilotAverageSpeed(Pilot pilot){
        float average = 0;
        for (Lap lap : pilot.getLaps()) {
            average += lap.getAverageSpeed();
        }
        return (float)average/pilot.getLaps().size();
    }

    //Descobrir quanto tempo cada piloto chegou após o vencedor
    public HashMap<String, Long> timeAfterWinner(){
        Pilot winner = getResult().get(0);
        Lap winnerLap = winner.getLastLap();
        Date winnerTime = winnerLap.getTime();
        HashMap<String, Long> differences = new HashMap<String, Long>();
        long difference = 0;
        for (Pilot pilot : pilots) {
            Lap lap = pilot.getLastLap();
            Date time = lap.getTime();
            difference = time.getTime() - winnerTime.getTime();
            differences.put(pilot.getName(), difference);
        }
        return differences;
    }


    Comparator<Pilot> byLapsAndTime = new Comparator<Pilot>() {
        @Override
        public int compare(Pilot p1, Pilot p2) {
            if(p1.getNumberOfLaps() > p2.getNumberOfLaps())
                return -1;
            else if(p1.getNumberOfLaps() < p2.getNumberOfLaps())
                return 1;
            else {
                //if p1 finishes before p2 (time compareTo result is '< 0'), p1 needs comes first in the race result
                return (p1.getLastLap().getTime().compareTo(p2.getLastLap().getTime()));
            }
        }
    };


}
