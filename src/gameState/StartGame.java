package gameState;

import enums.ESpirit;
import model.Spirit;

public class StartGame extends AGameState {

	public StartGame() {

		for (ESpirit eTile : ESpirit.values())
			new Spirit(eTile);

	}

}
