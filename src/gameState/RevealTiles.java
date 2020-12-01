package gameState;

import controller.Board;
import enums.EText;
import model.TileSpirit;
import utils.ArrayList;
import utils.Flow;

public class RevealTiles extends AGameState {

	public RevealTiles() {

		EText.REVEAL_TILES.show();

		

	}

	@Override
	protected void executeTextOption(EText eText) {
		
		Flow.INSTANCE.getCurrentGameState().print();

		for (ArrayList<TileSpirit> list : Board.INSTANCE.board) {

			list.getFirst().revealTile();
			list.getLast().revealTile();

		}
		
		Flow.INSTANCE.executeGameState(RestartGame.class);
		
		Flow.INSTANCE.getCurrentGameState().print();

	}

}
