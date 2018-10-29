package com.gympass.app;

import com.gympass.helper.PrintHelper;
import com.gympass.kart.Race;
import com.gympass.kart.RaceBuilder;

public class Main {

    public static void main(String[] args) {
	// write your code here
        RaceBuilder raceBuilder = new RaceBuilder("/Users/Marina/Downloads/kart-run.log");
        Race race = raceBuilder.buildRace();

        PrintHelper.result(race.getResult());
        System.out.println();

        PrintHelper.bestLap(race.findBestLapInRace());
        System.out.println();

        PrintHelper.bestLapOfEachPilot(race.bestLapOfEachPilot());
        System.out.println();

        PrintHelper.averageSpeed(race.calculatePilotsAverageSpeed());
        System.out.println();

        PrintHelper.timeAfterWinner(race.timeAfterWinner());


        System.out.println();


    }
}
