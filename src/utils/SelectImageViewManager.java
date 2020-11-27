package utils;

import controller.Credentials;
import utils.EventHandler.EventHandlerAble;

public enum SelectImageViewManager {

	INSTANCE;

	private HashMap<ImageViewAble, SelectImageView> hashMapImageViewAble = new HashMap<ImageViewAble, SelectImageView>();
	private HashMap<EventHandlerAble, SelectImageView> hashMapEventHandlerAble = new HashMap<EventHandlerAble, SelectImageView>();

	private SelectImageViewManager() {

	}

	public void reverseSelectImageViewAble(Object object) {

		if (!(object instanceof ImageViewAble))
			ShutDown.INSTANCE.execute();

		ImageViewAble imageViewAble = (ImageViewAble) object;

		if (!this.hashMapImageViewAble.containsKey(imageViewAble))
			addSelectImageViewAble(imageViewAble);
		else
			releaseSelectImageViewAble(imageViewAble);

	}

	public void addSelectImageViewAble(ImageViewAble imageViewAble) {

		if (this.hashMapImageViewAble.containsKey(imageViewAble))
			ShutDown.INSTANCE.execute();

		SelectImageView selectImageView = ObjectPool.INSTANCE.acquire(SelectImageView.class);
		this.hashMapImageViewAble.put(imageViewAble, selectImageView);

		selectImageView.getImageView().setVisible(true);

		ImageView imageView = imageViewAble.getImageView();

		// dimension

		double dimension = Math.min(imageView.getWidth(), imageView.getHeight());
		dimension *= Credentials.INSTANCE.selectImageViewAbleRatioDimensions;

		selectImageView.getImageView().setWidth(dimension);

		// coordinates

		double x = imageView.getLayoutX()
				+ Credentials.INSTANCE.selectImageViewAbleRatioCoordinateX * imageView.getWidth();
		double y = imageView.getLayoutY()
				+ Credentials.INSTANCE.selectImageViewAbleRatioCoordinateY * imageView.getHeight();

		selectImageView.getImageView().relocateCenter(x, y);

	}

	public void addSelectCoordinates(double x, double y, EventHandlerAble eventHandlerAble) {

		if (this.hashMapEventHandlerAble.containsKey(eventHandlerAble))
			ShutDown.INSTANCE.execute();

		SelectImageView selectImageView = ObjectPool.INSTANCE.acquire(SelectImageView.class);
		this.hashMapEventHandlerAble.put(eventHandlerAble, selectImageView);

		selectImageView.getImageView().setVisible(true);

		double width = Credentials.INSTANCE.selectEventHandlerAbleWidth;
		selectImageView.getImageView().setWidth(width);
		selectImageView.getImageView().relocateCenter(x, y);

	}

	public void addSelectCoordinates(NumbersPair numbersPair, EventHandlerAble eventHandlerAble) {
		addSelectCoordinates(numbersPair.x, numbersPair.y, eventHandlerAble);
	}

	public void releaseSelectImageViewAble(ImageViewAble imageViewAble) {

		if (!this.hashMapImageViewAble.containsKey(imageViewAble))
			ShutDown.INSTANCE.execute();

		SelectImageView selectImageView = this.hashMapImageViewAble.getValue(imageViewAble);
		selectImageView.getImageView().setVisible(false);
		ObjectPool.INSTANCE.release(selectImageView);

		this.hashMapImageViewAble.remove(imageViewAble);

	}

	public void releaseSelectCoordinates(EventHandlerAble eventHandlerAble) {

		if (!this.hashMapEventHandlerAble.containsKey(eventHandlerAble))
			ShutDown.INSTANCE.execute();

		SelectImageView selectImageView = this.hashMapEventHandlerAble.getValue(eventHandlerAble);
		selectImageView.getImageView().setVisible(false);
		ObjectPool.INSTANCE.release(selectImageView);

		this.hashMapEventHandlerAble.remove(eventHandlerAble);

	}

	public void releaseSelectImageViews() {

		for (ImageViewAble imageViewAble : this.hashMapImageViewAble.clone())
			releaseSelectImageViewAble(imageViewAble);

		for (EventHandlerAble eventHandlerAble : this.hashMapEventHandlerAble.clone())
			releaseSelectCoordinates(eventHandlerAble);

	}

	public boolean isSelectedImageViewAble(ImageViewAble imageViewAble) {
		return this.hashMapImageViewAble.containsKey(imageViewAble);
	}

	public boolean isSelectedCoordinates(EventHandlerAble eventHandlerAble) {
		return this.hashMapEventHandlerAble.containsKey(eventHandlerAble);
	}

	public void handleMouseButtonPressedPrimary(SelectImageView selectImageView) {
		getEventHandlerAble(selectImageView).handleMouseButtonPressedPrimary();
	}

	public void handleMouseButtonPressedSecondary(SelectImageView selectImageView) {
		getEventHandlerAble(selectImageView).handleMouseButtonPressedSecondary();
	}

	public void handleMouseEntered(SelectImageView selectImageView) {
		getEventHandlerAble(selectImageView).handleMouseEntered();
	}

	public void handleMouseExited(SelectImageView selectImageView) {

		EventHandlerAble eventHandlerAble = getEventHandlerAble(selectImageView);

		if (eventHandlerAble != null)
			eventHandlerAble.handleMouseExited();

	}

	private EventHandlerAble getEventHandlerAble(SelectImageView selectImageView) {

		EventHandlerAble eventHandlerAble = null;

		if (this.hashMapImageViewAble.containsValue(selectImageView)) {

			ImageViewAble imageViewAble = this.hashMapImageViewAble.getKey(selectImageView);
			ImageView imageView = imageViewAble.getImageView();
			eventHandlerAble = imageView.getEventHandlerAble();

		} else if (this.hashMapEventHandlerAble.containsValue(selectImageView))
			eventHandlerAble = this.hashMapEventHandlerAble.getKey(selectImageView);

		return eventHandlerAble;

	}

	public int sizeSelectImageViewAbles() {
		return this.hashMapImageViewAble.size() + this.hashMapEventHandlerAble.size();
	}

	public ArrayList<ImageViewAble> getSelectedImageViewAbles() {

		ArrayList<ImageViewAble> list = new ArrayList<ImageViewAble>();

		for (ImageViewAble imageViewAble : this.hashMapImageViewAble)
			list.addLast(imageViewAble);

		return list;

	}

}
