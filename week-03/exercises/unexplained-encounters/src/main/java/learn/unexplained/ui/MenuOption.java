package learn.unexplained.ui;

public enum MenuOption {
    EXIT("Exit"),
    DISPLAY_ALL("Display All Encounters"),
    ADD("Add An Encounter"),
    ENCOUNTER_BY_TYPE("Display All Encounters By Type"),
    UPDATE("Update Encounters");

    private String message;

    MenuOption(String name) {
        this.message = name;
    }

    public String getMessage() {
        return message;
    }
}
