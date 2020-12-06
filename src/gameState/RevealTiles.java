package gameState;

import controller.Board;
import model.TileSpirit;
import utils.ArrayList;
import utils.Flow;

public class RevealTiles extends AGameState {

	public RevealTiles() {

		for (ArrayList<TileSpirit> list : Board.INSTANCE.board) {

			if (list.isEmpty())
				continue;

			list.getFirst().revealTile();
			list.getLast().revealTile();

//			SelectImageViewManager.INSTANCE.addSelectCoordinates(list.getFirst().getPivot(), list.getFirst());
//			SelectImageViewManager.INSTANCE.addSelectCoordinates(list.getLast().getPivot(), list.getLast());

		}	

		Flow.INSTANCE.proceed();

	}

}
