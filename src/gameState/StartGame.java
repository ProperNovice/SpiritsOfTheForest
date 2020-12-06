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

		EText.CHOOSE_DIFFICULTY_LEVEL.show();
		EText.NORMAL.show();
		EText.HARD.show();

	}

	@Override
	protected void executeTextOption(EText eText) {

		if (eText.equals(EText.HARD)) {

			ArrayList<ESpirit> list = new ArrayList<ESpirit>(ESpirit.values());

			// player

			Statistics.INSTANCE.statistics.getValue(list.removeRandom()).addSpiritsDifferenceToPlayer(1);

			// opposition

			for (int counter = 1; counter <= 2; counter++)
				Statistics.INSTANCE.statistics.getValue(list.removeRandom()).addSpiritsDifferenceToOpposition(1);

		}

		Flow.INSTANCE.getFlow().addLast(StatisticsUpdateQuantity.class);

		Flow.INSTANCE.executeGameState(StartNewTurn.class);

	}

}
