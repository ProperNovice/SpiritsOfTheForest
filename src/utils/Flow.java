package utils;

import java.lang.reflect.InvocationTargetException;

import gameState.AGameState;

public enum Flow {

	INSTANCE;

	private ArrayList<AGameState> currentGameState = new ArrayList<AGameState>(1);
	private ArrayList<Class<? extends AGameState>> flow = new ArrayList<>();

	private Flow() {

	}

	public void proceed() {

		this.currentGameState.clear();

		executeGameStateLogger(this.flow.getFirst());
		this.currentGameState.addLast(getGameState(this.flow.removeFirst()));

		while (this.currentGameState.isOverCapacity())
			this.currentGameState.removeLast();

	}

	public void executeGameState(Class<? extends AGameState> gameStateClass) {

		this.flow.addFirst(gameStateClass);
		proceed();

	}

	private void executeGameStateLogger(Class<? extends AGameState> gameStateClass) {

		Logger.INSTANCE.log("executing gamestate");
		Logger.INSTANCE.logNewLine(gameStateClass);

	}

	public ArrayList<Class<? extends AGameState>> getFlow() {
		return this.flow;
	}

	public ArrayList<AGameState> getCurrentGameState() {
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
