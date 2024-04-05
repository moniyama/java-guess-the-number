import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class GuessTheNumberGame {
    static int targetNumber = (int) Math.floor(Math.random() * 101);
    static Scanner scanner = new Scanner(System.in);
    static Player winner;

    private static boolean checkGuess(Player player) {
        int guess = player.getGuesses().getLast();
        if (targetNumber == guess) {
            System.out.println("Parabens, " + player.getName() + "! Voce acertou!");
            System.out.println("\nVENCEDOOOOR: " + player.getName());
            System.out.println("Tentativas: " + player.getGuesses());
            System.out.println("Total: " + player.getGuesses().size());
            return true;
        } else {
            if (guess > targetNumber) {
                System.out.println("Sorry! Too High\n");
            } else {
                System.out.println("Sorry! Too Low\n");
            }
            return false;
        }
    }

    public static void main(String[] args) {

        System.out.print("--- Bem vindo ao Guess the Number ---\nPara iniciar, digite seu nome: ");

        HumanPlayer player = new HumanPlayer();
        ComputerPlayer bot = new ComputerPlayer();

        String name = scanner.nextLine();
        player.setName(name);

        System.out.println("\nUm numero de 0 a 100 foi escolhido! Tente adivinhar!\n");

        while (true) {
            player.askForGuess();
            player.makeGuess();
            if (checkGuess(player)) break;

            bot.askForGuess();
            bot.makeGuess();
            if (checkGuess(bot)) break;
        }
    }
}