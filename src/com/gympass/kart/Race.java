package com.gympass.kart;

import com.gympass.helper.StringConverter;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

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
        int counter = 1;


        System.out.println("Position | Pilot Code |   Pilot Name   | Completed Laps | Race Total Time");
        //                   "   1          038       R.BARRICHELLO           4            11:04.414   "
        for (Pilot pilot : result) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(String.format("%4d",counter++));
            stringBuilder.append(String.format("%13d",pilot.getCode()));
            stringBuilder.append(String.format("%20s",pilot.getName()));
            stringBuilder.append(String.format("%12d", pilot.getNumberOfLaps()));
            stringBuilder.append(String.format("%21s", StringConverter.convertDurationToString(pilot.getRaceTotalTime())));//21

            System.out.println(stringBuilder.toString());

        }

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
        return bestLap;
    }





    //Descobrir a melhor volta de cada piloto
    public ArrayList<Lap> bestLapOfEachPilot(){
        ArrayList<Lap> laps = new ArrayList<Lap>();
        for (Pilot pilot : pilots) {
            System.out.println(pilot.getCode() + " - " + pilot.getName());
            laps.add(findBestLapInSet(pilot.getLaps()));
        }
        return laps;
    }

    //Calcular a velocidade média de cada piloto durante toda corrida
    public ArrayList<Float> calculatePilotsAverageSpeed(){
        ArrayList<Float> averageSpeed = new ArrayList<>();
        for (Pilot pilot : pilots) {
            float avgSpeed = calculatePilotAverageSpeed(pilot);
            averageSpeed.add(avgSpeed);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Pilot: ").append(pilot.getCode()).append("-").append(pilot.getName())
                    .append(" \tAverage Speed: ").append(avgSpeed);
            System.out.println(stringBuilder.toString());
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
    public ArrayList<Long> timeAfterWinner(){
        Pilot winner = getResult().get(0);
        ArrayList<Long> differences = new ArrayList<Long>();
        long difference = 0;
        for (Pilot pilot : pilots) {
            difference = pilot.getLastLap().getTime().getTime() - winner.getLastLap().getTime().getTime();
            differences.add(difference);

            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Pilot: ").append(pilot.getCode()).append("-").append(pilot.getName())
                    .append(" \tTime Difference from winner: ").append(StringConverter.convertDurationToString(difference));
            System.out.println(stringBuilder);
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
