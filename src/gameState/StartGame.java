package gameState;

import controller.Board;
import controller.Credentials;

public class StartGame extends AGameState {

	public StartGame() {

		Board.INSTANCE.setUpBoard();

		Credentials.INSTANCE.dTile.print();
		Credentials.INSTANCE.dFrame.print();

	}

}
