package controller;

import utils.ArrayList;
import utils.NumbersPair;
import utils.SelectImageView;

public enum Credentials {

	INSTANCE;

	public final String primaryStageTitle = "Spirits of the Forest";
	public final double gapBetweenBorders = 25, textHeight = 50, selectImageViewAbleRatioDimensions = 0.5,
			selectImageViewAbleRatioCoordinateX = 0.5, selectImageViewAbleRatioCoordinateY = 0.5,
			selectEventHandlerAbleWidth = 100, animationStep = 4;
	public ArrayList<Class<?>> lineCastExcludeList = new ArrayList<Class<?>>();
	public NumbersPair dFrame, dGapBetweenComponents, dGapBetweenComponentsLineCast, dTile;
	public NumbersPair cTextPanel;

	private Credentials() {

		this.lineCastExcludeList.addLast(SelectImageView.class);

		double x = 0, y = 0;

		this.dGapBetweenComponents = new NumbersPair(4, 4);
		this.dGapBetweenComponentsLineCast = this.dGapBetweenComponents;

		this.cTextPanel = new NumbersPair(x, y);

		this.dTile = new NumbersPair(110, 110);

		y = 9 * this.dTile.y + 8 * this.dGapBetweenComponents.y + 2 * this.gapBetweenBorders;
		this.dFrame = new NumbersPair(1920, y);

	}

}