package utils;

import enums.ELayerZ;
import utils.EventHandler.EventHandlerAble;

public class SelectImageView implements ImageViewAble, EventHandlerAble {

	public SelectImageView() {

		new ImageView("misc/select.png", this, ELayerZ.SELECT_IMAGEVIEW);
		this.getImageView().setVisible(false);

	}

	@Override
	public void handleMouseButtonPressedPrimary() {
		SelectImageViewManager.INSTANCE.handleMouseButtonPressedPrimary(this);
	}

	@Override
	public void handleMouseButtonPressedSecondary() {
		SelectImageViewManager.INSTANCE.handleMouseButtonPressedSecondary(this);
	}

	@Override
	public void handleMouseEntered() {
		SelectImageViewManager.INSTANCE.handleMouseEntered(this);
	}

	@Override
	public void handleMouseExited() {
		SelectImageViewManager.INSTANCE.handleMouseExited(this);
	}

}
