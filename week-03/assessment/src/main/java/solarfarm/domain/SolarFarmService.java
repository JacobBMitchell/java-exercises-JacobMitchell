package solarfarm.domain;

import solarfarm.data.SolarFarmRepo;

public class SolarFarmService {
    SolarFarmRepo repository;

    public SolarFarmService(SolarFarmRepo repository) {
        this.repository = repository;
    }
}
