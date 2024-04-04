import java.util.ArrayList;

abstract class Player {
    private String name;
    protected ArrayList<Integer> guesses  = new ArrayList<>();
    public abstract void makeGuess(int num);
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
    @Override
    public void makeGuess(int guess) {
        this.addGuesses(guess);
    }
}

class ComputerPlayer extends Player{
    String name = "Computer"; // not working
    @Override
    public void makeGuess(int num) {
        int random = (int) Math.floor(Math.random()*101);
        this.addGuesses(random);
        System.out.printf("random number", random);
    }
}