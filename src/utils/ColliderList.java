package utils;

public enum ColliderList {

	INSTANCE;

	private ArrayList<Collider> list = new ArrayList<Collider>();

	public void addCollider(double topLeftX, double topY, double width, double height, boolean visibility) {
		this.list.addLast(new Collider(topLeftX, topY, width, height, visibility));
	}

	public boolean contains(double x, double y) {

		for (Collider collider : this.list)
			if (collider.contains(x, y))
				return true;

		return false;

	}

	public class Collider {

		private double topLeftX, topY, topRightX, bottomY;

		public Collider(double topLeftX, double topY, double width, double height, boolean visibility) {

			this.topLeftX = topLeftX;
			this.topRightX = this.topLeftX + width;
			this.topY = topY;
			this.bottomY = this.topY + height;

			if (!visibility)
				return;

			new Rectangle(topLeftX, topY, width, height);

		}

		public boolean contains(double x, double y) {

			if (x < this.topLeftX)
				return false;

			if (x > this.topRightX)
				return false;

			if (y < this.topY)
				return false;

			if (y > this.bottomY)
				return false;

			return true;

		}

	}

}
