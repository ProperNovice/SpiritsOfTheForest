package utils;

import controller.Credentials;
import enums.EText;
import utils.Enums.TextTypeEnum;

public enum Text {

	INSTANCE;

	private ArrayList<TextGame> textGame = new ArrayList<>();
	private ArrayList<TextGame> textGameShowing = new ArrayList<>();

	private Text() {
		createTexts();
	}

	private void createTexts() {

		for (EText eText : EText.values())
			this.textGame.addLast(new TextGame(eText));

	}

	public void showText(EText eText) {
		showText(eText, "");
	}

	public void showText(EText eText, String text) {

		for (TextGame textGame : this.textGame) {

			if (!textGame.getTextEnum().equals(eText))
				continue;

			textGame.getText().setText(text);
			this.textGameShowing.addLast(textGame);
			break;

		}

		showText();

	}

	private void showText() {

		for (TextGame textGame : this.textGameShowing) {

			textGame.toFront();
			textGame.setVisible(true);

			double x = Credentials.INSTANCE.cTextPanel.x;
			double y = Credentials.INSTANCE.cTextPanel.y;
			y += Credentials.INSTANCE.textHeight * this.textGameShowing.indexOf(textGame);

			textGame.relocate(x, y);

		}

	}

	public void concealText() {

		for (TextGame textGame : this.textGameShowing)
			textGame.setVisible(false);

		this.textGameShowing.clear();

	}

	public EText getTextEnumOptionShowing(int textOptionListOrder) {

		int textOptionId = 0;
		EText eText = null;

		for (TextGame textGame : this.textGameShowing) {

			EText eTextTemp = textGame.getTextEnum();

			if (eTextTemp.getTextTypeEnum() == TextTypeEnum.INDICATOR)
				continue;

			textOptionId++;

			if (textOptionListOrder != textOptionId)
				continue;

			eText = eTextTemp;
			break;

		}

		return eText;

	}

}
