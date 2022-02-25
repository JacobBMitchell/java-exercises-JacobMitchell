package solarfarm;

import solarfarm.data.SolarFarmFileRepo;
import solarfarm.data.SolarFarmRepo;
import solarfarm.domain.SolarFarmService;
import solarfarm.ui.Controller;
import solarfarm.ui.View;

public class App {
    SolarFarmFileRepo repository = new SolarFarmFileRepo();
    SolarFarmService service = new SolarFarmService(repository);

    View view;
    
    Controller controller = new Controller(service,view);
}
