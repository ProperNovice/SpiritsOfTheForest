package gameState;

import controller.Board;
import controller.Statistics;
import enums.ESpirit;
import enums.EText;
import utils.ArrayList;
import utils.Flow;

public class StartGame extends AGameState {

	public StartGame() {

		concealText();

		Board.INSTANCE.setUpBoard();

		for (ESpirit eSpirit : ESpirit.values())
			Statistics.INSTANCE.statistics.getValue(eSpirit).reset();

		new StatisticsUpdateQuantityNoProceed();

		EText.NORMAL.show();
		EText.HARD.show();
		EText.VERY_HARD.show();

	}

	@Override
	protected void executeTextOption(EText eText) {

		if (eText.equals(EText.HARD))
			handleAddSpirits(1, 2);
		else if (eText.equals(EText.VERY_HARD))
			handleAddSpirits(2, 4);

		Flow.INSTANCE.getFlow().addLast(StatisticsUpdateQuantity.class);

		Flow.INSTANCE.executeGameState(StartNewTurn.class);

	}

	private void handleAddSpirits(int player, int opposition) {

		ArrayList<ESpirit> list = new ArrayList<ESpirit>(ESpirit.values());

		// player

		for (int counter = 1; counter <= player; counter++)
			Statistics.INSTANCE.statistics.getValue(list.removeRandom()).addSpiritsDifferenceToPlayer(1);

		// opposition

		for (int counter = 1; counter <= opposition; counter++)
			Statistics.INSTANCE.statistics.getValue(list.removeRandom()).addSpiritsDifferenceToOpposition(1);

	}

}
