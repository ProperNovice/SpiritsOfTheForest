package utils;

import javafx.scene.text.Font;
import utils.EventHandler.EventHandlerAble;

public class TextIndicator implements INode {

	protected javafx.scene.text.Text text = null;
	protected String textVisibleTrue = "", textVisibleFalse = "", textOriginal = "";

	public TextIndicator() {
		this(null);
	}

	public TextIndicator(String text) {

		if (text == null)
			this.text = new javafx.scene.text.Text();

		else
			this.text = new javafx.scene.text.Text(text);

		this.textOriginal += text;

		ParentInstance.INSTANCE.getParentInstance().addNode(this.text);

	}

	public TextIndicator(int text) {
		this(Integer.toString(text));
	}

	public void setVisible(final boolean value) {

		if (value)
			PlatformFX.runLater(() -> this.text.setText(this.textVisibleTrue));
		else
			PlatformFX.runLater(() -> this.text.setText(this.textVisibleFalse));

	}

	public void toBack() {
		PlatformFX.runLater(() -> this.text.toBack());
	}

	@Override
	public void toFront() {
		PlatformFX.runLater(() -> this.text.toFront());
	}

	@Override
	public final double getLayoutX() {
		return this.text.getLayoutX();
	}

	@Override
	public final double getLayoutY() {
		return this.text.getLayoutY();
	}

	@Override
	public double getWidth() {
		return this.text.minWidth(0);
	}

	@Override
	public double getHeight() {
		return this.text.minHeight(0);
	}

	public void setWidth(final double pixels) {

		PlatformFX.runLater(() -> {

			int font = 1;
			setFont(font);

			while (getWidth() <= pixels)
				setFont(++font);

			font--;
			setFont(font);

		});

	}

	public void setHeight(final double pixels) {

		PlatformFX.runLater(() -> {

			int font = 1;
			setFont(font);

			while (getHeight() <= pixels)
				setFont(++font);

			setFont(font);

		});

	}

	@Override
	public void relocateTopLeft(final double x, final double y) {
		PlatformFX.runLater(() -> this.text.relocate(x, y));
	}

	@Override
	public void relocateTopLeft(final NumbersPair numbersPair) {
		relocateTopLeft(numbersPair.x, numbersPair.y);
	}

	public void setEventHandler(EventHandlerAble eventHandlerAble) {

		PlatformFX.runLater(() -> {

			EventHandler eventHandler = new EventHandler(eventHandlerAble);

			this.text.setOnMouseEntered(eventHandler);
			this.text.setOnMouseExited(eventHandler);
			this.text.setOnMousePressed(eventHandler);

		});

	}

	public final void setText(String text) {
		this.textVisibleTrue = this.textOriginal + text;
	}

	protected final void setFont(final int value) {
		PlatformFX.runLater(() -> this.text.setFont(new Font(value)));
	}

	@Override
	public NumbersPair getLayout() {
		return new NumbersPair(getLayoutX(), getLayoutY());
	}

}
