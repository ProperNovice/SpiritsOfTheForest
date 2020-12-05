package model;

import controller.Credentials;
import enums.ESpirit;
import utils.CoordinatesListBuilder;
import utils.Enums.RearrangeTypeEnum;
import utils.EventHandler.EventHandlerAble;
import utils.Flow;
import utils.ListImageViewAbles;
import utils.NumbersPair;

public class TileSpirit implements EventHandlerAble {

	private ListImageViewAbles<Spirit> listSpirit = null;
	private ListImageViewAbles<SpiritBack> listBack = null;
	private ESpirit eSpirit = null;
	private NumbersPair pivot = null;

	public TileSpirit(ESpirit eSpirit, int count) {

		this.eSpirit = eSpirit;

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

		this.pivot = pivot;

		this.listSpirit.relocateList(this.pivot);
		this.listBack.relocateList(this.pivot);

		this.listSpirit.relocateImageViews();
		this.listBack.relocateImageViews();

	}

	public void setVisible(boolean value) {

		for (SpiritBack spiritBack : this.listBack)
			spiritBack.getImageView().setVisible(value);

		for (Spirit spirit : this.listSpirit)
			spirit.getImageView().setVisible(value);

	}

	public void revealTile() {

		for (SpiritBack spiritBack : this.listBack)
			spiritBack.getImageView().setVisible(false);

	}

	public ESpirit getESpirit() {
		return this.eSpirit;
	}

	public NumbersPair getPivot() {
		return this.pivot;
	}

	public ListImageViewAbles<Spirit> getListSpirit() {
		return this.listSpirit;
	}

	@Override
	public void handleMouseButtonPressedPrimary() {
		Flow.INSTANCE.getCurrentGameState().handleTilePressedBoard(this);
	}

	public void print() {

		System.out.println(this.eSpirit + " -> " + this.listSpirit.getArrayList().size());
		System.out.println();

	}

}
