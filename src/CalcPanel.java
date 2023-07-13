import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalcPanel extends JPanel {
    private JPanel panel;
    private boolean start;
    private JButton display;
    private String lastComand;
    private double result;

    public CalcPanel() {
        super();

        start = true;
        lastComand = "=";
        setLayout(new BorderLayout());
        display = new JButton("0");// Кнопка, которая работает в качетсве дисплея.
        display.setEnabled(false);
        add(display, BorderLayout.NORTH);

        panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4));

        InsertAction insert = new InsertAction();
        ComandAction comand = new ComandAction();

        addButton("7", insert);
        addButton("8", insert);
        addButton("9", insert);
        addButton("/", comand);

        addButton("4", insert);
        addButton("5", insert);
        addButton("6", insert);
        addButton("*", comand);

        addButton("1", insert);
        addButton("2", insert);
        addButton("3", insert);
        addButton("-", comand);

        addButton(".", insert);
        addButton("0", insert);
        addButton("=", comand);
        addButton("+", comand);

        add(panel, BorderLayout.CENTER);
    }

    private void addButton(String label, ActionListener listener) {
        JButton button = new JButton(label);
        button.addActionListener(listener);
        panel.add(button);
    }

    private class InsertAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            String input = ae.getActionCommand();
            if (start) {
                display.setText("");
                start = false;
            }
            if (!input.equals(".") || !display.getText().contains("."))
                display.setText(display.getText() + input);
        }
    }

    private class ComandAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            String command = ae.getActionCommand();
            if (start) {
                lastComand = command;
            } else {
                calc(Double.parseDouble(display.getText()));
                lastComand = command;
                start = true;
            }

        }
    }

    public void calc(double x) {
        switch (lastComand) {
            case "+" -> result += x;
            case "-" -> result -= x;
            case "*" -> result *= x;
            case "/" -> result /= x;
            case "=" -> result = x;
        }
        display.setText(String.valueOf(result));
    }
}
