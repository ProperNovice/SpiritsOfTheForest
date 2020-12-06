package gameState;

import utils.Flow;

public class RestartGame extends AGameState {

	public RestartGame() {

		Flow.INSTANCE.print();
		Flow.INSTANCE.executeGameState(StartGame.class);

	}

}
