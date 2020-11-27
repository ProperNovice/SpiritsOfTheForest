package gui;

import utils.Background;
import utils.Parent;
import utils.ParentInstance;

public class Panel extends Parent {

	public Panel() {

		ParentInstance.INSTANCE.setPanelGameInstance(this);
		new Background();

	}

}
