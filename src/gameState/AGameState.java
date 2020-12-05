package gameState;

import controller.Board;
import enums.EText;
import javafx.scene.input.KeyCode;
import model.Spirit;
import model.TileSpirit;
import utils.ArrayList;
import utils.KeyCodeHandler;
import utils.Logger;
import utils.Text;

public abstract class AGameState {

	public final void handleTextOptionPressed(EText textEnum) {

		Logger.INSTANCE.log("text option executing");
		Logger.INSTANCE.logNewLine(textEnum);

		Text.INSTANCE.concealText();
		executeTextOption(textEnum);

	}

	public final void executeKeyPressed(KeyCode keyCode) {

		int textOptionToHandle = KeyCodeHandler.INSTANCE.getKeyCodeInt(keyCode);

		EText textEnumPressed = Text.INSTANCE.getTextEnumOptionShowing(textOptionToHandle);

		if (textEnumPressed == null)
			return;

		Logger.INSTANCE.log("executing key pressed -> " + keyCode);
		handleTextOptionPressed(textEnumPressed);

	}

	protected void executeTextOption(EText eText) {

	}

	protected final void concealText() {
		Text.INSTANCE.concealText();
	}

	public final void handleSpiritPressed(Spirit spirit) {

		for (ArrayList<TileSpirit> list : Board.INSTANCE.board)
			for (TileSpirit tileSpirit : list.clone())
				if (tileSpirit.getListSpirit().getArrayList().contains(spirit))
					handleTilePressedBoard(tileSpirit);

	}

	public void handleTilePressedBoard(TileSpirit tileSpirit) {

	}

}
