package gameState;

import controller.Board;
import controller.Statistics;
import enums.ESpirit;
import model.TileSpirit;
import utils.ArrayList;
import utils.Flow;
import utils.HashMap;
import utils.Number;

public class StatisticsUpdateQuantity extends AGameState {

	private HashMap<ESpirit, Number> quantity = new HashMap<ESpirit, Number>();

	public StatisticsUpdateQuantity() {

		createQuantities();
		updateStatistics();

		Flow.INSTANCE.proceed();

	}

	private void createQuantities() {

		for (ArrayList<TileSpirit> tileSpiritList : Board.INSTANCE.board) {

			for (TileSpirit tileSpirit : tileSpiritList) {

				ESpirit eSpirit = tileSpirit.getESpirit();

				if (!this.quantity.containsKey(eSpirit))
					this.quantity.put(eSpirit, new Number(0));

				this.quantity.getValue(eSpirit).add(tileSpirit.getSpiritSize());

			}

		}

	}

	private void updateStatistics() {

		for (ESpirit eSpirit : this.quantity)
			Statistics.INSTANCE.statistics.getValue(eSpirit).setQuantity(this.quantity.getValue(eSpirit).get());

	}

}