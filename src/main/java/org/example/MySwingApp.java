package org.example;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.*;
import java.awt.*;

public class MySwingApp extends JFrame {
    private final JTextField display;
    private final JButton button0, button1, button2, button3, button4, button5, button6, button7, button8, button9;
    private final JButton buttonAdd, buttonSubtract, buttonMultiply, buttonDivide, buttonEqual, buttonReset;

    private double result = 0;
    private String expression = "";
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

        // Создание кнопок с цифрами
        button0 = createNumberButton("0");
        button1 = createNumberButton("1");
        button2 = createNumberButton("2");
        button3 = createNumberButton("3");
        button4 = createNumberButton("4");
        button5 = createNumberButton("5");
        button6 = createNumberButton("6");
        button7 = createNumberButton("7");
        button8 = createNumberButton("8");
        button9 = createNumberButton("9");

        // Создание кнопок для операций
        buttonAdd = createOperationButton("+");
        buttonSubtract = createOperationButton("-");
        buttonMultiply = createOperationButton("*");
        buttonDivide = createOperationButton("/");
        buttonEqual = createEqualButton();
        buttonReset = createResetButton();

        // Добавление кнопок в панель
        addButtonsToPanel(buttonPanel, button1, button2, button3, buttonAdd,
                button4, button5, button6, buttonSubtract,
                button7, button8, button9, buttonMultiply,
                button0, buttonReset, buttonEqual, buttonDivide);

        add(buttonPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    // Создание кнопки с цифрой
    private JButton createNumberButton(String text) {
        JButton button = new JButton(text);
        button.addActionListener(e -> {
            if (operationClicked) {
                display.setText("");
                operationClicked = false;
            }
            display.setText(display.getText() + text);
            expression += text;
        });
        return button;
    }

    // Создание кнопки операции
    private JButton createOperationButton(String text) {
        JButton button = new JButton(text);
        button.addActionListener(e -> {
            if (!operationClicked) {
                expression += " " + text + " ";
                operationClicked = true;
            }
        });
        return button;
    }

    // Создание кнопки равно
    private JButton createEqualButton() {
        JButton button = new JButton("=");
        button.addActionListener(e -> {
            calculateResult();
            display.setText(Double.toString(result));
            operationClicked = false;
        });
        return button;
    }

    // Создание кнопки сброса
    private JButton createResetButton() {
        JButton button = new JButton("Сброс");
        button.addActionListener(e -> resetCalculator());
        return button;
    }

    // Добавление кнопок в панель
    private void addButtonsToPanel(JPanel panel, JButton... buttons) {
        for (JButton button : buttons) {
            panel.add(button);
        }
    }

    // Вычисление результата выражения
    private void calculateResult() {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("JavaScript");
        try {
            result = ((Number) engine.eval(expression)).doubleValue();
        } catch (ScriptException e) {
            display.setText("Error");
            result = 0;
        }
    }


    // Сброс калькулятора
    private void resetCalculator() {
        double currentNumber = 0;
        result = 0;
        expression = "";
        display.setText("");
        operationClicked = false;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MySwingApp::new);
    }
}
