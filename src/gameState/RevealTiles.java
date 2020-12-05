package gameState;

import controller.Board;
import enums.EText;
import model.TileSpirit;
import utils.ArrayList;
import utils.Flow;
import utils.SelectImageViewManager;

public class RevealTiles extends AGameState {

	public RevealTiles() {

		EText.REVEAL_TILES.show();

	}

	@Override
	protected void executeTextOption(EText eText) {

		for (ArrayList<TileSpirit> list : Board.INSTANCE.board) {

			if (list.isEmpty())
				continue;

			list.getFirst().revealTile();
			list.getLast().revealTile();

			SelectImageViewManager.INSTANCE.addSelectCoordinates(list.getFirst().getPivot(), list.getFirst());
			SelectImageViewManager.INSTANCE.addSelectCoordinates(list.getLast().getPivot(), list.getLast());

		}

		Flow.INSTANCE.proceed();

	}

}
