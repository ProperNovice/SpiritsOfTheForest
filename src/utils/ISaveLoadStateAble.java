package utils;

public interface ISaveLoadStateAble {

	public default void saveOriginal() {
		Logger.INSTANCE.logNewLine("not implemented");
	}

	public default void loadOriginal() {
		Logger.INSTANCE.logNewLine("not implemented");
	}

	public default void saveState() {
		Logger.INSTANCE.logNewLine("not implemented");
	}

	public default void loadState() {
		Logger.INSTANCE.logNewLine("not implemented");
	}

}
