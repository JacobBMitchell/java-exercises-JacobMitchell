import java.util.Scanner;

public class Exercise10 {

    public static void main(String[] args) {
        // BALLOON GAME
        Scanner console = new Scanner(System.in);

        // 1. Instantiate three balloons of different colors.
        Balloon red = new Balloon("red");
        Balloon blue = new Balloon("blue");
        Balloon green = new Balloon("Green");
        boolean playing = true;
        do {

            System.out.println("Inflate? [y/n]: ");
            if (console.nextLine().equalsIgnoreCase("y")) {
                red.inflate();
                blue.inflate();
                green.inflate();
                // 2. If the user confirms an inflate, inflate each balloon.
                if (red.isExploded() || green.isExploded()|| blue.isExploded()){
                    playing = false;
                }
            }

            // 3. When one or more balloons explode, stop the loop.
        } while (playing);

        // 4. Print the color of the winners (balloons that exploded).
        if (red.isExploded()){
            System.out.println(red.getColor()+" has won");
        }
        if (blue.isExploded()){
            System.out.println(blue.getColor()+" has won");
        }
        if (green.isExploded()){
            System.out.println(green.getColor()+" has won");
        }
    }
}
