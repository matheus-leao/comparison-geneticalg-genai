import controller.CalculatorController;
import model.CalculatorModel;
import view.CalculatorView;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Cria o Model (lógica de negócio)
        CalculatorModel model = new CalculatorModel();

        // Cria a View (interface gráfica)
        CalculatorView view = new CalculatorView();

        // Cria o Controller (gerenciador de eventos)
        CalculatorController controller = new CalculatorController(model, view);
    }
}