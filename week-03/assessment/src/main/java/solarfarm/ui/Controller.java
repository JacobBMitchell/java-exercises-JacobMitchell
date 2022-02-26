package solarfarm.ui;

import solarfarm.domain.SolarFarmService;


public class Controller {
    SolarFarmService service;
    View view;

    public Controller(SolarFarmService service, View view) {
        this.service = service;
        this.view = view;
    }
    public void run() {
        System.out.println("running");
    }
}
