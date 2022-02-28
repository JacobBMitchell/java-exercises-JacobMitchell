package solarfarm.ui;

import solarfarm.data.DataException;
import solarfarm.domain.SolarFarmResult;
import solarfarm.domain.SolarFarmService;
import solarfarm.models.SolarPanel;

import java.util.List;


public class Controller {
    private final SolarFarmService service;
    private final View view;

    public Controller(SolarFarmService service, View view) {
        this.service = service;
        this.view = view;
    }
    public void run() { // this is where all those data exceptions are handled
        view.printHeader("Welcome to the SolarFarm");
        try{
            runApp();
        }
        catch (DataException DE){
            view.displayErrors(List.of(DE.getMessage()));
        }
    }

    private void runApp() throws DataException{
        boolean exit = false;
        while(!exit){
            int choice = view.displayMenu(); //Menu options
            switch (choice) {
                case 0 -> exit = true;
                case 1 -> viewAll();
                case 2 -> viewBySection();
                case 3 -> addPanel();
                case 4 -> updatePanel();
                case 5 -> findBySRC();
                case 6 -> removeBySRC();
                default -> view.println("Not a valid input. ");
            }
        }
    }

    private void removeBySRC() throws DataException {
        view.printHeader("Remove by section, row, and column");
        SolarPanel mockPanel = view.getSRC();
        SolarFarmResult result = service.deleteBySRC(mockPanel.getSection(), mockPanel.getRow(), mockPanel.getCol());
        if (!result.noErrors()){
            view.displayErrors(result.getErrors());
        }
        else{
            String confirm = String.format("Panel in Section: %s Row: %d Column %d",mockPanel.getSection(),mockPanel.getRow(),mockPanel.getCol());
            view.println(confirm +" is deleted");
        }
    }

    private void findBySRC() throws DataException {
        SolarPanel mockPanel = view.getSRC();
        SolarFarmResult result = service.getBySRC(mockPanel.getSection(), mockPanel.getRow(), mockPanel.getCol());
        if (result.noErrors()){
            view.println(result.getPanel().toString());
        }
        else {
            view.displayErrors(result.getErrors());
        }
    }

    private void updatePanel() throws DataException {
        //get old panel
        view.printHeader("Choose a panel to update by its section, row, and column");
        SolarPanel oldPanel = view.getSRC();
        SolarFarmResult result1 = service.getBySRC(oldPanel.getSection(), oldPanel.getRow(),oldPanel.getCol());
        oldPanel = result1.getPanel();
        if (!result1.noErrors()){
            view.displayErrors(result1.getErrors());
            if(!view.tryAgain("Try to update again[y/n]: ")){
                return;
            }
            updatePanel(); // calls self
        }
        view.printHeader("Enter updated panel");
        SolarPanel newPanel = view.createUpdate(oldPanel);
        SolarFarmResult result = service.update(newPanel,oldPanel);
        if(result.noErrors()){
            view.println("Panel Updated! ");
        }
        else{
            view.displayErrors(result.getErrors());
        }

    }

    private void addPanel() throws DataException {
        SolarPanel newPanel = view.createPanel();
        SolarFarmResult result = service.add(newPanel);
        if(!result.noErrors()){
            view.displayErrors(result.getErrors());
        }
        else{
            view.println("Panel added!");
        }
    }

    private void viewBySection() throws DataException {
        view.displayAllSections(service.getAll());
        String section = view.getSection();
        view.displayPanels(service.getBySection(section));
    }

    private void viewAll() throws DataException {
        view.displayPanels(service.getAll());
    }
}
