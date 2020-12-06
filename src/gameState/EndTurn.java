package gameState;

import utils.Flow;

public class EndTurn extends AGameState {

	public EndTurn() {

		Flow.INSTANCE.getFlow().addLast(StartNewTurn.class);

		Flow.INSTANCE.proceed();

	}

}
