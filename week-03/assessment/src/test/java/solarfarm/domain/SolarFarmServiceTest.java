package solarfarm.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import solarfarm.data.DataException;
import solarfarm.data.SolarFarmFileRepo;
import solarfarm.models.Material;
import solarfarm.models.SolarPanel;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolarFarmServiceTest {
    SolarFarmFileRepo repo = new SolarFarmFileRepo("./test_data/TestData.txt");
    SolarFarmService service = new SolarFarmService(repo);
    SolarPanel sp1 = new SolarPanel("Home",1,1,2020, Material.AMORPHOUS_SILICON,true);
    SolarPanel sp2 = new SolarPanel("Home",1,2,2020,Material.AMORPHOUS_SILICON,true);
    SolarPanel sp3 =  new SolarPanel("Home", 1,3, 2019,Material.CADMIUM_TELLURIDE,false);
    SolarPanel sp4 = new SolarPanel("Away", 1,1,2019,Material.AMORPHOUS_SILICON,true);

    @BeforeEach
    void setUp() throws DataException {
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
    void getAll() throws DataException {
        assertEquals(repo.findAll(),service.getAll());
    }

    @Test
    void getBySection() throws DataException {
        List<SolarPanel> homePanels = service.getBySection("Home");
        assertEquals(homePanels.get(0),sp1);
        assertEquals(3, homePanels.size());

        assertEquals(0, service.getBySection("NoWhere").size());

    }

    @Test
    void add() throws DataException {
        SolarPanel sp5 = new SolarPanel("Away", 1, 2, 2019, Material.AMORPHOUS_SILICON, true);
        SolarFarmResult result1 = service.add(sp5);
        List<SolarPanel> panels = service.getAll();
        assertEquals(sp5, panels.get(4));
        assertEquals(5, panels.size());
        assertEquals(0, result1.getErrors().size());
        assertEquals(sp5, result1.getPanel());

        SolarFarmResult result2 = service.add(sp1);
        panels = service.getAll();
        assertEquals(5, panels.size()); // no change in size
        assertEquals("Panel in section: Home, row: 1, column: 1 already exists", result2.getErrors().get(0));
        assertNull(result2.getPanel());
    }

    @Test
    void validation() throws DataException {
        SolarPanel sp6 = new SolarPanel("", -1,251,2023,Material.AMORPHOUS_SILICON,true);
        SolarFarmResult reuslt3= service.add(sp6);
        assertNull(reuslt3.getPanel());
        assertEquals("Row is out of range",reuslt3.getErrors().get(0));
        assertEquals("Column is out of range",reuslt3.getErrors().get(1));
        assertEquals("Section is required",reuslt3.getErrors().get(2));
        assertEquals("Year is out of valid range", reuslt3.getErrors().get(3));

        SolarPanel sp7 = null;
        SolarFarmResult result4 = service.add(sp7);
        assertEquals("Cannot have null Solar panel",result4.getErrors().get(0));
    }

    @Test
    void update() throws DataException {
        SolarPanel sp3new =  new SolarPanel("Home", 1,3, 2020,Material.CADMIUM_TELLURIDE,false);
        SolarFarmResult result = service.update(sp3new,sp3); //updated the year
        assertTrue(result.noErrors());
        assertEquals(sp3new, result.getPanel());

        SolarPanel sp3new2 = new SolarPanel("Home", 1,3, 2020,Material.CADMIUM_TELLURIDE,false);
        SolarFarmResult result1 = service.update(sp3new2,sp3new);
        assertFalse(result1.noErrors());
        assertNull(result1.getPanel());
        assertEquals("Panel already exists",result1.getErrors().get(0)); //break up for each attempt

        SolarPanel toAdd = new SolarPanel("Home", 1,6, 2020,Material.CADMIUM_TELLURIDE,false);
        SolarPanel spNotAdded = new SolarPanel("Home", 1,5, 2020,Material.CADMIUM_TELLURIDE,false);
        SolarFarmResult result3 = service.update(toAdd,spNotAdded);
        assertFalse(result3.noErrors());
        assertNull(result3.getPanel());
        assertEquals("Does not have old panel to update",result3.getErrors().get(0));
    }

    @Test
    void deleteBySRC() throws DataException {
        SolarFarmResult result = service.deleteBySRC("Home",1,1);
        List<SolarPanel> panels = service.getAll();
        assertEquals(3,panels.size());
        assertNull(result.getPanel());
        assertFalse(panels.contains(sp1));

        SolarFarmResult result1 = service.deleteBySRC("Nowhere", 3, 3);
        assertEquals("Panel in section: Nowhere, row: 3, column: 3 doesn't exists",result1.getErrors().get(0));
        assertNull(result1.getPanel());

    }

    @Test
    void getBySRC() throws DataException {
        assertEquals(sp1, service.getBySRC("Home",1,1).getPanel());

        SolarFarmResult result = service.getBySRC("Nowhere", 3,3);//doesn't exist
        assertFalse(result.noErrors());
        assertEquals("Panel in section: Nowhere, row: 3, column: 3 doesn't exists", result.getErrors().get(0));
    }
}