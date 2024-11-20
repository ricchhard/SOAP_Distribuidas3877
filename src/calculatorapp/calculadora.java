package calculatorapp;

import javax.swing.*;
import java.awt.*;
import org.tempuri.Calculator;
import org.tempuri.CalculatorSoap;

public class calculadora extends JFrame {

    private int firstNum;
    private int secondNum;
    private String operator;

    public calculadora() {
        // Configuración de la ventana principal
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 500);
        setTitle("Calculadora");
        setLayout(new BorderLayout());

        // Aplicar Look and Feel moderno
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Campo de texto para mostrar resultados
        JTextField display = new JTextField();
        display.setFont(new Font("Arial", Font.BOLD, 24));
        display.setHorizontalAlignment(SwingConstants.RIGHT);
        display.setEditable(false);
        add(display, BorderLayout.NORTH);

        // Panel para los botones
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4, 10, 10));
        panel.setBackground(Color.DARK_GRAY);
        add(panel, BorderLayout.CENTER);

        // Crear botones y agregarlos al panel
        String[] buttonLabels = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "C", "0", "=", "+"
        };

        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.setFont(new Font("Arial", Font.BOLD, 20));
            button.setFocusPainted(false);
            button.setBackground(Color.LIGHT_GRAY);
            button.setForeground(Color.BLACK);
            panel.add(button);

            button.addActionListener(e -> {
                String buttonText = e.getActionCommand();

                switch (buttonText) {
                    case "C":
                        display.setText("");
                        break;
                    case "=":
                        secondNum = Integer.parseInt(display.getText());
                        try {
                            int result = performOperation(firstNum, secondNum, operator);
                            display.setText(String.valueOf(result));
                        } catch (Exception ex) {
                            display.setText("Error");
                        }
                        break;
                    case "+":
                    case "-":
                    case "*":
                    case "/":
                        firstNum = Integer.parseInt(display.getText());
                        display.setText("");
                        operator = buttonText;
                        break;
                    default:
                        display.setText(display.getText() + buttonText);
                }
            });
        }

        // Estilo adicional
        getContentPane().setBackground(Color.BLACK);
        setVisible(true);
    }

    private int performOperation(int firstNum, int secondNum, String operator) throws Exception {
        Calculator calculator = new Calculator();
        CalculatorSoap calculatorSoap = calculator.getCalculatorSoap();
        switch (operator) {
            case "+":
                return calculatorSoap.add(firstNum, secondNum);
            case "-":
                return calculatorSoap.subtract(firstNum, secondNum);
            case "*":
                return calculatorSoap.multiply(firstNum, secondNum);
            case "/":
                return calculatorSoap.divide(firstNum, secondNum);
            default:
                throw new Exception("Operador no soportado");
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 268, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 295, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String[] args) {
        SwingUtilities.invokeLater(calculadora::new);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
