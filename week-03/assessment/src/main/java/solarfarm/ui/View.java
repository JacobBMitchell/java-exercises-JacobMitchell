package solarfarm.ui;

import solarfarm.models.Material;
import solarfarm.models.SolarPanel;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class View {
    private final Scanner scn = new Scanner(System.in);

    public void printHeader(String message){
        int length = message.length();
        System.out.println();
        System.out.println(message);
        System.out.println("-".repeat(length));
    }

    public void displayErrors(List<String> message) {
        printHeader("ERRORS:");
        for (String error: message){
            System.out.println(error);
        }
    }

    public int displayMenu() {
        printHeader("Please choose an option");
        System.out.println("1: View all panels");
        System.out.println("2: View all panels in a section");
        System.out.println("3: Add a new panel");
        System.out.println("4: Update existing panel");
        System.out.println("5: Find panel by section, row, column");
        System.out.println("6: Remove panel by section, row, column");
        System.out.println("0: Exit");
        return getInt("Choice: ",0,6);
    }

    private int getInt(String msg){
        int number;
        try{
            String input = getString(msg);
            number = Integer.parseInt(input);
        } catch (NumberFormatException nfe){
            println("Not a number");
            number = getInt(msg);
        }
        return  number;
    }

    private String getString(String msg) {
        print(msg);
        return scn.nextLine();
    }

    private void print(String msg) {
        System.out.print(msg);
    }

    private int getInt(String msg, int min, int max) {
        int selection = getInt(msg);
        if (selection < min || selection > max){
            println("Number is out of range");
            selection = getInt(msg,min,max);
        }
        return selection;
    }

    public void println(String s) {
        System.out.println(s);
    }

    public SolarPanel getSRC() {
        SolarPanel SRC = new SolarPanel();
        String section = getString("Input section: ");
        int row = getInt("Input Row: ",1,250);
        int col = getInt("Input Column: ",1,250);
        SRC.setSection(section);
        SRC.setRow(row);
        SRC.setCol(col);
        return SRC;
    }
    public boolean tryAgain(String msg){
        return getString(msg).equalsIgnoreCase("y");
    }

    public SolarPanel createPanel() {
        SolarPanel panel = new SolarPanel();
        String section = getString("Input Section: ");
        int row = getInt("Input Row: ",1,250);
        int col = getInt("Input Column: ",1,250);
        int year = getInt("Input Year: ",1956,2022);
        Material mat = getMaterial();
        boolean doesTrack = doesTrack();
        panel.setSection(section);
        panel.setRow(row);
        panel.setCol(col);
        panel.setYear(year);
        panel.setMaterial(mat);
        panel.setTracking(doesTrack);
        
        return panel;
    }

    public SolarPanel createUpdate(SolarPanel oldPanel) {
        SolarPanel panel = new SolarPanel();
        String section = getString("Input Section (" + oldPanel.getSection() + "): ");
        int row = getInt("Input Row (" +oldPanel.getRow() + "): ",1,250); //TODO allow for blank input (default)
        int col = getInt("Input Column (" +oldPanel.getCol() + "): ",1,250);
        int year = getInt("Input Year ("+ oldPanel.getYear() +"): ",1956,2022);
        println("("+oldPanel.getMaterial().getMat()+")");
        Material mat = getMaterial();
        print("("+oldPanel.isTracking()+") ");
        boolean doesTrack = doesTrack();
        panel.setSection(section.isBlank()? oldPanel.getSection() :section);
        panel.setRow(row);
        panel.setCol(col);
        panel.setYear(year);
        panel.setMaterial(mat);
        panel.setTracking(doesTrack);

        return panel;
    }

    private boolean doesTrack() {
        String choice = getString("Does it track?[y/n] ");
        return choice.equalsIgnoreCase("y");
    }

    private Material getMaterial() {
        int i = 1;
        for(Material m: Material.values()){
            println(i +": "+ m.getMat());
            i++;
        }
        int choice = getInt("Pick a Material: ",1,5);
        return Material.values()[choice-1];
    }

    public String getSection() {
        return getString("What section are you looking for: ");
    }

    public void displayPanels(List<SolarPanel> panels) {
        if (panels.size() != 0) {
            for (SolarPanel panel : panels) {
                println(panel.toString());
            }
        }
        else{
            println("There are no panels");
        }
    }

    public void displayAllSections(List<SolarPanel> all) {
        printHeader("These are all the sections");
        List<String> sections = new ArrayList<>();
        for (SolarPanel panel: all){
            if (!sections.contains(panel.getSection())){
                sections.add(panel.getSection());
                println(panel.getSection());
            }
        }
    }
}
