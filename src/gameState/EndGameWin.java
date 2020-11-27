package gameState;

import enums.EText;

public class EndGameWin extends AEndGame {

	@Override
	protected EText getEText() {
		return EText.YOU_WON;
	}

}
