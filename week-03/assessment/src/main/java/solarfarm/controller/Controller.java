package solarfarm.controller;

import solarfarm.domain.SolarFarmService;
import solarfarm.ui.View;

public class Controller {
    SolarFarmService service;
    View view;

    public Controller(SolarFarmService service, View view) {
        this.service = service;
        this.view = view;
    }
}
