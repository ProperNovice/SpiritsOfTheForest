package utils;

import java.util.Iterator;

import controller.Lists;
import utils.Enums.AnimationSynchEnum;
import utils.Enums.ImageViewActionEnum;
import utils.Enums.LayerZListEnum;

public class ListImageViewAbles<T> implements Iterable<T> {

	private ArrayList<T> arrayList = null;
	private CoordinatesList coordinatesList = null;
	private LayerZListEnum layerZListEnum = null;

	public ListImageViewAbles(CoordinatesList coordinatesList) {
		this(coordinatesList, null, -1);
	}

	public ListImageViewAbles(CoordinatesList coordinatesList, int capacity) {
		this(coordinatesList, null, capacity);
	}

	public ListImageViewAbles(CoordinatesList coordinatesList, LayerZListEnum layerZListEnum) {
		this(coordinatesList, layerZListEnum, -1);
	}

	public ListImageViewAbles(CoordinatesList coordinatesList, LayerZListEnum layerZListEnum, int capacity) {

		this.arrayList = new ArrayList<T>(capacity);

		this.coordinatesList = coordinatesList;
		this.coordinatesList.setList(this.arrayList);

		this.layerZListEnum = layerZListEnum;

		Lists.INSTANCE.lists.addLast(this.arrayList);
		RealTimeDuplicateProtection.INSTANCE.addList(this.arrayList);

	}

	public void layerZSort() {

		if (this.layerZListEnum == null)
			return;

		switch (this.layerZListEnum) {

		case TO_BACK_FIRST_IMAGEVIEW:
			toBackFirstImageView();
			break;

		case TO_FRONT_FIRST_IMAGEVIEW:
			toFrontFirstImageView();
			break;

		}

	}

	private void toFrontFirstImageView() {

		ImageViewAble imageViewAble = null;

		for (int counter = this.arrayList.size() - 1; counter >= 0; counter--) {

			imageViewAble = (ImageViewAble) this.arrayList.get(counter);
			imageViewAble.getImageView().toFront();

		}

	}

	private void toBackFirstImageView() {

		ImageViewAble imageViewAble = null;

		for (T t : this.arrayList) {

			imageViewAble = (ImageViewAble) t;
			imageViewAble.getImageView().toFront();

		}

	}

	public void animateAsynchronous() {
		executeAction(ImageViewActionEnum.ANIMATE, AnimationSynchEnum.ASYNCHRONOUS);
	}

	public void animateSynchronous() {
		executeAction(ImageViewActionEnum.ANIMATE, AnimationSynchEnum.SYNCHRONOUS);
	}

	public void animateSynchronousLock() {

		animateSynchronous();
		Lock.INSTANCE.lock();

	}

	public void relocateImageViews() {
		executeAction(ImageViewActionEnum.RELOCATE, null);
	}

	public void relocateList(double x, double y) {
		this.coordinatesList.relocateList(x, y);
	}

	public void relocateList(NumbersPair numbersPair) {
		this.coordinatesList.relocateList(numbersPair);
	}

	private void executeAction(ImageViewActionEnum imageViewAction, AnimationSynchEnum animationSynch) {

		ImageView imageView = null;

		ArrayList<T> list = this.arrayList.clone();
		list.reverse();

		for (T t : list) {

			int index = this.arrayList.indexOf(t);
			NumbersPair numbersPair = this.coordinatesList.getCoordinate(index);

			imageView = ((ImageViewAble) t).getImageView();

			switch (imageViewAction) {

			case ANIMATE:

				imageView.getAnimationExecutionObject().setAnimationCredentials(numbersPair);

				if (imageView.getAnimationExecutionObject().animationIsFinished())
					continue;
				else
					Animation.INSTANCE.animateTopLeft((ImageViewAble) t, numbersPair, animationSynch);
				break;

			case RELOCATE:
				imageView.relocateTopLeft(numbersPair);
				break;

			}

		}

		layerZSort();

	}

	public ArrayList<T> getArrayList() {
		return this.arrayList;
	}

	@Override
	public Iterator<T> iterator() {
		return this.arrayList.iterator();
	}

}
