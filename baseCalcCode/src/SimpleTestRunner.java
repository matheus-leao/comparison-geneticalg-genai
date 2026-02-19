import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * Simple test runner for CalculatorController without external dependencies
 */
public class SimpleTestRunner {
    private CalculatorModel model;
    private CalculatorView view;
    private CalculatorController controller;
    private int testsRun = 0;
    private int testsPassed = 0;
    private int testsFailed = 0;

    public void setUp() {
        model = new CalculatorModel();
        view = new CalculatorView();
        controller = new CalculatorController(model, view);
        view.setVisible(false);
    }

    public void tearDown() {
        view.dispose();
    }

    public void testAddDigit() {
        setUp();
        try {
            JButton button = new JButton("5");
            controller.actionPerformed(new ActionEvent(button, ActionEvent.ACTION_PERFORMED, null));
            assert "5".equals(model.getDisplay()) : "Expected '5', got '" + model.getDisplay() + "'";
            testsPassed++;
            System.out.println("✓ testAddDigit passed");
        } catch (AssertionError e) {
            testsFailed++;
            System.out.println("✗ testAddDigit failed: " + e.getMessage());
        } finally {
            tearDown();
        }
        testsRun++;
    }

    public void testSetOperation() {
        setUp();
        try {
            JButton button = new JButton("+");
            controller.actionPerformed(new ActionEvent(button, ActionEvent.ACTION_PERFORMED, null));
            assert "+".equals(model.getOperation()) : "Expected '+', got '" + model.getOperation() + "'";
            testsPassed++;
            System.out.println("✓ testSetOperation passed");
        } catch (AssertionError e) {
            testsFailed++;
            System.out.println("✗ testSetOperation failed: " + e.getMessage());
        } finally {
            tearDown();
        }
        testsRun++;
    }

    public void testCalculateResult() {
        setUp();
        try {
            controller.actionPerformed(new ActionEvent(new JButton("5"), ActionEvent.ACTION_PERFORMED, null));
            controller.actionPerformed(new ActionEvent(new JButton("+"), ActionEvent.ACTION_PERFORMED, null));
            controller.actionPerformed(new ActionEvent(new JButton("3"), ActionEvent.ACTION_PERFORMED, null));
            controller.actionPerformed(new ActionEvent(new JButton("="), ActionEvent.ACTION_PERFORMED, null));
            assert "8".equals(model.getDisplay()) : "Expected '8', got '" + model.getDisplay() + "'";
            testsPassed++;
            System.out.println("✓ testCalculateResult passed");
        } catch (AssertionError e) {
            testsFailed++;
            System.out.println("✗ testCalculateResult failed: " + e.getMessage());
        } finally {
            tearDown();
        }
        testsRun++;
    }

    public void testClear() {
        setUp();
        try {
            controller.actionPerformed(new ActionEvent(new JButton("5"), ActionEvent.ACTION_PERFORMED, null));
            controller.actionPerformed(new ActionEvent(new JButton("C"), ActionEvent.ACTION_PERFORMED, null));
            assert "0".equals(model.getDisplay()) : "Expected '0', got '" + model.getDisplay() + "'";
            testsPassed++;
            System.out.println("✓ testClear passed");
        } catch (AssertionError e) {
            testsFailed++;
            System.out.println("✗ testClear failed: " + e.getMessage());
        } finally {
            tearDown();
        }
        testsRun++;
    }

    public void testAddDecimal() {
        setUp();
        try {
            JButton button = new JButton(".");
            controller.actionPerformed(new ActionEvent(button, ActionEvent.ACTION_PERFORMED, null));
            assert "0.".equals(model.getDisplay()) : "Expected '0.', got '" + model.getDisplay() + "'";
            testsPassed++;
            System.out.println("✓ testAddDecimal passed");
        } catch (AssertionError e) {
            testsFailed++;
            System.out.println("✗ testAddDecimal failed: " + e.getMessage());
        } finally {
            tearDown();
        }
        testsRun++;
    }

    public void runAllTests() {
        System.out.println("=== Running Calculator Tests ===\n");
        testAddDigit();
        testSetOperation();
        testCalculateResult();
        testClear();
        testAddDecimal();
        
        System.out.println("\n=== Test Results ===");
        System.out.println("Tests run: " + testsRun);
        System.out.println("Passed: " + testsPassed);
        System.out.println("Failed: " + testsFailed);
        
        if (testsFailed == 0) {
            System.out.println("\n✓ All tests passed!");
        } else {
            System.out.println("\n✗ Some tests failed!");
        }
    }

    public static void main(String[] args) {
        SimpleTestRunner runner = new SimpleTestRunner();
        runner.runAllTests();
    }
}
