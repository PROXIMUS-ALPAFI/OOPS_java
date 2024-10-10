import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class provides a GUI for the Palm Cricket game.
 * It uses Swing components to allow users to interact with the game.
 *
 * @author Devarsh Naik
 * @version 1.0.1
 * @lastmodified 28/08/2024
 * @startdate 21/08/2024
 */
public class Palmcric_ui {
    private final Palmcric game;
    private JFrame frame;
    private JTextArea textArea;
    private JButton tossButton;
    private JButton batButton;
    private JButton bowlButton;
    private JButton userGuessButton;
    private JTextField userInputField;
    private boolean tossDecided = false;

    public Palmcric_ui() {
        game = new Palmcric();
        gamesetup();
    }

    private void gamesetup() {
        frame = new JFrame("Palm Cricket Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(502, 402);
        frame.setLayout(new BorderLayout());

        textArea = new JTextArea(16, 41);
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        frame.add(scrollPane, BorderLayout.CENTER);

        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());
        frame.add(controlPanel, BorderLayout.SOUTH);

        tossButton = new JButton("toss");
        batButton = new JButton("bat");
        bowlButton = new JButton("bowl");
        userGuessButton = new JButton("go");
        userInputField = new JTextField(6);

        controlPanel.add(tossButton);
        controlPanel.add(new JLabel("chose a number between (1-6):"));
        controlPanel.add(userInputField);
        controlPanel.add(userGuessButton);

        JPanel choicePanel = new JPanel();
        choicePanel.setLayout(new FlowLayout());
        choicePanel.add(batButton);
        choicePanel.add(bowlButton);
        frame.add(choicePanel, BorderLayout.NORTH);

        tossButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleToss();
            }
        });

        batButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tossDecided) {
                    game.batflag = true;
                    handleInnings();
                } else {
                    textArea.append("Toss karo bhai.\n");
                }
            }
        });

        bowlButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tossDecided) {
                    game.batflag = false;
                    handleInnings();
                } else {
                    textArea.append("Toss karo bhai.\n");
                }
            }
        });

        userGuessButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleUserGuess();
            }
        });

        frame.setVisible(true);
    }

    private void handleToss() {
        String[] options = {"heads", "tails"};
        int userChoice = JOptionPane.showOptionDialog(frame,
                "Choose Heads or Tails",
                "Toss",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]) + 1;

        game.choice(); // System handles the toss
        tossDecided = true;

        if (game.batflag) {
            textArea.append("You won the toss and have chosen to bat first.\n");
        } else {
            textArea.append("You lost the toss and the system chose to bat first.\n");
        }
        enablechoice(true);
    }

    private void handleInnings() {
        textArea.append(game.batflag ? "\nYou are batting now.\n" : "\nSystem is batting now.\n");
        enablechoice(true);
    }

    private void handleUserGuess() {
        try {
            int userGuess = Integer.parseInt(userInputField.getText());
            if (userGuess < 1 || userGuess > 6) {
                JOptionPane.showMessageDialog(frame, "Invalid input. Please enter a number between 1 to 6.");
                return;
            }

            game.user_in = userGuess;
            game.setRand_num(); // System's guess

            if (game.user_in == game.rand_num) {
                if (game.batflag) {
                    textArea.append("You guessed correctly. Your innings is over.\n");
                } else {
                    textArea.append("System guessed correctly. System's innings is over.\n");
                }
                display();
                enablechoice(false);
            } else {
                if (game.batflag) {
                    game.score_usr += game.user_in;
                } else {
                    game.score_sys += game.rand_num;
                }
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "Please enter a valid number.");
        }
    }

    private void display() {
        textArea.append("Final Score - You: " + game.score_usr + ", System: " + game.score_sys + "\n");
        textArea.append(game.score_sys > game.score_usr ? "You lost...\n" : "You win!\n");
    }

    private void enablechoice(boolean enable) {
        userInputField.setEnabled(enable);
        userGuessButton.setEnabled(enable);
    }


}
