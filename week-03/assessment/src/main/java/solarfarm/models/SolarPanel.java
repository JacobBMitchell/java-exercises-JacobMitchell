package solarfarm.models;

import java.util.Objects;

public class SolarPanel {
    private String section;
    private int row;
    private int col;
    private int year;
    private Material material;
    private boolean isTracking;

    public SolarPanel() {
    }
    public SolarPanel(String section, int row, int col, int year, Material material, boolean isTracking) {
        this.section = section;
        this.row = row;
        this.col = col;
        this.year = year;
        this.material = material;
        this.isTracking = isTracking;
    }



    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public boolean isTracking() {
        return isTracking;
    }

    public void setTracking(boolean tracking) {
        isTracking = tracking;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SolarPanel that = (SolarPanel) o;
        return row == that.row && col == that.col && year == that.year && isTracking == that.isTracking && Objects.equals(section, that.section) && material == that.material;
    }

    @Override
    public int hashCode() {
        return Objects.hash(section, row, col, year, material, isTracking);
    }

    @Override
    public String toString() {
        return "SolarPanel:: " +
                "section: " + section +
                ", row: " + row +
                ", col: " + col +
                ", year: " + year +
                ", material: " + material.getMat() +
                ", isTracking: " + isTracking;
    }
}


