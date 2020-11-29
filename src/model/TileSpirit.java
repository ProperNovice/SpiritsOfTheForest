package model;

import controller.Credentials;
import enums.ESpirit;
import utils.CoordinatesListBuilder;
import utils.Enums.RearrangeTypeEnum;
import utils.EventHandler.EventHandlerAble;
import utils.ListImageViewAbles;
import utils.NumbersPair;

public class TileSpirit implements EventHandlerAble {

	private ListImageViewAbles<Spirit> listSpirit = null;
	private ListImageViewAbles<SpiritBack> listBack = null;

	public TileSpirit(ESpirit eSpirit, int count) {

		this.listSpirit = new ListImageViewAbles<Spirit>(new CoordinatesListBuilder()
				.rearrangeTypeEnum(RearrangeTypeEnum.PIVOT).objectsPerRow(1).gapY(Credentials.INSTANCE.dTile.y).build(),
				count);

		this.listBack = new ListImageViewAbles<SpiritBack>(new CoordinatesListBuilder()
				.rearrangeTypeEnum(RearrangeTypeEnum.PIVOT).objectsPerRow(1).gapY(Credentials.INSTANCE.dTile.y).build(),
				2);

		while (!this.listSpirit.getArrayList().isMaxedCapacity())
			this.listSpirit.getArrayList().addLast(new Spirit(eSpirit));

		while (!this.listBack.getArrayList().isMaxedCapacity())
			this.listBack.getArrayList().addLast(new SpiritBack());

	}

	public void setPivotRelocate(NumbersPair pivot) {

		this.listSpirit.relocateList(pivot);
		this.listBack.relocateList(pivot);

		this.listSpirit.relocateImageViews();
		this.listBack.relocateImageViews();

	}

	public void revealTile() {

		for (SpiritBack spiritBack : this.listBack)
			spiritBack.getImageView().setVisible(false);

		for (Spirit spirit : this.listSpirit)
			spirit.getImageView().setVisible(true);

	}

}
