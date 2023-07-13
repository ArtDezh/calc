import javax.swing.*;

public class Calculator {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setTitle("Калькулятор");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(300, 300, 640, 480);
        CalcPanel panel = new CalcPanel();
        frame.add(panel);
        frame.setVisible(true);
    }
}