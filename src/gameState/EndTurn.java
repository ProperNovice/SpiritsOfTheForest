package gameState;

import controller.Board;
import controller.Statistics;
import enums.ESpirit;
import model.TileSpirit;
import utils.ArrayList;
import utils.Flow;

public class EndTurn extends AGameState {

	public EndTurn() {

		Class<? extends AGameState> classObject = null;

		if (gameIsLost())
			classObject = EndGameLost.class;
		else if (gameIsEnded())
			classObject = EndGameWin.class;
		else
			classObject = StartNewTurn.class;

		Flow.INSTANCE.executeGameState(classObject);

	}

	private boolean gameIsLost() {

		for (ESpirit eSpirit : ESpirit.values())
			if (Statistics.INSTANCE.statistics.getValue(eSpirit).gameIsLost())
				return true;

		return false;

	}

	private boolean gameIsEnded() {

		for (ArrayList<TileSpirit> list : Board.INSTANCE.board)
			if (!list.isEmpty())
				return false;

		return true;

	}

}
