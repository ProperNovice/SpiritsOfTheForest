package controller;

import enums.ESpirit;
import model.TileSpirit;
import utils.ArrayList;
import utils.NumbersPair;

public enum Board {

	INSTANCE;

	private ArrayList<TileSpirit> tileSpirits = new ArrayList<TileSpirit>();
	private ArrayList<ArrayList<NumbersPair>> coordinates = new ArrayList<ArrayList<NumbersPair>>();
	public ArrayList<ArrayList<TileSpirit>> board = new ArrayList<ArrayList<TileSpirit>>();

	private Board() {

	}

	public void setUpBoard() {

		this.tileSpirits.loadOriginal();

		for (TileSpirit tileSpirit : this.tileSpirits)
			tileSpirit.setVisible(true);

		for (int row = 0; row < 4; row++) {

			ArrayList<TileSpirit> list = this.board.get(row);
			list.clear();

			for (int column = 0; column < 12; column++) {

				TileSpirit tileSpirit = this.tileSpirits.removeRandom();

				tileSpirit.setPivotRelocate(this.coordinates.get(row).get(column));
				list.addLast(tileSpirit);

			}

		}

	}

	public void instantiate() {

		createTiles();
		createCoordinates();
		createBoardList();

	}

	private void createBoardList() {

		for (int counter = 1; counter <= 4; counter++)
			this.board.addLast(new ArrayList<TileSpirit>(12));

	}

	private void createCoordinates() {

		double x = Credentials.INSTANCE.cBoard.x;
		double y = Credentials.INSTANCE.cBoard.y;
		double gapX = Credentials.INSTANCE.dTile.x + Credentials.INSTANCE.dGapBetweenComponents.x;
		double gapY = 2 * Credentials.INSTANCE.dTile.y + Credentials.INSTANCE.dGapBetweenComponents.y;

		for (int row = 1; row <= 4; row++) {

			ArrayList<NumbersPair> list = new ArrayList<NumbersPair>();
			this.coordinates.addLast(list);

			for (int column = 1; column <= 12; column++) {

				list.addLast(new NumbersPair(x, y));
				x += gapX;

			}

			x = Credentials.INSTANCE.cBoard.x;
			y += gapY;

		}

	}

	private void createTiles() {

		addTileSpirit(ESpirit.BRANCHES, 1, 4);
		addTileSpirit(ESpirit.BRANCHES, 2, 2);

		addTileSpirit(ESpirit.DEW_DROPS, 1, 3);
		addTileSpirit(ESpirit.DEW_DROPS, 2, 2);

		addTileSpirit(ESpirit.FLOWESS, 1, 2);
		addTileSpirit(ESpirit.FLOWESS, 2, 2);

		addTileSpirit(ESpirit.FRUITS, 1, 4);
		addTileSpirit(ESpirit.FRUITS, 2, 1);

		addTileSpirit(ESpirit.LEAVES, 1, 4);
		addTileSpirit(ESpirit.LEAVES, 2, 2);

		addTileSpirit(ESpirit.MOSS, 1, 3);
		addTileSpirit(ESpirit.MOSS, 2, 1);

		addTileSpirit(ESpirit.MUSHROOMS, 1, 3);
		addTileSpirit(ESpirit.MUSHROOMS, 2, 2);

		addTileSpirit(ESpirit.VINES, 1, 4);
		addTileSpirit(ESpirit.VINES, 2, 2);

		addTileSpirit(ESpirit.WEB_SPIDESS, 1, 4);
		addTileSpirit(ESpirit.WEB_SPIDESS, 2, 3);

		this.tileSpirits.saveOriginal();

	}

	private void addTileSpirit(ESpirit eSpirit, int spiritCounts, int numberOfTiles) {

		for (int numberOfTilesCounter = 1; numberOfTilesCounter <= numberOfTiles; numberOfTilesCounter++)
			this.tileSpirits.addLast(new TileSpirit(eSpirit, spiritCounts));

	}

}
