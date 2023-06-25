package hexlet.code;

import hexlet.code.games.Gcd;
import hexlet.code.games.Game;
import hexlet.code.games.Calc;
import hexlet.code.games.Even;
import hexlet.code.games.Progression;
import hexlet.code.games.Prime;

import java.util.Scanner;
import java.util.StringJoiner;

public class App {
    public static void main(String[] args) {
        Game[] games = {
            new Even(),
            new Calc(),
            new Gcd(),
            new Progression(),
            new Prime(),
        };

        var gamesCount = games.length;

        var menuText = new StringJoiner("\n");

        menuText.add("Please enter the game number and press Enter.");
        menuText.add("1 - Greet");

        var menuIdPad = 2;

        for (int i = 0; i < gamesCount; i++) {
            var gameId = i + menuIdPad;
            var gameName = games[i].getName();
            menuText.add(gameId + " - " + gameName);
        }

        menuText.add("0 - Exit");
        menuText.add("Your choice: ");

        System.out.print(menuText);

        Scanner scanner = new Scanner(System.in);
        var chosenGameId = scanner.nextInt();

        System.out.println();

        if (chosenGameId == 1) {
            Cli.greet();
            return;
        }

        chosenGameId -= menuIdPad;

        if (chosenGameId < 0 || chosenGameId > gamesCount - 1) {
            return;
        }

        var chosenGame = games[chosenGameId];

        Engine.run(chosenGame);
    }
}
