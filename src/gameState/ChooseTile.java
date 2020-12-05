package gameState;

import controller.Board;
import controller.Statistics;
import enums.EText;
import model.SpiritTag;
import model.TileSpirit;
import utils.ArrayList;
import utils.Flow;
import utils.SelectImageViewManager;
import utils.ShutDown;

public class ChooseTile extends AGameState {

	private TileSpirit tileSpiritPlayer = null;
	private TileSpirit tileSpiritOpposition = null;

	public ChooseTile() {
		EText.CHOOSE_TILE.show();
	}

	@Override
	public void handleTilePressedBoard(TileSpirit tileSpirit) {

		concealText();

		SelectImageViewManager.INSTANCE.releaseSelectImageViews();
		this.tileSpiritPlayer = tileSpirit;
		setTileSpiritOpposition();
		printTiles();

		this.tileSpiritPlayer.setVisible(false);
		this.tileSpiritOpposition.setVisible(false);

		addTilesToStatistics();

		Flow.INSTANCE.proceed();

	}

	private void setTileSpiritOpposition() {

		ArrayList<TileSpirit> list = null;

		for (ArrayList<TileSpirit> listTemp : Board.INSTANCE.board) {

			if (!listTemp.contains(this.tileSpiritPlayer))
				continue;

			list = listTemp;
			break;

		}

		if (list.getFirst().equals(this.tileSpiritPlayer))
			this.tileSpiritOpposition = list.getLast();
		else if (list.getLast().equals(this.tileSpiritPlayer))
			this.tileSpiritOpposition = list.getFirst();
		else
			ShutDown.INSTANCE.execute();

		list.removeFirst();
		list.removeLast();

	}

	private void printTiles() {

		System.out.println("tile player");
		this.tileSpiritPlayer.print();

		System.out.println("tile opposition");
		this.tileSpiritOpposition.print();

	}

	private void addTilesToStatistics() {

		SpiritTag spiritTag = null;

		// player

		spiritTag = Statistics.INSTANCE.statistics.getValue(this.tileSpiritPlayer.getESpirit());
		spiritTag.addSpiritsDifferenceToPlayer(this.tileSpiritPlayer.getListSpirit().getArrayList().size());

		// opposition

		spiritTag = Statistics.INSTANCE.statistics.getValue(this.tileSpiritOpposition.getESpirit());
		spiritTag.addSpiritsDifferenceToOpposition(this.tileSpiritOpposition.getListSpirit().getArrayList().size());

	}

}
