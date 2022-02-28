package solarfarm.data;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import solarfarm.models.Material;
import solarfarm.models.SolarPanel;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolarFarmFileRepoTest {
    SolarFarmFileRepo repo = new SolarFarmFileRepo("./test_data/TestData.txt");
    SolarPanel sp1 = new SolarPanel("Home",1,1,2020, Material.AMORPHOUS_SILICON,true);
    SolarPanel sp2 = new SolarPanel("Home",1,2,2020,Material.AMORPHOUS_SILICON,true);
    SolarPanel sp3 =  new SolarPanel("Home", 1,3, 2019,Material.CADMIUM_TELLURIDE,false);
    SolarPanel sp4 = new SolarPanel("Away", 1,1,2019,Material.AMORPHOUS_SILICON,true);
    @BeforeEach
    void setBaseData() throws DataException { //makes a new clear and confirmed file each test.
        File file = new File("./test_data/TestData.txt");
        file.delete();
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        repo.add(sp1);
        repo.add(sp2);
        repo.add(sp3);
        repo.add(sp4);


    }

    @Test
    void findAll() throws DataException{
        List<SolarPanel> panels = repo.findAll();
        assertEquals(sp1, panels.get(0));
        assertEquals(sp2, panels.get(1));
        assertEquals(sp3, panels.get(2));
        assertEquals(sp4, panels.get(3));

        //Not all fields are the same
        assertNotEquals(sp2, panels.get(0));

    }

    @Test
    void getPanelSection() throws DataException {
        List<SolarPanel> panelSec = repo.getPanelSection("Home");
        assertEquals(3,panelSec.size());
        assertEquals(sp3, panelSec.get(2));

        assertNotEquals(sp3,panelSec.get(1));

    }

    @Test
    void getBySRC() throws DataException {
        assertEquals(sp1,repo.getBySRC("Home",1,1));
        assertNotEquals(sp1,repo.getBySRC("Home",1,2));
    }

    @Test
    void add() throws DataException {
        SolarPanel sp5 = new SolarPanel("Away", 1,3,2014,Material.COPPER_INDIUM_GALLIUM_SELENIDE,true);
        repo.add(sp5);
        assertEquals(5,repo.findAll().size());


    }

    @Test
    void update() throws DataException {
        SolarPanel sp5 = new SolarPanel("Away", 1,1,2014,Material.COPPER_INDIUM_GALLIUM_SELENIDE,true);
        repo.update(sp5,sp4);
        List<SolarPanel> all = repo.findAll();
        assertEquals(sp5, all.get(3));
        assertEquals(4,all.size());

    }

    @Test
    void deleteBySRC() throws DataException {
        repo.deleteBySRC("Home",1,1);
        List<SolarPanel> all = repo.findAll();
        assertEquals(3, all.size());
        assertFalse(all.contains(sp1));
    }
}