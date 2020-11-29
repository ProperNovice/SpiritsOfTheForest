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

		System.out.println(fileName);
		new ImageView(fileName, this);
		getImageView().setWidth(Credentials.INSTANCE.redOrbAplhabet);

	}

	protected abstract String getFileName();

}
