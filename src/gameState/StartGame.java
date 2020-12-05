package gameState;

import controller.Board;
import utils.Flow;

public class StartGame extends AGameState {

	public StartGame() {

		Board.INSTANCE.setUpBoard();

		Flow.INSTANCE.getFlow().addLast(StatisticsUpdateQuantity.class);
		Flow.INSTANCE.getFlow().addLast(RevealTiles.class);
		Flow.INSTANCE.getFlow().addLast(ChooseTile.class);
		Flow.INSTANCE.getFlow().addLast(StatisticsUpdateQuantity.class);

		Flow.INSTANCE.getFlow().addLast(RevealTiles.class);
		Flow.INSTANCE.getFlow().addLast(ChooseTile.class);

		Flow.INSTANCE.getFlow().addLast(RestartGame.class);
		
		Board.INSTANCE.setUpBoard();
		
		Flow.INSTANCE.proceed();

	}

}
