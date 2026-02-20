package view;

import javax.swing.*;
import java.awt.*;

public class CalculatorView extends JFrame {

    private JTextField displayField;
    private JPanel buttonPanel;
    private JButton[] numberButtons;
    private JButton[] operationButtons;
    private JButton equalsButton;
    private JButton clearButton;
    private JButton decimalButton;

    /**
     * Construtor que inicializa a janela principal e todos os componentes.
     */
    public CalculatorView() {
        // Configuração da janela principal
        setTitle("Calculadora");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 500);
        setLocationRelativeTo(null);
        setResizable(false);

        // Criação do painel principal com BorderLayout
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Criação do display (somente leitura)
        displayField = new JTextField("0");
        displayField.setEditable(false);
        displayField.setFont(new Font("Arial", Font.BOLD, 24));
        displayField.setHorizontalAlignment(JTextField.RIGHT);
        displayField.setBackground(Color.BLACK);
        displayField.setForeground(Color.WHITE);
        mainPanel.add(displayField, BorderLayout.NORTH);

        // Criação do painel de botões com GridLayout (4 linhas x 4 colunas)
        buttonPanel = new JPanel(new GridLayout(4, 4, 5, 5));
        buttonPanel.setBackground(new Color(240, 240, 240));

        // Inicialização dos botões de números
        numberButtons = new JButton[10];
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = createButton(String.valueOf(i));
        }

        // Inicialização dos botões de operação
        operationButtons = new JButton[4];
        String[] operations = {"+", "-", "*", "/"};
        for (int i = 0; i < 4; i++) {
            operationButtons[i] = createButton(operations[i]);
        }

        // Inicialização dos botões especiais
        decimalButton = createButton(".");
        clearButton = createButton("C");
        equalsButton = createButton("=");

        // Organização dos botões no painel (GridLayout)
        // Linha 1: 7, 8, 9, /
        buttonPanel.add(numberButtons[7]);
        buttonPanel.add(numberButtons[8]);
        buttonPanel.add(numberButtons[9]);
        buttonPanel.add(operationButtons[3]); // /

        // Linha 2: 4, 5, 6, *
        buttonPanel.add(numberButtons[4]);
        buttonPanel.add(numberButtons[5]);
        buttonPanel.add(numberButtons[6]);
        buttonPanel.add(operationButtons[2]); // *

        // Linha 3: 1, 2, 3, -
        buttonPanel.add(numberButtons[1]);
        buttonPanel.add(numberButtons[2]);
        buttonPanel.add(numberButtons[3]);
        buttonPanel.add(operationButtons[1]); // -

        // Linha 4: 0, ., C, +
        buttonPanel.add(numberButtons[0]);
        buttonPanel.add(decimalButton);
        buttonPanel.add(clearButton);
        buttonPanel.add(operationButtons[0]); // +

        // Painel adicional para o botão de igualdade (ocupa toda a largura)
        JPanel bottomPanel = new JPanel(new GridLayout(1, 1, 5, 5));
        bottomPanel.setBackground(new Color(240, 240, 240));
        equalsButton.setFont(new Font("Arial", Font.BOLD, 18));
        equalsButton.setBackground(new Color(76, 175, 80));
        equalsButton.setForeground(Color.WHITE);
        bottomPanel.add(equalsButton);

        mainPanel.add(buttonPanel, BorderLayout.CENTER);
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);

        add(mainPanel);
        setVisible(true);
    }

    /**
     * Método auxiliar para criar e estilizar um botão.
     *
     * @param label O texto a ser exibido no botão
     * @return Um JButton configurado
     */
    private JButton createButton(String label) {
        JButton button = new JButton(label);
        button.setFont(new Font("Arial", Font.BOLD, 18));
        button.setFocusPainted(false);
        button.setBackground(new Color(230, 230, 230));
        button.setForeground(Color.BLACK);
        button.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        return button;
    }

    /**
     * Retorna o campo de display.
     *
     * @return O JTextField do display
     */
    public JTextField getDisplayField() {
        return displayField;
    }

    /**
     * Retorna os botões de números.
     *
     * @return Array de JButton com os botões de números
     */
    public JButton[] getNumberButtons() {
        return numberButtons;
    }

    /**
     * Retorna os botões de operação.
     *
     * @return Array de JButton com os botões de operação
     */
    public JButton[] getOperationButtons() {
        return operationButtons;
    }

    /**
     * Retorna o botão de igualdade.
     *
     * @return JButton do botão de igualdade
     */
    public JButton getEqualsButton() {
        return equalsButton;
    }

    /**
     * Retorna o botão de limpeza.
     *
     * @return JButton do botão C (Clear)
     */
    public JButton getClearButton() {
        return clearButton;
    }

    /**
     * Retorna o botão de ponto decimal.
     *
     * @return JButton do botão de ponto decimal
     */
    public JButton getDecimalButton() {
        return decimalButton;
    }
}
