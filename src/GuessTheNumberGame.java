import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class GuessTheNumberGame {
    static int targetNumber = (int) Math.floor(Math.random()*101);
    static Scanner scanner = new Scanner(System.in);
    static boolean endGame = false;
    private static void checkGuess(Player player) {
        int guess = player.getGuesses().getLast();
        if(isRightGuess(guess)){
            System.out.println("Parabens, " + player.getName() + "! Voce acertou!");
            System.out.println("Tentativas: " + player.getGuesses());
            System.out.println("Total: " + player.getGuesses().size());
            endGame = true;
            // winner =
        } else {
            printWrongGuessMessage(guess);
        }
    }

    private static boolean isRightGuess(int guess) {
        System.out.println("targetNumber = " + targetNumber);
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
//        ComputerPlayer bot = new ComputerPlayer();
//        bot.setName("Computer"); // setar direto na class?

        String name = scanner.nextLine();
        player.setName(name);

        System.out.println("\nUm numero de 0 a 100 foi escolhido! Tente adivinhar!\n");

        while(!endGame) {
            player.askForGuess();
            int answer = scanner.nextInt();
            player.makeGuess(answer);
//            bot.askForGuess();
//            bot.makeGuess();
            checkGuess(player);
        }
    }
}