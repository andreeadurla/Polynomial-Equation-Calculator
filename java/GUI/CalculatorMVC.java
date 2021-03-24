package GUI;

public class CalculatorMVC {

	public static void main(String[] args) {
		ViewCalculator calcView = new ViewCalculator();
		ControllerCalculator calcContr = new ControllerCalculator(calcView);
		calcView.setVisible(true);
	}
}

