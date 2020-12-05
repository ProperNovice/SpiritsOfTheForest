package model;

import controller.Credentials;
import enums.ELayerZ;
import enums.ESpirit;
import utils.EventHandler.EventHandlerAble;
import utils.Flow;
import utils.ImageView;
import utils.ImageViewAble;

public class Spirit implements ImageViewAble, EventHandlerAble {

	private ESpirit eSpirit = null;

	public Spirit(ESpirit eSpirit) {

		this.eSpirit = eSpirit;

		String fileName = this.eSpirit.toString();
		fileName = fileName.toLowerCase();
		fileName = fileName.replaceAll("_", " ");
		fileName += ".jpg";

		new ImageView(fileName, this, ELayerZ.SPIRIT_FRONT);
		getImageView().setDimensions(Credentials.INSTANCE.dTile);

	}

	public ESpirit getESpirit() {
		return this.eSpirit;
	}

	@Override
	public void handleMouseButtonPressedPrimary() {
		Flow.INSTANCE.getCurrentGameState().handleSpiritPressed(this);
	}

}
