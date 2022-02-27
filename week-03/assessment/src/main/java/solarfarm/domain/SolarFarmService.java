package solarfarm.domain;

import solarfarm.data.DataException;
import solarfarm.data.SolarFarmRepo;
import solarfarm.models.SolarPanel;

import java.util.ArrayList;
import java.util.List;

public class SolarFarmService {

    private final SolarFarmRepo repository;

    public SolarFarmService(SolarFarmRepo repository) {
        this.repository = repository;
    }

    public List<SolarPanel> getAll() throws DataException{
        return new ArrayList<>(repository.findAll());
    }

    public List<SolarPanel> getBySection(String section) throws DataException{
        return new ArrayList<>(repository.getPanelSection(section));
    }


    public SolarFarmResult add(SolarPanel panel) throws DataException{
        SolarFarmResult result = validation(panel);
        if (panel == null) {
            return result;
        }
        List<SolarPanel> panels = repository.findAll();
        for (SolarPanel paneli : panels){
            if (panel.getRow() == paneli.getRow() && panel.getCol() == paneli.getCol() &&
            panel.getSection().equals(paneli.getSection())){
                result.addErrors(String.format("Panel in section: %s, row: %d, column: %d already exists",panel.getSection(),panel.getRow(),panel.getCol()));
            }
        }
        if (result.noErrors()){
            panel = repository.add(panel);
            result.setPanel(panel);
        }
        return result;
    }

    public SolarFarmResult update(SolarPanel newPanel, SolarPanel oldPanel)throws DataException{
        SolarFarmResult result = validation(newPanel);
        List<SolarPanel> panels = repository.findAll();
        boolean hasOldPanel = false;
        for (SolarPanel panel: panels){
            if (panel.equals(newPanel)){
                result.addErrors("Panel already exists");
            }
            if (panel.equals(oldPanel)){
                hasOldPanel = true;
            }
        }
        if(!hasOldPanel){
            result.addErrors("Does not have old panel to update");
        }
        if(result.noErrors()){
            if(repository.update(newPanel, oldPanel)){
                result.setPanel(newPanel);
            }
            else{
                result.addErrors("Could not update old panel");
            }
        }
        return result;
    }

    public SolarFarmResult deleteBySRC(String section, int row, int col) throws DataException {
        SolarFarmResult result = new SolarFarmResult();
        if (!repository.deleteBySRC(section, row, col)){
            result.addErrors(String.format("Panel in section: %s, row: %d, column: %d doesn't exists",section,row,col));
        }
        return result;
    }

    public SolarFarmResult getBySRC(String section, int row, int col)throws DataException{
        SolarFarmResult result = new SolarFarmResult();
        SolarPanel panel = repository.getBySRC(section, row, col);
        if (panel == null){
            result.addErrors(String.format("Panel in section: %s, row: %d, column: %d doesn't exists",section,row,col));
        }
        result.setPanel(panel);
        return result;
    }

    private SolarFarmResult validation(SolarPanel panel) {
        SolarFarmResult result = new SolarFarmResult();
        if (panel == null){
            result.addErrors("Cannot have null Solar panel");
            return result;
        }
        if(panel.getRow() <= 0 || panel.getRow() > 250){
            result.addErrors("Row is out of range");
        }
        if (panel.getCol() <= 0 || panel.getCol() > 250){
            result.addErrors("Column is out of range");
        }
        if (panel.getSection() == null || panel.getSection().isBlank()){
            result.addErrors("Section is required");
        }
        if (panel.getYear() >2022 || panel.getYear() < 1954){
            result.addErrors("Year is out of valid range");
        }
        return result;
    }
}
