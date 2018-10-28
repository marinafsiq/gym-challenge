package com.gympass.kart;

import com.gympass.helper.LogSerializer;
import com.gympass.helper.StringConverter;

import java.util.ArrayList;

public class RaceBuilder {
    private Race race;
    private String logPath;

    public RaceBuilder(String logPath){
        this.logPath = logPath;
    }

    public Race buildRace(){
        race = new Race();
        ArrayList<String[]> lines = LogSerializer.getLinesSplitted(logPath);

        for (String[] line : lines) {
            
            Lap lap = new Lap(StringConverter.convertToTime(line[0]),
                    Integer.parseInt(line[3]),
                    StringConverter.convertToDuration(line[4]),
                    Float.parseFloat(line[5])
                    );
            Pilot pilot = new Pilot(Integer.parseInt(line[1]), line[2]);

            race.addLap(lap);
            race.addPilot(pilot);

        }
        return race;
    }
}
