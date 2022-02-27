package solarfarm.domain;

import solarfarm.models.SolarPanel;

import java.util.ArrayList;

public class SolarFarmResult {
    private ArrayList<String> errors = new ArrayList<>();
    private SolarPanel panel;

    public ArrayList<String> getErrors() {
        return new ArrayList<>(errors);
    }

    public void addErrors(String error) {
        this.errors.add(error);
    }

    public boolean noErrors() {return errors.isEmpty();}

    public SolarPanel getPanel() {
        return panel;
    }

    public void setPanel(SolarPanel panel) {
        this.panel = panel;
    }
}
