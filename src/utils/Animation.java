package utils;

import javafx.animation.AnimationTimer;
import utils.Enums.AnimationSynchEnum;

public enum Animation {

	INSTANCE;

	private ArrayList<ImageViewAble> animationsSynchronous = new ArrayList<ImageViewAble>();
	private ArrayList<ImageViewAble> animationsAsynchronous = new ArrayList<ImageViewAble>();

	private Animation() {
		new AnimationTimerFX().start();
	}

	private class AnimationTimerFX extends AnimationTimer {

		@Override
		public void handle(long time) {

			if (!animationsSynchronous.isEmpty())
				executeAnimationSynchronous();
			if (!animationsAsynchronous.isEmpty())
				executeAnimationAsynchronous();

		}

	}

	private void executeAnimationSynchronous() {

		executeAnimationList(this.animationsSynchronous);

		if (!this.animationsSynchronous.isEmpty())
			return;

		Lock.INSTANCE.unlock();

	}

	private void executeAnimationAsynchronous() {
		executeAnimationList(this.animationsAsynchronous);
	}

	private void executeAnimationList(ArrayList<ImageViewAble> animationsList) {

		ArrayList<ImageViewAble> animationsListTemp = animationsList.clone();

		for (ImageViewAble imageView : animationsListTemp) {

			AnimationExecutionObject animationExecutionObject = imageView.getImageView().getAnimationExecutionObject();

			animationExecutionObject.moveTowardsAnimationCoordinates();

			if (!animationExecutionObject.animationIsFinished())
				continue;

			animationsList.remove(imageView);

		}

	}

	public void animateTopLeft(ImageViewAble imageViewAble, NumbersPair numbersPair,
			AnimationSynchEnum animationSynchEnum) {

		if (this.animationsSynchronous.contains(imageViewAble))
			this.animationsSynchronous.remove(imageViewAble);
		else if (this.animationsAsynchronous.contains(imageViewAble))
			this.animationsAsynchronous.remove(imageViewAble);

		imageViewAble.getImageView().toFront();
		imageViewAble.getImageView().getAnimationExecutionObject().setAnimationCredentials(numbersPair);

		PlatformFX.runLater(() -> {

			ArrayList<ImageViewAble> listToAdd = null;

			switch (animationSynchEnum) {

			case SYNCHRONOUS:
				listToAdd = this.animationsSynchronous;
				break;

			case ASYNCHRONOUS:
				listToAdd = this.animationsAsynchronous;
				break;

			}

			listToAdd.addLast(imageViewAble);

		});

	}

	public void animateCenter(ImageViewAble imageViewAble, NumbersPair numbersPair,
			AnimationSynchEnum animationSynchEnum) {

		double x = numbersPair.x - imageViewAble.getImageView().getWidth() / 2;
		double y = numbersPair.y - imageViewAble.getImageView().getHeight() / 2;

		animateTopLeft(imageViewAble, new NumbersPair(x, y), animationSynchEnum);

	}

	public boolean isAnimatingSynchronous() {
		return !this.animationsSynchronous.isEmpty();
	}

	public boolean isAnimatingAsynchronous() {
		return !this.animationsAsynchronous.isEmpty();
	}

	public boolean isAnimating() {

		if (!this.animationsSynchronous.isEmpty())
			return true;

		if (!this.animationsAsynchronous.isEmpty())
			return true;

		return false;

	}

	public void moveAsynchronousToSynchronous() {

		PlatformFX.runLater(new Runnable() {

			@Override
			public void run() {

				animationsSynchronous.addAll(animationsAsynchronous);
				animationsAsynchronous.clear();

			}
		});

	}

	public void moveAsynchronousToSynchronousLock() {

		moveAsynchronousToSynchronous();
		Lock.INSTANCE.lock();

	}

}
