package gameState;

import controller.Board;
import redOrbAlphabet.RedOrbAlphabetFive;

public class StartGame extends AGameState {

	public StartGame() {

		Board.INSTANCE.setUpBoard();
		
		new RedOrbAlphabetFive();

	}

}
