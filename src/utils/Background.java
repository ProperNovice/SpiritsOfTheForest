package utils;

import enums.ELayerZ;
import utils.EventHandler.EventHandlerAble;

public class Background implements ImageViewAble, EventHandlerAble {

	public Background() {

		new ImageView("misc/backgroundDark.png", this, ELayerZ.BACKGROUND);

	}

	@Override
	public void handleMouseButtonPressedSecondary() {
		ShutDown.INSTANCE.execute();
	}

}
