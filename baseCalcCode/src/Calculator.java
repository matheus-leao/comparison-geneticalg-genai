
/**
 * Classe Calculator - Ponto de entrada da aplicação
 * 
 * Esta classe contém apenas o método main e é responsável por inicializar
 * a aplicação, instanciando o Model, View e Controller.
 */
public class Calculator {
    
    /**
     * Método principal que inicia a aplicação.
     * Segue o padrão MVC instanciando os componentes na ordem correta:
     * 1. Model - Lógica da aplicação
     * 2. View - Interface gráfica
     * 3. Controller - Conexão entre View e Model
     * 
     * @param args Argumentos de linha de comando (não utilizados)
     */
    public static void main(String[] args) {
        // Cria o Model (lógica de negócio)
        CalculatorModel model = new CalculatorModel();
        
        // Cria a View (interface gráfica)
        CalculatorView view = new CalculatorView();
        
        // Cria o Controller (gerenciador de eventos)
        CalculatorController controller = new CalculatorController(model, view);
    }
}
