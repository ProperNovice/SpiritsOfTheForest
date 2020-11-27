package utils;

import controller.Credentials;
import utils.Enums.RelocateTypeEnum;
import utils.Enums.DirectionEnum;
import utils.Enums.RearrangeTypeEnum;

public class CoordinatesListBuilder {

	private double x = 0, y = 0, width = 0, height = 0, gapX = Credentials.INSTANCE.dGapBetweenComponents.x,
			gapY = Credentials.INSTANCE.dGapBetweenComponents.y;
	private int objectsPerRow = -1;
	private RearrangeTypeEnum rearrangeTypeEnum = RearrangeTypeEnum.LINEAR;
	private DirectionEnum directionEnumHorizontal = DirectionEnum.RIGHT, directionEnumVertical = DirectionEnum.DOWN;
	private RelocateTypeEnum relocateTypeEnum = RelocateTypeEnum.TOP_LEFT;

	public CoordinatesListBuilder() {

	}

	public CoordinatesListBuilder coordinateX(double x) {
		this.x = x;
		return this;
	}

	public CoordinatesListBuilder coordinateY(double y) {
		this.y = y;
		return this;
	}

	public CoordinatesListBuilder coordinatesNumbersPair(NumbersPair numbersPair) {

		this.x = numbersPair.x;
		this.y = numbersPair.y;
		return this;

	}

	public CoordinatesListBuilder width(double width) {
		this.width = width;
		return this;
	}

	public CoordinatesListBuilder height(double height) {
		this.height = height;
		return this;
	}

	public CoordinatesListBuilder dimensionsNumbersPair(NumbersPair numbersPair) {

		this.width = numbersPair.x;
		this.height = numbersPair.y;
		return this;

	}

	public CoordinatesListBuilder gapX(double gapX) {
		this.gapX = gapX;
		return this;
	}

	public CoordinatesListBuilder gapY(double gapY) {
		this.gapY = gapY;
		return this;
	}

	public CoordinatesListBuilder gapNumbersPair(NumbersPair numbersPair) {
		this.gapX = numbersPair.x;
		this.gapY = numbersPair.y;
		return this;
	}

	public CoordinatesListBuilder objectsPerRow(int objectsPerRow) {
		this.objectsPerRow = objectsPerRow;
		return this;
	}

	public CoordinatesListBuilder rearrangeTypeEnum(RearrangeTypeEnum rearrangeTypeEnum) {
		this.rearrangeTypeEnum = rearrangeTypeEnum;
		return this;
	}

	public CoordinatesListBuilder directionEnumHorizontal(DirectionEnum directionEnum) {
		this.directionEnumHorizontal = directionEnum;
		return this;
	}

	public CoordinatesListBuilder directionEnumVertical(DirectionEnum directionEnum) {
		this.directionEnumVertical = directionEnum;
		return this;
	}

	public CoordinatesListBuilder relocateTypeEnum(RelocateTypeEnum relocateTypeEnum) {
		this.relocateTypeEnum = relocateTypeEnum;
		return this;
	}

	public CoordinatesList build() {
		return new CoordinatesList(new NumbersPair(x, y), new NumbersPair(this.width, this.height),
				new NumbersPair(this.gapX, this.gapY), this.objectsPerRow, this.rearrangeTypeEnum,
				this.directionEnumHorizontal, this.directionEnumVertical, this.relocateTypeEnum);
	}

}
