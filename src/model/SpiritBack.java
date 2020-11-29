package model;

import controller.Credentials;
import enums.ELayerZ;
import utils.ImageView;
import utils.ImageViewAble;

public class SpiritBack implements ImageViewAble {

	public SpiritBack() {

		new ImageView("back.jpg", this, ELayerZ.SPIRIT_BACK);
		getImageView().setDimensions(Credentials.INSTANCE.dTile);

	}

}
