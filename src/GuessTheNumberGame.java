import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class GuessTheNumberGame {
    static int targetNumber = (int) Math.floor(Math.random()*101);
    static Scanner scanner = new Scanner(System.in);
    static boolean endGame = false;
    static Player winner;
    private static void checkGuess(Player player) {
        int guess = player.getGuesses().getLast();
        if(isRightGuess(guess)){
            System.out.println("Parabens, " + player.getName() + "! Voce acertou!");
            endGame = true;
            winner = player;
        } else {
            printWrongGuessMessage(guess);
        }
    }

    private static boolean isRightGuess(int guess) {
        return targetNumber == guess;
    }

    private static void printWrongGuessMessage(int guess) {
        if (guess > targetNumber) {
            System.out.println("Sorry! Too High\n");
        } else {
            System.out.println("Sorry! Too Low\n");
        }
    }
    public static void main(String[] args) {

        System.out.print("--- Bem vindo ao Guess the Number ---\nPara iniciar, digite seu nome: ");

        HumanPlayer player = new HumanPlayer();
        ComputerPlayer bot = new ComputerPlayer();

        String name = scanner.nextLine();
        player.setName(name);

        System.out.println("\nUm numero de 0 a 100 foi escolhido! Tente adivinhar!\n");

        while(!endGame) {
            player.askForGuess();
            player.makeGuess();
            checkGuess(player);

            bot.askForGuess();
            bot.makeGuess();
            checkGuess(bot);
        }

        System.out.println("TEMOS UM VENCEDOOOOR: " + winner.getName());
        System.out.println("Tentativas: " + player.getGuesses());
        System.out.println("Total: " + player.getGuesses().size());
    }
}