package gameState;

import controller.Board;
import controller.Statistics;
import enums.ESpirit;
import utils.Flow;

public class StartGame extends AGameState {

	public StartGame() {

		Board.INSTANCE.setUpBoard();

		Flow.INSTANCE.getFlow().addLast(StatisticsUpdateQuantity.class);

		for (ESpirit eSpirit : ESpirit.values())
			Statistics.INSTANCE.statistics.getValue(eSpirit).reset();

		Flow.INSTANCE.executeGameState(StartNewTurn.class);

	}

}
