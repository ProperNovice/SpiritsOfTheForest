package controller;

import utils.ArrayList;
import utils.Logger;

public enum Lists {

	INSTANCE;

	public ArrayList<ArrayList<? extends Object>> lists = new ArrayList<ArrayList<? extends Object>>();

	public void instantiate() {

		createLists();
		repleteLists();
		saveLists();
		loadLists();

		Logger.INSTANCE.logNewLine("lists instantiated -> " + this.lists.size());

	}

	private void saveLists() {

		for (ArrayList<? extends Object> list : this.lists)
			list.saveOriginal();

	}

	public void loadLists() {

		for (ArrayList<? extends Object> list : this.lists)
			list.loadOriginal();

	}

	private void createLists() {

	}

	private void repleteLists() {

	}

}
