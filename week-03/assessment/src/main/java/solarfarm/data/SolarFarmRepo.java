package solarfarm.data;


import solarfarm.models.SolarPanel;

import java.util.List;

public interface SolarFarmRepo {
    //crud
    //get all data
    List<SolarPanel> findAll() throws DataException;

    //get panels by section
    List<SolarPanel> getPanelSection(String section)throws DataException;

    //get panel by row, col, section(id)
    SolarPanel getBySRC(String section, int row, int col)throws DataException;

    //add
    SolarPanel add (SolarPanel panel) throws DataException;

    //update
    boolean update (SolarPanel panel, SolarPanel oldpanel)throws DataException;

    //delete
    boolean deleteBySRC(String section, int row, int col) throws DataException;
}
