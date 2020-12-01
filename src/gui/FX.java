package gui;

import controller.Credentials;
import controller.Lists;
import gameState.RestartGame;
import gameState.StartGame;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import utils.Animation;
import utils.Executor;
import utils.Flow;
import utils.Logger;
import utils.NumbersPair;
import utils.ObjectPool;
import utils.ShutDown;

public class FX extends Application {

	private NumbersPair dimensionsInsets = new NumbersPair(16, 39);
	private double pixesOnTheLeft = 180;

	@Override
	public void start(Stage primaryStage) throws Exception {

		Panel panel = new Panel();

		double width = Credentials.INSTANCE.dFrame.x + this.dimensionsInsets.x;
		double height = Credentials.INSTANCE.dFrame.y + this.dimensionsInsets.y;

		Scene scene = new Scene(panel);
		setKeyPressed(scene);

		primaryStage.setScene(scene);
		primaryStage.setWidth(width);
		primaryStage.setHeight(height);
		primaryStage.setResizable(false);

		primaryStage.setTitle(Credentials.INSTANCE.primaryStageTitle);

		primaryStage.setX((Screen.getPrimary().getBounds().getWidth() - width) / 2 - this.pixesOnTheLeft);
		primaryStage.setY((Screen.getPrimary().getBounds().getHeight() - height) / 2);

		primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {

			@Override
			public void handle(WindowEvent event) {
				ShutDown.INSTANCE.execute();
			}

		});

		primaryStage.show();

		Lists.INSTANCE.instantiate();
		Executor.INSTANCE.runLater(() -> Flow.INSTANCE.executeGameState(StartGame.class));

	}

	private void setKeyPressed(Scene scene) {

		scene.setOnKeyPressed(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent event) {

				KeyCode keyCode = event.getCode();

				Logger.INSTANCE.logNewLine(keyCode + " key code pressed");

				Executor.INSTANCE.runLater(() -> {

					if (keyCode.equals(KeyCode.ESCAPE))
						ShutDown.INSTANCE.execute();

					else if (Animation.INSTANCE.isAnimatingSynchronous())
						return;

					else if (keyCode.equals(KeyCode.BACK_QUOTE))
						Flow.INSTANCE.executeGameState(RestartGame.class);

					else if (keyCode.equals(KeyCode.O))
						ObjectPool.INSTANCE.print();

					else
						Flow.INSTANCE.getCurrentGameState().getFirst().executeKeyPressed(keyCode);

				});

			}

		});

	}

	public static void main(String[] args) {
		launch(args);
	}

}
