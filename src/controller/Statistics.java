package controller;

import enums.ESpirit;
import model.SpiritTag;
import utils.ArrayList;
import utils.HashMap;

public enum Statistics {

	INSTANCE;

	public HashMap<ESpirit, SpiritTag> statistics = new HashMap<ESpirit, SpiritTag>();

	public void instantiate() {

		ArrayList<ESpirit> list = new ArrayList<ESpirit>(ESpirit.values());
		list.shuffle();

		double x = Credentials.INSTANCE.cStatistics.x;
		double y = Credentials.INSTANCE.cStatistics.y;

		for (ESpirit eSpirit : list) {

			SpiritTag spiritTag = new SpiritTag(eSpirit, x, y);
			this.statistics.put(eSpirit, spiritTag);

			y += Credentials.INSTANCE.dTile.y;
			y += Credentials.INSTANCE.dGapBetweenComponents.y;

		}

	}

}
