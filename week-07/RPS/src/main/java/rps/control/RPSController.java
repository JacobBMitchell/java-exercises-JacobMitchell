package rps.control;

import org.springframework.web.bind.annotation.*;


@RestController
public class RPSController {
    String[] choices = {"Rock","Paper","Scissors"};

    @PostMapping("/api/guess")
    public String play(@RequestBody RPSThrow choice) {

        for (String play: choices){
            if (play.equalsIgnoreCase(choice.getWhateverYouWant())){
                return playGame(choice.getWhateverYouWant());
            }
        }

        return "Not a valid choice";
    }

    private String playGame(String choice) {
        int ind = (int) (Math.random()* choices.length);
        String comp = choices[ind];
        if (choice.equalsIgnoreCase(comp)){
            return "Its a tie\nYou played: "+choice+"\nWe played: "+comp;
        }
        if (choice.equalsIgnoreCase("Scissors") &&
        comp.equalsIgnoreCase("Paper")){
            return "WINNER \nYou played: "+choice+"\nWe played: "+comp;
        }
        if (choice.equalsIgnoreCase("Paper") &&
                comp.equalsIgnoreCase("Rock")){
            return "WINNER \nYou played: "+choice+"\nWe played: "+comp;
        }
        if (choice.equalsIgnoreCase("Rock") &&
                comp.equalsIgnoreCase("Scissors")){
            return "WINNER \nYou played: "+choice+"\nWe played: "+comp;
        }
        return "LOSER\nYou played: "+choice+"\nWe played: "+comp;

    }

//    List<Integer> guessed = new ArrayList<>();
//
//    @GetMapping("/api/hangman/{input}")
//    public String hangman(@PathVariable String input){
//        if (input.length() != 1){
//            return "ah, ah ,ah, one letter at a time please";
//        }
//        input = input.toLowerCase(Locale.ROOT);
//        String word = "jazz";
//        if (word.contains(input)){
//            return statement(word, input);
//        }
//        return "uhh";
//    }
}
