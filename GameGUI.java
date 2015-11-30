package pig;

import javax.swing.*;
import java.awt.event.*;
import java.util.Random;
import java.util.ArrayList;

/**
 * Created by rachel-killackey on 11/2/14.
 */

public class GameGUI {
    private JPanel panel;
    private JTextField nameField;
    private JLabel nameLabel;
    private JButton rollButton;
    private JButton holdButton;
    private JButton startButton;
    private JTextArea resultArea;
    private JScrollPane scrollPane;

    private Player human;
    private Computer comp;
    private Dice die;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Pig Dice");
        frame.setContentPane(new GameGUI().panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(600, 600);
        frame.setVisible(true);
    }

    public GameGUI() {

        human = new Player();
        comp = new Computer();
        die = new Dice();

        createUIComponents();

    }

    public void playerGame() {
        int nRoll = die.throwDice();
        if (nRoll == 1) {
            human.setScore(0);
            resultArea.append("\n>> You rolled a 1. Your score is now 0.\nNow it is the Computer's turn.");
            computerGame();
        } else {
            human.setScore(nRoll);
            resultArea.append("\n>> You rolled a " + nRoll + ".\nYour score is now " + human.getScore() + ".");
            resultArea.append("\n>> Press 'Roll' to continue or 'Hold' to end your turn.");
        }
        if (human.getScore() >= 100 || comp.getScore() >= 100) {
            announceWinner();
        }
    }

    public void computerGame() {

        Random ran = new Random();
        ArrayList<Integer> rolls = new ArrayList<Integer>();
        for (int nC = 0; nC < ran.nextInt(10) + 1; nC++) {
            rolls.add(ran.nextInt(6) + 1);
        }

        for (int i = 0; i < rolls.size(); i++) {
            if (rolls.get(i) == 1) {
                comp.setScore(0);
                resultArea.append("\nComputer rolled a 1. Computer's score is 0.\nNow it is your turn.");
                playerGame();
                return;
            } else {

                comp.setScore(rolls.get(i));
                resultArea.append("\nComputer rolled a " + rolls.get(i) + ".\nComputer's score is " + comp.getScore() + ".");
            }
        }
        if (human.getScore() >= 100 || comp.getScore() >= 100) {
            announceWinner();
        }
        resultArea.append("\nComputer's turn is finished. Now it is your turn.");
        playerGame();
    }

    public void announceWinner() {
        if (comp.getScore() > human.getScore()) {
            resultArea.append("\nComputer Wins :-(");
        } else {
            resultArea.append("\nYou Win!");
        }
    }

    private void createUIComponents() {
        startButton = new JButton();
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String playerName = nameField.getText();
                human.setName(playerName);
                resultArea.setText("Welcome to Pig Dice, " + playerName + "!");
                playerGame();
            }
        });

        rollButton = new JButton();
        rollButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (comp.getScore() < 100 && human.getScore() < 100) {
                    playerGame();
                } else {
                    announceWinner();
                }
            }
        });

        holdButton = new JButton();
        holdButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (comp.getScore() < 100 && human.getScore() < 100) {
                    computerGame();
                } else {
                    announceWinner();
                }
            }
        });

    }

}
