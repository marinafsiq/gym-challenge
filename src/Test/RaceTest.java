package Test;

import com.gympass.helper.PrintHelper;
import com.gympass.kart.Race;
import com.gympass.kart.RaceBuilder;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class RaceTest {

    @Test
    void getResultRaceNoEnd(){
        RaceBuilder raceBuilder = new RaceBuilder("src/resources/kart-run.log");
        Race race = raceBuilder.buildRace(4);
        //testing if pilots finished the race (completed the minimum number of laps)
        assertEquals(race.getPilotById(38).getLastLap(), null);
    }

}