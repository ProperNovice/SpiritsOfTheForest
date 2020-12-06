package gameState;

import utils.Flow;

public class StartNewTurn extends AGameState {

	public StartNewTurn() {

		Flow.INSTANCE.getFlow().addLast(RevealTiles.class);
		Flow.INSTANCE.getFlow().addLast(ChooseTile.class);
		Flow.INSTANCE.getFlow().addLast(StatisticsUpdateQuantity.class);
		Flow.INSTANCE.getFlow().addLast(EndTurn.class);

		Flow.INSTANCE.proceed();

	}

}
