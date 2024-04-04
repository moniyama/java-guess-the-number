import java.util.ArrayList;
import java.util.Scanner;

abstract class Player {
    private String name;
    protected ArrayList<Integer> guesses  = new ArrayList<>();
    public abstract void makeGuess();
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void addGuesses(int number) {
        this.guesses.add(number);
    }
    public ArrayList<Integer> getGuesses() {
        return guesses;
    }

    public void askForGuess() {
        System.out.println("--- Round: " + name + " ---");
        System.out.printf(name + ", enter your guess: ");
    }
}

class HumanPlayer extends Player {
    static Scanner scanner = new Scanner(System.in);
    @Override
    public void makeGuess() {
        int answer = scanner.nextInt();
        this.addGuesses(answer);
    }
}

class ComputerPlayer extends Player{
    public ComputerPlayer(){
        this.setName("Computer");
    }

    @Override
    public void makeGuess() {
        int random = (int) Math.floor(Math.random()*101);
        this.addGuesses(random);
        System.out.printf(String.valueOf(random) + "\n");
    }
}