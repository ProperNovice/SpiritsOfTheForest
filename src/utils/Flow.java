package utils;

import java.lang.reflect.InvocationTargetException;

import gameState.AGameState;

public enum Flow {

	INSTANCE;

	private ArrayList<AGameState> currentGameStateList = new ArrayList<AGameState>(1);
	private AGameState currentGameState = null;
	private ArrayList<Class<? extends AGameState>> flow = new ArrayList<>();

	private Flow() {

	}

	public void proceed() {

		this.currentGameStateList.clear();

		executeGameStateLogger(this.flow.getFirst());
		this.currentGameStateList.addLast(getGameState(this.flow.removeFirst()));

		while (this.currentGameStateList.isOverCapacity())
			this.currentGameStateList.removeLast();

		this.currentGameState = this.currentGameStateList.getFirst();

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
