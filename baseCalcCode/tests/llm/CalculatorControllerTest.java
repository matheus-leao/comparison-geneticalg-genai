import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import javax.swing.*;
import java.awt.event.ActionEvent;

class CalculatorControllerTest {
    private CalculatorModel model;
    private CalculatorView view;
    private CalculatorController controller;

    @BeforeEach
    void setUp() {
        model = new CalculatorModel();
        view = new CalculatorView();
        controller = new CalculatorController(model, view);
        view.setVisible(false);
    }

    @Test
    void testAddDigit() {
        JButton button = new JButton("5");
        controller.actionPerformed(new ActionEvent(button, ActionEvent.ACTION_PERFORMED, null));
        assertEquals("5", model.getDisplay());
    }

    @Test
    void testSetOperation() {
        JButton button = new JButton("+");
        controller.actionPerformed(new ActionEvent(button, ActionEvent.ACTION_PERFORMED, null));
        assertEquals("+", model.getOperation());
    }

    @Test
    void testCalculateResult() {
        controller.actionPerformed(new ActionEvent(new JButton("5"), ActionEvent.ACTION_PERFORMED, null));
        controller.actionPerformed(new ActionEvent(new JButton("+"), ActionEvent.ACTION_PERFORMED, null));
        controller.actionPerformed(new ActionEvent(new JButton("3"), ActionEvent.ACTION_PERFORMED, null));
        controller.actionPerformed(new ActionEvent(new JButton("="), ActionEvent.ACTION_PERFORMED, null));
        assertEquals("8", model.getDisplay());
    }

    @Test
    void testClear() {
        controller.actionPerformed(new ActionEvent(new JButton("5"), ActionEvent.ACTION_PERFORMED, null));
        controller.actionPerformed(new ActionEvent(new JButton("C"), ActionEvent.ACTION_PERFORMED, null));
        assertEquals("0", model.getDisplay());
    }

    @Test
    void testAddDecimal() {
        JButton button = new JButton(".");
        controller.actionPerformed(new ActionEvent(button, ActionEvent.ACTION_PERFORMED, null));
        assertEquals("0.", model.getDisplay());
    }
}