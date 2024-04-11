package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MySwingApp extends JFrame {
    private JTextField display;
    private JButton button0, button1, button2, button3, button4, button5, button6, button7, button8, button9;
    private JButton buttonAdd, buttonSubtract, buttonMultiply, buttonDivide, buttonEqual, buttonReset;

    private double currentNumber = 0;
    private double result = 0;
    private char operation = ' ';
    private boolean operationClicked = false;

    public MySwingApp() {
        super("Калькулятор");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(400, 400);
        setLayout(new BorderLayout());

        display = new JTextField();
        display.setEditable(false);
        display.setFont(display.getFont().deriveFont(Font.PLAIN, 50));
        add(display, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 4, 5, 5));

        button0 = new JButton("0");
        button1 = new JButton("1");
        button2 = new JButton("2");
        button3 = new JButton("3");
        button4 = new JButton("4");
        button5 = new JButton("5");
        button6 = new JButton("6");
        button7 = new JButton("7");
        button8 = new JButton("8");
        button9 = new JButton("9");

        buttonAdd = new JButton("+");
        buttonSubtract = new JButton("-");
        buttonMultiply = new JButton("*");
        buttonDivide = new JButton("/");
        buttonEqual = new JButton("=");
        buttonReset = new JButton("Сброс");

        button0.addActionListener(new NumberButtonListener());
        button1.addActionListener(new NumberButtonListener());
        button2.addActionListener(new NumberButtonListener());
        button3.addActionListener(new NumberButtonListener());
        button4.addActionListener(new NumberButtonListener());
        button5.addActionListener(new NumberButtonListener());
        button6.addActionListener(new NumberButtonListener());
        button7.addActionListener(new NumberButtonListener());
        button8.addActionListener(new NumberButtonListener());
        button9.addActionListener(new NumberButtonListener());

        buttonAdd.addActionListener(new OperationButtonListener('+'));
        buttonSubtract.addActionListener(new OperationButtonListener('-'));
        buttonMultiply.addActionListener(new OperationButtonListener('*'));
        buttonDivide.addActionListener(new OperationButtonListener('/'));

        buttonEqual.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateResult();
                display.setText(Double.toString(result));
                operationClicked = false;
            }
        });

        buttonReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetCalculator();
            }
        });

        buttonPanel.add(button1);
        buttonPanel.add(button2);
        buttonPanel.add(button3);
        buttonPanel.add(buttonAdd);
        buttonPanel.add(button4);
        buttonPanel.add(button5);
        buttonPanel.add(button6);
        buttonPanel.add(buttonSubtract);
        buttonPanel.add(button7);
        buttonPanel.add(button8);
        buttonPanel.add(button9);
        buttonPanel.add(buttonMultiply);
        buttonPanel.add(button0);
        buttonPanel.add(buttonReset);
        buttonPanel.add(buttonEqual);
        buttonPanel.add(buttonDivide);

        add(buttonPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    private class NumberButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton button = (JButton) e.getSource();
            String buttonText = button.getText();
            if (operationClicked) {
                display.setText("");
                operationClicked = false;
            }
            display.setText(display.getText() + buttonText);
            currentNumber = Double.parseDouble(display.getText());
        }
    }

    private class OperationButtonListener implements ActionListener {
        private char op;

        public OperationButtonListener(char operation) {
            this.op = operation;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (!operationClicked) {
                if (operation != ' ') {
                    calculateResult();
                }
                operation = op;
                operationClicked = true;
                display.setText("");
            }
        }
    }

    private void calculateResult() {
        switch (operation) {
            case '+':
                result += currentNumber;
                break;
            case '-':
                result -= currentNumber;
                break;
            case '*':
                result *= currentNumber;
                break;
            case '/':
                if (currentNumber != 0) {
                    result /= currentNumber;
                } else {
                    display.setText("Error");
                }
                break;
            default:
                result = currentNumber;
                break;
        }
    }

    private void resetCalculator() {
        currentNumber = 0;
        result = 0;
        operation = ' ';
        display.setText("");
        operationClicked = false;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MySwingApp::new);
    }
}
