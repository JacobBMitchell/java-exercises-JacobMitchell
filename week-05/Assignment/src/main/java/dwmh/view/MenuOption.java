package dwmh.view;

public enum MenuOption {
    VIEWRESERVATIONSBYHOST("1. See Reservation By Host",1),
    CREATERESERVATION("2. Create a New Reservation",2),
    EDITEXISTING("3. Edit an Existing Reservation",3),
    CANCELRESERVATION("4. Cancel a Future Reservation",4),
    QUIT("0. Quit",0)
    ;

    private String message;
    private int value;

    MenuOption(String msg, int value){
        this.message = msg;
        this.value = value;
    }

    public static MenuOption choice(int value){
        for (MenuOption option: MenuOption.values()){
            if (option.getValue() == value){
                return option;
            }
        }
        return QUIT;
    }

    public String getMessage(){
        return message;
    }

    public int getValue() {
        return value;
    }
}
