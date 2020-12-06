package gameState;

import controller.Board;
import utils.Flow;

public class StartGame extends AGameState {

	public StartGame() {

		Board.INSTANCE.setUpBoard();
		Flow.INSTANCE.getFlow().addLast(StatisticsUpdateQuantity.class);

		Flow.INSTANCE.executeGameState(StartNewTurn.class);

	}

}
