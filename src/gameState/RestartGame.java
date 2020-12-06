package gameState;

import controller.Statistics;
import enums.ESpirit;
import utils.Flow;

public class RestartGame extends AGameState {

	public RestartGame() {
		
		Flow.INSTANCE.getFlow().clear();

		for (ESpirit eSpirit : ESpirit.values())
			Statistics.INSTANCE.statistics.getValue(eSpirit).reset();

		Flow.INSTANCE.print();
		Flow.INSTANCE.getFlow().addLast(StartGame.class);
		
		Flow.INSTANCE.proceed();

	}

}
