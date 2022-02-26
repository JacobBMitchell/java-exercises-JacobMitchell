package solarfarm.data;

import solarfarm.models.Material;
import solarfarm.models.SolarPanel;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SolarFarmFileRepo implements SolarFarmRepo{

    private final String filePath;
    private final String delimiter = "-_-";

    public SolarFarmFileRepo(String filePath) {
        this.filePath = filePath;

    }

    @Override
    public List<SolarPanel> findAll() throws DataException {
        ArrayList<SolarPanel> panels = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            for (String line = reader.readLine(); line != null; line = reader.readLine()){
                SolarPanel panel = lineToPanel(line);
                if (panel != null) {
                    panels.add(panel);
                }
            }
        } catch (IOException e) {
            throw new DataException("Could not open the file path: " + filePath, e);
        }
        return panels;
    }

    private SolarPanel lineToPanel(String line) {
        String[] entries = line.split(delimiter);

        if (entries.length != 6){
            return null;
        }
        SolarPanel toReturn = new SolarPanel();
        toReturn.setSection(entries[0]);
        toReturn.setRow(Integer.parseInt(entries[1]));
        toReturn.setCol(Integer.parseInt(entries[2]));
        toReturn.setYear(Integer.parseInt(entries[3]));
        toReturn.setMaterial(Material.valueOf(entries[4]));
        toReturn.setTracking(Boolean.parseBoolean(entries[5]));
        return  toReturn;
    }

    private String panelToLine(SolarPanel panel){
        StringBuilder builder = new StringBuilder();
        builder.append(panel.getSection() + delimiter);
        builder.append(panel.getRow() + delimiter);
        builder.append(panel.getCol() + delimiter);
        builder.append(panel.getYear() +delimiter);
        builder.append(panel.getMaterial()+delimiter);
        builder.append(panel.isTracking());
        return builder.toString();
    }

    @Override
    public List<SolarPanel> getPanelSection(String section) throws DataException {
        List<SolarPanel> panels = findAll();
        List<SolarPanel> panelSection = new ArrayList<>();
        for (SolarPanel panel: panels){
            if (panel.getSection().equals(section)){
                panelSection.add(panel);
            }
        }
        return panelSection;
    }

    @Override
    public SolarPanel getBySRC(String section, int row, int col) throws DataException {
        List<SolarPanel> panels = findAll();
        for (SolarPanel panel: panels){
            if (panel.getSection().equals(section) && panel.getRow() == row && panel.getCol() == col){
                return panel;
            }
        }
        return null;
    }

    @Override
    public SolarPanel add(SolarPanel panel) throws DataException {
        List<SolarPanel> panels = findAll();
        panels.add(panel);
        writeToFile(panels);
        return panel;
    }

    @Override
    public boolean update(SolarPanel panel, SolarPanel oldPanel) throws DataException {
        if (deleteBySRC(oldPanel.getSection(), oldPanel.getRow(),oldPanel.getCol())){
            return add(panel) != null;
        }
        return false;
    }

    @Override
    public boolean deleteBySRC(String section, int row, int col) throws DataException {
        List<SolarPanel> panels = findAll();
        SolarPanel panelToRemove = getBySRC(section,row,col);
        panels.remove(panelToRemove);
        writeToFile(panels);
        return true;
    }

    private void writeToFile(List<SolarPanel> panels)throws DataException{
        try (PrintWriter pw = new PrintWriter(filePath)){
            for(SolarPanel panel : panels) {
                pw.println(panelToLine(panel));
            }
        } catch (FileNotFoundException e) {
            throw new DataException("Could not write to file: " +filePath, e);
        }
    }
}
