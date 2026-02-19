/**
 * Classe CalculatorModel - Responsável pela lógica matemática da calculadora
 * 
 * Esta classe implementa o padrão MVC como Model, encapsulando todas as
 * operações matemáticas e o estado interno da calculadora.
 */
public class CalculatorModel {
    
    private double firstOperand = 0;
    private double secondOperand = 0;
    private String operation = "";
    private String display = "0";
    private boolean isNewNumber = true;
    
    /**
     * Adiciona um dígito ao display da calculadora.
     * 
     * @param digit O dígito a ser adicionado (0-9)
     */
    public void addDigit(String digit) {
        if (isNewNumber) {
            display = digit;
            isNewNumber = false;
        } else {
            display += digit;
        }
    }
    
    /**
     * Adiciona um ponto decimal ao número atual.
     * Evita múltiplos pontos decimais no mesmo número.
     */
    public void addDecimalPoint() {
        if (isNewNumber) {
            display = "0.";
            isNewNumber = false;
        } else if (!display.contains(".")) {
            display += ".";
        }
    }
    
    /**
     * Define a operação a ser realizada e armazena o primeiro operando.
     * 
     * @param op A operação a ser realizada (+, -, *, /)
     */
    public void setOperation(String op) {
        try {
            firstOperand = Double.parseDouble(display);
        } catch (NumberFormatException e) {
            firstOperand = 0;
        }
        operation = op;
        isNewNumber = true;
    }
    
    /**
     * Calcula o resultado da operação atual.
     * Trata divisão por zero como erro.
     * 
     * @return O resultado da operação ou mensagem de erro
     */
    public String calculateResult() {
        try {
            secondOperand = Double.parseDouble(display);
        } catch (NumberFormatException e) {
            return "Erro";
        }
        
        switch (operation) {
            case "+":
                display = formatResult(firstOperand + secondOperand);
                break;
            case "-":
                display = formatResult(firstOperand - secondOperand);
                break;
            case "*":
                display = formatResult(firstOperand * secondOperand);
                break;
            case "/":
                // Tratamento de divisão por zero
                if (secondOperand == 0) {
                    return "Erro";
                }
                display = formatResult(firstOperand / secondOperand);
                break;
            default:
                return display;
        }
        
        isNewNumber = true;
        operation = "";
        return display;
    }
    
    /**
     * Formata o resultado removendo zeros desnecessários após o decimal.
     * 
     * @param result O resultado a ser formatado
     * @return A string formatada
     */
    private String formatResult(double result) {
        // Formata o resultado, removendo zeros desnecessários após o decimal
        if (result == (long) result) {
            return String.format("%d", (long) result);
        } else {
            return String.format("%.10f", result).replaceAll("0+$", "").replaceAll("\\.$", "");
        }
    }
    
    /**
     * Limpa todos os dados da calculadora e reseta para o estado inicial.
     */
    public void clear() {
        firstOperand = 0;
        secondOperand = 0;
        operation = "";
        display = "0";
        isNewNumber = true;
    }
    
    /**
     * Retorna o valor atual do display.
     * 
     * @return A string a ser exibida no display
     */
    public String getDisplay() {
        return display;
    }
    
    /**
     * Define o valor do display diretamente.
     * 
     * @param value O novo valor do display
     */
    public void setDisplay(String value) {
        display = value;
    }
    
    /**
     * Retorna a operação atual armazenada.
     * 
     * @return A operação (+, -, *, /)
     */
    public String getOperation() {
        return operation;
    }
}
