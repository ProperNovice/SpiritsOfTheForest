package utils;

public class Number implements ISaveLoadStateAble {

	private int numberCurrent, numberOriginal, numberState;

	public Number(int number) {
		this.numberCurrent = number;
		saveOriginal();
	}

	public void set(int number) {
		this.numberCurrent = number;
	}

	public void add(int number) {
		this.numberCurrent += number;
	}

	public void substract(int number) {
		this.numberCurrent -= number;
	}

	public int get() {
		return this.numberCurrent;
	}

	public void print() {
		Logger.INSTANCE.logNewLine("number -> " + this.numberCurrent);
	}

	@Override
	public String toString() {
		return Integer.toString(this.numberCurrent);
	}

	@Override
	public void saveOriginal() {
		this.numberOriginal = this.numberCurrent;
	}

	@Override
	public void loadOriginal() {
		this.numberCurrent = this.numberOriginal;
	}

	@Override
	public void saveState() {
		this.numberState = this.numberCurrent;
	}

	@Override
	public void loadState() {
		this.numberCurrent = this.numberState;
	}

}
