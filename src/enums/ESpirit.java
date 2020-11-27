package enums;

public enum ESpirit {

	BRANCHES(8), DEW_DROPS(7), FLOWESS(6), FRUITS(6), LEAVES(8), MOSS(5), MUSHROOMS(7), VINES(8), WEB_SPIDESS(10);

	private int count = -1;

	private ESpirit(int count) {
		this.count = count;
	}

	public Integer getCount() {
		return this.count;
	}

}
