import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// front end
public class GuiHandler extends JFrame implements ActionListener {

    GameHandler gameHandler = new GameHandler();
    JLabel computerScore, playerScore, computerChoice, finalResult;
    JButton rockButton, paperButton, scissorsButton, resultButton;
    JDialog gameResult;
    int playerPoints = gameHandler.getScore();
    int computerPoints = gameHandler.getEngineScore();

    public GuiHandler() {
        super("Rock Paper Scissors");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(650, 300);
        setLocationRelativeTo(null);
        setLayout(null);
        setVisible(true);
        addGuiItems();
    }

    private void addGuiItems() {
        computerScore = new JLabel("Engine: " + computerPoints);
        computerScore.setBounds(10, 10, 450, 20);
        computerScore.setFont(new Font("Arial", Font.BOLD, 20));
        computerScore.setHorizontalAlignment(SwingConstants.CENTER);
        add(computerScore);

        computerChoice = new JLabel("?");
        computerChoice.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        computerChoice.setBounds(200, 50, 80, 20);
        computerChoice.setFont(new Font("Arial", Font.BOLD, 20));
        computerChoice.setHorizontalAlignment(SwingConstants.CENTER);
        add(computerChoice);

        playerScore = new JLabel("Player: " + playerPoints);
        playerScore.setBounds(10, 100, 450, 20);
        playerScore.setFont(new Font("Arial", Font.BOLD, 20));
        playerScore.setHorizontalAlignment(SwingConstants.CENTER);
        add(playerScore);

        rockButton = new JButton("Rock");
        rockButton.setFont(new Font("Arial", Font.BOLD, 16));
        rockButton.setBounds(30, 120, 80, 80);
        rockButton.addActionListener(this);
        add(rockButton);

        paperButton = new JButton("Paper");
        paperButton.setFont(new Font("Arial", Font.BOLD, 16));
        paperButton.setBounds(180, 120, 80, 80);
        paperButton.addActionListener(this);
        add(paperButton);

        scissorsButton = new JButton("Scissors");
        scissorsButton.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        scissorsButton.setFont(new Font("Arial", Font.BOLD, 16));
        scissorsButton.setBounds(330, 120, 80, 80);
        scissorsButton.addActionListener(this);
        add(scissorsButton);
    }

    public void resultDialog(String resultMessage) {
        if (gameResult == null) {
            gameResult = new JDialog(this, "Game Result", true);
            gameResult.setSize(200, 150);
            gameResult.setLayout(new BorderLayout());
            gameResult.setLocationRelativeTo(this);

            finalResult = new JLabel("", SwingConstants.CENTER);
            finalResult.setFont(new Font("Arial", Font.BOLD, 20));
            gameResult.add(finalResult, BorderLayout.CENTER);

            resultButton = new JButton("Try Again");
            resultButton.setFont(new Font("Arial", Font.BOLD, 16));
            resultButton.addActionListener(_ -> {
                gameResult.setVisible(false);
                computerChoice.setText("?");
            });
            gameResult.add(resultButton, BorderLayout.SOUTH);
        }

        finalResult.setText(resultMessage);
        gameResult.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String playerChoice = e.getActionCommand();
        gameHandler.playGame(playerChoice);
        computerChoice.setText(gameHandler.getComputerChoice());

        playerScore.setText("Player: " + gameHandler.getScore());
        computerScore.setText("Engine: " + gameHandler.getEngineScore());
        resultDialog(gameHandler.getResult());
    }
}