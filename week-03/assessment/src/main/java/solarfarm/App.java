package solarfarm;

import solarfarm.data.SolarFarmFileRepo;
import solarfarm.domain.SolarFarmService;
import solarfarm.ui.Controller;
import solarfarm.ui.View;

public class App {
    public static void main(String[] args) {
        SolarFarmFileRepo repository = new SolarFarmFileRepo("./test_data/TestData.txt");
        SolarFarmService service = new SolarFarmService(repository);

        View view = new View();

        Controller controller = new Controller(service, view);
        controller.run();
    }

}

