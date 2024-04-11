package org.example;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Display extends JFrame {
  private JTextField display;
  private JButton button0, button1, button2, button3, button4, button5, button6, button7, button8, button9;
  private JButton buttonAdd, buttonSubtract, buttonMultiply, buttonDivide, buttonEqual, buttonReset;

  public Display(){
    super("Калькулятор");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(400, 300);
    display = new JTextField();
    add(display, BorderLayout.CENTER);
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

    add(button0, BorderLayout.WEST);
    add(button1, BorderLayout.WEST);
    add(button2, BorderLayout.WEST);
    add(button3, BorderLayout.WEST);
    add(button4, BorderLayout.WEST);
    add(button5, BorderLayout.WEST);
    add(button6, BorderLayout.WEST);
    add(button7, BorderLayout.WEST);
    add(button8, BorderLayout.WEST);
    add(button9, BorderLayout.WEST);

    add(buttonAdd, BorderLayout.EAST);
    add(buttonSubtract, BorderLayout.EAST);
    add(buttonMultiply, BorderLayout.EAST);
    add(buttonDivide, BorderLayout.EAST);
    add(buttonEqual, BorderLayout.EAST);
    add(buttonReset, BorderLayout.EAST);

    setVisible(true);
  }
}
