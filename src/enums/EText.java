package enums;

import utils.Enums.TextTypeEnum;
import utils.Text;

public enum EText {

	CONTINUE(TextTypeEnum.OPTION),
	RESTART(TextTypeEnum.OPTION),
	YOU_WON(TextTypeEnum.INDICATOR),
	YOU_LOST(TextTypeEnum.INDICATOR),
	REVEAL_TILES(TextTypeEnum.OPTION),
	
	;

	private TextTypeEnum textTypeEnum = null;
	private String string = null;

	private EText(TextTypeEnum textTypeEnum) {

		this.textTypeEnum = textTypeEnum;

		this.string = this.toString();
		this.string = this.string.toLowerCase();
		this.string = this.string.replaceAll("_", " ");
		this.string = this.string.replaceFirst(String.valueOf(this.string.charAt(0)),
				String.valueOf(this.string.charAt(0)).toUpperCase());

	}

	public void show() {
		Text.INSTANCE.showText(this);
	}

	public void show(String string) {
		Text.INSTANCE.showText(this, string);
	}

	public String getString() {
		return this.string;
	}

	public TextTypeEnum getTextTypeEnum() {
		return this.textTypeEnum;
	}

}
