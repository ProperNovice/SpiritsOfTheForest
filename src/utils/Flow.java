package utils;

import java.lang.reflect.InvocationTargetException;

import gameState.AGameState;

public enum Flow {

	INSTANCE;

	private AGameState currentGameState = null;
	private ArrayList<Class<? extends AGameState>> flow = new ArrayList<>();

	private Flow() {

	}

	public void proceed() {

		executeGameStateLogger(this.flow.getFirst());
		this.currentGameState = getGameState(this.flow.removeFirst());

	}

	public void executeGameState(Class<? extends AGameState> gameStateClass) {

		executeGameStateLogger(gameStateClass);
		this.currentGameState = getGameState(gameStateClass);

	}

	private void executeGameStateLogger(Class<? extends AGameState> gameStateClass) {

		Logger.INSTANCE.log("executing gamestate");
		Logger.INSTANCE.logNewLine(gameStateClass);

	}

	public ArrayList<Class<? extends AGameState>> getFlow() {
		return this.flow;
	}

	public AGameState getCurrentGameState() {
		return this.currentGameState;
	}

	public void print() {
		Logger.INSTANCE.log(getClass());
		this.flow.print();
	}

	private AGameState getGameState(Class<? extends AGameState> gameStateClass) {

		try {

			return gameStateClass.getConstructor().newInstance();

		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {

			e.printStackTrace();
			ShutDown.INSTANCE.execute();
			return null;

		}

	}

}
