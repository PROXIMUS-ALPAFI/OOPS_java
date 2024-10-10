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
public class Pgui {
    private final Palmcric game;
    private JFrame frame;
    private JTextArea textArea;
    private JButton tossButton;
    private JButton batButton;
    private JButton bowlButton;
    private JButton[] numberButtons;
    private boolean tossDecided = false;

    public Pgui() {
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

        tossButton = new JButton("Toss");
        batButton = new JButton("Bat");
        bowlButton = new JButton("Bowl");

        controlPanel.add(tossButton);
        controlPanel.add(batButton);
        controlPanel.add(bowlButton);

        JPanel numberPanel = new JPanel();
        numberPanel.setLayout(new GridLayout(1, 6)); // 1 row, 6 columns
        numberButtons = new JButton[6];

        // Create buttons for numbers 1 through 6
        for (int i = 0; i < 6; i++) {
            int number = i + 1;
            numberButtons[i] = new JButton(String.valueOf(number));
            numberButtons[i].addActionListener(new NumberButtonListener(number));
            numberPanel.add(numberButtons[i]);
        }

        frame.add(numberPanel, BorderLayout.NORTH);

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
                    textArea.append("Please toss first.\n");
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
                    textArea.append("Please toss first.\n");
                }
            }
        });

        frame.setVisible(true);
    }

    private class NumberButtonListener implements ActionListener {
        private final int number;

        public NumberButtonListener(int number) {
            this.number = number;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            handleUserGuess(number);
        }
    }

    private void handleToss() {
        String[] options = {"Heads", "Tails"};
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
        enableNumberButtons(true);
    }

    private void handleInnings() {
        textArea.append(game.batflag ? "\nYou are batting now.\n" : "\nSystem is batting now.\n");
        enableNumberButtons(true);
    }

    private void handleUserGuess(int userGuess) {
        if (userGuess < 1 || userGuess > 6) {
            JOptionPane.showMessageDialog(frame, "Invalid input. Please enter a number between 1 to 6.");
            return;
        }

        game.user_in = userGuess;
        game.setRand_num(); // System's guess

        if (game.user_in == game.rand_num) {
            if (game.batflag) {
                textArea.append("and out ..... Your innings is over.\n");
            } else {
                textArea.append("And... out . System's innings is over.\n");
            }
            display();
            enableNumberButtons(false);
        } else {
            if (game.batflag) {
                game.score_usr += game.user_in;
            } else {
                game.score_sys += game.rand_num;
            }
        }
    }

    private void display() {
        textArea.append("Final Score - You: " + game.score_usr + ", System: " + game.score_sys + "\n");
        textArea.append(game.score_sys > game.score_usr ? "You lost...\n" : "You win!\n");
    }

    private void enableNumberButtons(boolean enable) {
        for (JButton button : numberButtons) {
            button.setEnabled(enable);
        }
    }


}
