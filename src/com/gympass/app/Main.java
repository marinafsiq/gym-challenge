package com.gympass.app;

import com.gympass.kart.Race;
import com.gympass.kart.RaceBuilder;

public class Main {

    public static void main(String[] args) {
	// write your code here
        RaceBuilder raceBuilder = new RaceBuilder("/Users/Marina/Downloads/kart-run.log");
        Race race = raceBuilder.buildRace();


    }
}
