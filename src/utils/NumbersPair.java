package utils;

public class NumbersPair {

	public double x;
	public double y;

	public NumbersPair(double x, double y) {

		this.x = x;
		this.y = y;

	}

	public void print() {

		Logger.INSTANCE.log("x -> " + this.x);
		Logger.INSTANCE.log("y -> " + this.y);
		Logger.INSTANCE.newLine();

	}

	@Override
	public boolean equals(Object obj) {

		if (!(obj instanceof NumbersPair))
			ShutDown.INSTANCE.execute();

		NumbersPair numbersPair = (NumbersPair) obj;

		if (this.x != numbersPair.x)
			return false;

		else if (this.y != numbersPair.y)
			return false;

		else
			return true;

	}

}
