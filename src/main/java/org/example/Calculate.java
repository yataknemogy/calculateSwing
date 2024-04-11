package org.example;
import javax.swing.*;

public class Calculate extends JFrame {
  public static void main(String args){
    new Calculate();
  }

  private Calculate(){
    super("Калькулятор");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(400, 300);
    setVisible(true);
  }
}
