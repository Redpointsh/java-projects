import java.util.Random;

// backend
public class GameHandler {

    private static final String[] gameChoices = {"Rock", "Paper", "Scissors"};

    private final Random random = new Random();
    public String result;
    public int score;
    public int engineScore;

    public GameHandler() {
    }

    String computerChoice;

    public int getScore() {
        return score;
    }

    public int getEngineScore() {
        return engineScore;
    }

    public String getComputerChoice() {
        return computerChoice;
    }

    public String getResult() {
        return result;
    }

    public void playGame(String playerChoice) {
        computerChoice = gameChoices[random.nextInt(gameChoices.length)];

        switch (playerChoice) {
            case "Rock":
                if (computerChoice.equals("Scissors")) {
                    result = "Player Wins!";
                    score++;

                } else if (computerChoice.equals("Paper")) {
                    result = "Computer Wins!";
                    engineScore++;
                } else {
                    result = "Draw";
                }
                break;
            case "Scissors":
                if (computerChoice.equals("Paper")) {
                    result = "Player Wins!";
                    score++;
                } else if (computerChoice.equals("Rock")) {
                    result = "Computer Wins!";
                    engineScore++;
                } else {
                    result = "Draw";
                }
                break;
            case "Paper":
                if (computerChoice.equals("Rock")) {
                    result = "Player Wins!";
                    score++;
                } else if (computerChoice.equals("Scissors")) {
                    result = "Computer Wins!";
                    engineScore++;
                } else {
                    result = "Draw";
                }
                break;
            default:
                result = "Draw";
        }
    }
}
