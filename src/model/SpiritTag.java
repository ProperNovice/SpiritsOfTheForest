package model;

import controller.Credentials;
import enums.ERedOrbClass;
import enums.ESpirit;
import redOrbAlphabet.RedOrbAlphabet;
import redOrbAlphabet.RedOrbAlphabetMinus;
import redOrbAlphabet.RedOrbAlphabetPlus;
import utils.ImageViewAble;
import utils.ObjectPool;

public class SpiritTag {

	private RedOrbAlphabet symbol = null, numberDifferenceImageView = null, numberQuantityImageView = null;
	private int numberDifferenceInteger = 0, numberQuantityInteger = 0;
	private double x, y;

	public SpiritTag(ESpirit eSpirit, double x, double y) {

		Spirit spirit = new Spirit(eSpirit);
		this.x = x;
		this.y = y;

		spirit.getImageView().relocateTopLeft(this.x + 2 * Credentials.INSTANCE.dTile.x, this.y);

	}

	private void handleIndicators() {

		releaseImageView(this.symbol);
		releaseImageView(this.numberDifferenceImageView);
		releaseImageView(this.numberQuantityImageView);

		// symbol

		this.symbol = null;

		if (this.numberDifferenceInteger > 0)
			this.symbol = ObjectPool.INSTANCE.acquire(RedOrbAlphabetPlus.class);
		else if (this.numberDifferenceInteger < 0)
			this.symbol = ObjectPool.INSTANCE.acquire(RedOrbAlphabetMinus.class);

		if (this.symbol != null) {

			this.symbol.getImageView().setVisible(true);
			this.symbol.getImageView().relocateTopLeft(this.x, this.y);

		}

		// number difference

		this.numberDifferenceImageView = ObjectPool.INSTANCE
				.acquire(ERedOrbClass.INSTANCE.numbers.getValue(Math.abs(this.numberDifferenceInteger)));
		this.numberDifferenceImageView.getImageView().setVisible(true);

		this.numberDifferenceImageView.getImageView().relocateTopLeft(this.x + Credentials.INSTANCE.dTile.x, this.y);

		// number quantity

		this.numberQuantityImageView = ObjectPool.INSTANCE
				.acquire(ERedOrbClass.INSTANCE.numbers.getValue(this.numberQuantityInteger));
		this.numberQuantityImageView.getImageView().setVisible(true);

		this.numberQuantityImageView.getImageView().relocateTopLeft(this.x + 3 * Credentials.INSTANCE.dTile.x, this.y);

	}

	private void releaseImageView(ImageViewAble imageViewAble) {

		if (imageViewAble == null)
			return;

		ObjectPool.INSTANCE.release(imageViewAble);
		imageViewAble.getImageView().setVisible(false);

	}

	public void addSpiritsDifferenceToPlayer(int count) {
		handleSpiritDifference(count);
	}

	public void addSpiritsDifferenceToOpposition(int count) {
		handleSpiritDifference(-count);
	}

	private void handleSpiritDifference(int count) {

		this.numberDifferenceInteger += count;

		handleIndicators();

	}

	public void setQuantity(int count) {
		this.numberQuantityInteger = count;
		handleIndicators();
	}

}
