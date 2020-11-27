package controller;

import utils.ISaveLoadStateAble;

public enum Modifiers implements ISaveLoadStateAble {

	INSTANCE;

	private Modifiers() {
		saveOriginal();
	}

	@Override
	public void saveOriginal() {
		loadOriginal();
	}

	@Override
	public void loadOriginal() {

	}

	@Override
	public void saveState() {

	}

	@Override
	public void loadState() {

	}

}
