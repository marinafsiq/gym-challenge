package Test;

import com.gympass.kart.Race;
import com.gympass.kart.RaceBuilder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RaceBuilderTest {

    @Test
    void buildRaceWrongFile() {
        RaceBuilder race = new RaceBuilder("tes");

        assertNull(race.buildRace(4));
    }

    @Test
    void buildRaceEmptyFile() {
        RaceBuilder race = new RaceBuilder("src/resources/kart-run-empty.txt");

        assertNull(race.buildRace(4));
    }

    @Test
    void buildRaceSpaceBetweenLogLines() {
        RaceBuilder race = new RaceBuilder("src/resources/kart-run-space.txt");

        assertNotNull(race.buildRace(4));
    }

}