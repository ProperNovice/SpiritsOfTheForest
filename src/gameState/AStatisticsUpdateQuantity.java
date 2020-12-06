package gameState;

import controller.Board;
import controller.Statistics;
import enums.ESpirit;
import model.TileSpirit;
import utils.ArrayList;
import utils.Flow;
import utils.HashMap;
import utils.Number;

public abstract class AStatisticsUpdateQuantity extends AGameState {

	private HashMap<ESpirit, Number> quantity = new HashMap<ESpirit, Number>();

	public AStatisticsUpdateQuantity() {

		createQuantities();
		updateStatistics();

		if (proceed())
			Flow.INSTANCE.proceed();

	}

	private void createQuantities() {

		for (ESpirit eSpirit : ESpirit.values())
			this.quantity.put(eSpirit, new Number(0));

		for (ArrayList<TileSpirit> tileSpiritList : Board.INSTANCE.board) {

			for (TileSpirit tileSpirit : tileSpiritList) {

				ESpirit eSpirit = tileSpirit.getESpirit();
				this.quantity.getValue(eSpirit).add(tileSpirit.getListSpirit().getArrayList().size());

			}

		}

	}

	private void updateStatistics() {

		for (ESpirit eSpirit : this.quantity)
			Statistics.INSTANCE.statistics.getValue(eSpirit).setQuantity(this.quantity.getValue(eSpirit).get());

	}

	protected abstract boolean proceed();

}
