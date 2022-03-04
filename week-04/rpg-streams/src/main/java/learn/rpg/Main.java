package learn.rpg;

import learn.rpg.data.NameRepository;
import learn.rpg.data.PlayerRepository;
import learn.rpg.domain.PlayerService;
import learn.rpg.models.Hero;
import learn.rpg.models.Player;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        // getPlayers()
        Stream<Player> playerStream = getPlayers().stream();
        //playerStream.forEach(System.out::println);
        //playerStream.forEach((player) -> System.out.println(player));

        Stream<Player> playersFromThailand = playerStream.filter(
                player -> player.getCountry().equalsIgnoreCase("Thailand")
        );
        playersFromThailand.forEach(System.out::println);

        System.out.println();

        getPlayers().stream()
                .filter(player -> player.getLastName().startsWith("B"))
                .skip(100)
                .forEach(System.out::println);

        System.out.println();

        getPlayers().stream()
                .filter(player -> player.getHeroes().size() == 0)
                .limit(5)
                .forEach(System.out::println);

        System.out.println();

        getPlayers().stream()
                .skip(500)
                .limit(10)
                .forEach(player -> System.out.println(player));

        Optional<Player> firstThaiPlayer = getPlayers().stream()
                .filter(player -> player.getCountry().equalsIgnoreCase("Thailand"))
                .findFirst();

        Optional<Player> firstMarsPlayer = getPlayers().stream()
                .filter(player -> player.getCountry().equalsIgnoreCase("Mars"))
                .findFirst();

        if (firstThaiPlayer.isPresent()) {
            Player p = firstThaiPlayer.get();
            System.out.println("Found a Thai player: " + p.getLastName());
        } else {
            System.out.println("There are no Thai players :(");
        }

        if (firstMarsPlayer.isPresent()) {
            Player p = firstMarsPlayer.get();
            System.out.println("Found a Martian player: " + p.getLastName());
        } else {
            System.out.println("There are no Martian players :(");
        }

        List<Player> playersWithNoHero = getPlayers().stream()
                .filter(player -> player.getHeroes().size() == 0)
                .collect(Collectors.toList());

        ArrayList<Player> playersFromNigeria = getPlayers().stream()
                .filter(player -> player.getCountry().equalsIgnoreCase("Nigeria"))
                .collect(Collectors.toCollection(ArrayList::new));

        getPlayers().stream()
                .sorted((a, b) -> a.getCountry().length() - b.getCountry().length())
                .forEach(System.out::println);

        getPlayers().stream()
                .sorted((a, b) -> a.getCountry().compareTo(b.getCountry()))
                .forEach(System.out::println);

        getPlayers().stream()
                .sorted(Comparator.comparing(Player::getCountry))
                .forEach(System.out::println);

        getPlayers().stream()
                .sorted(Comparator.comparing(Player::getCountry).reversed())
                .forEach(System.out::println);

        getPlayers().stream()
                .sorted(Comparator.comparing(Player::getLastName)
                        .thenComparing(Player::getFirstName))
                .forEach(System.out::println);

        getPlayers().stream()
                .map(player -> player.getFirstName() + " " + player.getLastName())
                .forEach(System.out::println);

        getPlayers().stream()
                .map(player -> player.getHeroes().size() == 0 ? null: player.getHeroes().get(0))
                .forEach(System.out::println);

        int[] heroCount = getPlayers().stream()
                .mapToInt(p -> p.getHeroes().size())
                .toArray();

        Stream<Hero> heroes = getPlayers().stream()
                .flatMap(player -> player.getHeroes().stream());

        heroes.forEach(System.out::println);

        List<Hero> allHeroes = getPlayers().stream()
                .flatMap(p -> p.getHeroes().stream())
                .collect(Collectors.toList());

        long playerCount = getPlayers().stream().count();

        String sevenLastNames = getPlayers().stream()
                .map(p -> p.getLastName())
                .limit(7)
                .collect(Collectors.joining(","));

        long sumLevels = (long) allHeroes.stream()
                .collect(Collectors.summarizingInt(Hero::getLevel))
                .getSum();

        double averageLevel = allHeroes.stream()
                .collect(Collectors.summarizingInt(Hero::getLevel))
                .getAverage();

        System.out.println("Player Count: " + playerCount);
        System.out.println("7 Last Names: " + sevenLastNames);
        System.out.println("Sum of Levels: " + sumLevels);
        System.out.println("Average Level: " + averageLevel);
    }





    static List<Player> getPlayers() {
        PlayerRepository playerRepo = new PlayerRepository("players.csv");
        NameRepository nameRepo = new NameRepository("characters.csv");
        PlayerService service = new PlayerService(playerRepo, nameRepo);
        return service.generate();
    }
}
