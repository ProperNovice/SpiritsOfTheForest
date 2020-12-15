package redOrbAlphabet;

import controller.Credentials;
import utils.ImageView;
import utils.ImageViewAble;

public abstract class RedOrbAlphabet implements ImageViewAble {

	public RedOrbAlphabet() {

		String fileName = "misc/redOrbAlphabet/";
		fileName += Credentials.INSTANCE.redOrbAlphabet;
		fileName += "/";
		fileName += getFileName();
		fileName += ".png";

		new ImageView(fileName, this);
		getImageView().setWidth(getWidth());

	}

	protected double getWidth() {
		return Credentials.INSTANCE.redOrbAplhabetBig;
	}

	protected abstract String getFileName();

}
