import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * Classe CalculatorController - Responsável por gerenciar os eventos da calculadora
 * 
 * Esta classe implementa o padrão MVC como Controller, conectando a View aos
 * eventos do usuário e atualizando o Model e a View conforme necessário.
 */
public class CalculatorController implements ActionListener {
    
    private final CalculatorModel model;
    private final CalculatorView view;
    
    /**
     * Construtor que conecta o Model e a View.
     * Também registra os listeners para todos os botões.
     * 
     * @param model O CalculatorModel
     * @param view O CalculatorView
     */
    public CalculatorController(CalculatorModel model, CalculatorView view) {
        this.model = model;
        this.view = view;
        
        // Registra os listeners para os botões de números
        for (JButton button : view.getNumberButtons()) {
            button.addActionListener(this);
        }
        
        // Registra os listeners para os botões de operação
        for (JButton button : view.getOperationButtons()) {
            button.addActionListener(this);
        }
        
        // Registra os listeners para os botões especiais
        view.getEqualsButton().addActionListener(this);
        view.getClearButton().addActionListener(this);
        view.getDecimalButton().addActionListener(this);
    }
    
    /**
     * Método chamado quando um botão é clicado.
     * Identifica qual botão foi pressionado e executa a ação correspondente.
     * 
     * @param e O evento de ação gerado pelo clique do botão
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton source = (JButton) e.getSource();
        String buttonText = source.getText();
        
        // Tratamento para botões de números (0-9)
        if (isNumber(buttonText)) {
            model.addDigit(buttonText);
            updateDisplay();
        }
        // Tratamento para botão de ponto decimal
        else if (buttonText.equals(".")) {
            model.addDecimalPoint();
            updateDisplay();
        }
        // Tratamento para botões de operação (+, -, *, /)
        else if (isOperation(buttonText)) {
            model.setOperation(buttonText);
        }
        // Tratamento para botão de igualdade (=)
        else if (buttonText.equals("=")) {
            model.calculateResult();
            updateDisplay();
        }
        // Tratamento para botão de limpeza (C)
        else if (buttonText.equals("C")) {
            model.clear();
            updateDisplay();
        }
    }
    
    /**
     * Verifica se o texto é um número (0-9).
     * 
     * @param text O texto a ser verificado
     * @return true se for um número, false caso contrário
     */
    private boolean isNumber(String text) {
        try {
            Integer.parseInt(text);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    /**
     * Verifica se o texto é uma operação válida.
     * 
     * @param text O texto a ser verificado
     * @return true se for uma operação (+, -, *, /), false caso contrário
     */
    private boolean isOperation(String text) {
        return text.equals("+") || text.equals("-") || text.equals("*") || text.equals("/");
    }
    
    /**
     * Atualiza o display da View com o valor atual do Model.
     * Este é o elo de comunicação entre Model e View.
     */
    private void updateDisplay() {
        view.getDisplayField().setText(model.getDisplay());
    }
    
    /**
     * Retorna o modelo da calculadora.
     * 
     * @return O CalculatorModel
     */
    public CalculatorModel getModel() {
        return model;
    }
    
    /**
     * Retorna a visão da calculadora.
     * 
     * @return O CalculatorView
     */
    public CalculatorView getView() {
        return view;
    }
}
