package controller;

import utils.ArrayList;
import utils.NumbersPair;
import utils.SelectImageView;

public enum Credentials {

	INSTANCE;

	public final String primaryStageTitle = "Spirits of the Forest", redOrbAlphabet = "bw";
	public final double gapBetweenBorders = 25, textHeight = 40, selectImageViewAbleRatioDimensions = 0.5,
			selectImageViewAbleRatioCoordinateX = 0.5, selectImageViewAbleRatioCoordinateY = 0.5,
			selectEventHandlerAbleWidth, animationStep = 4, redOrbAplhabetBig, redOrbAplhabetSmall;
	public ArrayList<Class<?>> lineCastExcludeList = new ArrayList<Class<?>>();
	public NumbersPair dFrame, dGapBetweenComponents, dGapBetweenComponentsLineCast, dTile;
	public NumbersPair cTextPanel, cBoard, cStatistics;

	private Credentials() {

		this.lineCastExcludeList.addLast(SelectImageView.class);

		double x = 0, y = 0;

		this.dGapBetweenComponents = new NumbersPair(4, 4);
		this.dGapBetweenComponentsLineCast = this.dGapBetweenComponents;

		this.cTextPanel = new NumbersPair(this.gapBetweenBorders, this.gapBetweenBorders);

		this.dTile = new NumbersPair(110, 110);

		this.selectEventHandlerAbleWidth = this.dTile.x / 3;

		this.redOrbAplhabetBig = this.dTile.x;
		this.redOrbAplhabetSmall = this.redOrbAplhabetBig * 0.6;

		x = 2 * this.gapBetweenBorders + 16 * this.dTile.x + 12 * this.dGapBetweenComponents.x;
		y = 9 * this.dTile.y + 8 * this.dGapBetweenComponents.y + 2 * this.gapBetweenBorders;
		this.dFrame = new NumbersPair(x, y);

		x = this.gapBetweenBorders + this.dTile.x / 2;
		y = this.gapBetweenBorders + this.dTile.y;
		y = this.dFrame.y - this.gapBetweenBorders - 8 * this.dTile.y - 3 * this.dGapBetweenComponents.y + this.dTile.y;

		this.cBoard = new NumbersPair(x, y);

		x = this.dFrame.x - this.gapBetweenBorders - 4 * this.dTile.x;
		y = this.gapBetweenBorders;
		this.cStatistics = new NumbersPair(x, y);

	}

}
