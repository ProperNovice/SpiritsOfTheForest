package gameState;

public class StatisticsUpdateQuantityNoProceed extends AStatisticsUpdateQuantity {

	@Override
	protected boolean proceed() {
		return false;
	}

}
