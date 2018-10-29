package Test;

import com.gympass.kart.Lap;
import com.gympass.kart.Race;
import com.gympass.kart.RaceBuilder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PilotTest {

    @Test
    void getLastLap() {
        RaceBuilder raceBuilder = new RaceBuilder("src/resources/kart-run-wrong-lap-numbers.log");
        Race race = raceBuilder.buildRace(4);
        Lap lap = race.getPilotById(38).getLastLap();

        RaceBuilder raceBuilderResult = new RaceBuilder("src/resources/kart-run-wrong-lap-numbers-result.log");
        Race raceResult = raceBuilderResult.buildRace(4);
        Lap lapResult = raceResult.getPilotById(38).getLastLap();


        assertEquals(lap.getTime(), lapResult.getTime());
        assertEquals(lap.getDuration(), lapResult.getDuration());
        assertEquals(lap.getAverageSpeed(), lapResult.getAverageSpeed());
        assertEquals(lap.getNumber(), lapResult.getNumber());

    }

    @Test
    void buildRaceNumberOfPilots() {
        RaceBuilder builder = new RaceBuilder("src/resources/kart-run.log");

        Race race = builder.buildRace(4);

        assertEquals(6, race.getPilots().size());
    }

    @Test
    void buildRaceNumberOfPilotsWIthWrongPilot() {
        RaceBuilder builder = new RaceBuilder("src/resources/kart-run-wrong-pilot.log");

        Race race = builder.buildRace(4);

        assertEquals(6, race.getPilots().size());
    }
}