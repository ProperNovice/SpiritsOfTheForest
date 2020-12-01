package enums;

import redOrbAlphabet.RedOrbAlphabet;
import redOrbAlphabet.RedOrbAlphabetEight;
import redOrbAlphabet.RedOrbAlphabetFive;
import redOrbAlphabet.RedOrbAlphabetFour;
import redOrbAlphabet.RedOrbAlphabetNine;
import redOrbAlphabet.RedOrbAlphabetOne;
import redOrbAlphabet.RedOrbAlphabetSeven;
import redOrbAlphabet.RedOrbAlphabetSix;
import redOrbAlphabet.RedOrbAlphabetTen;
import redOrbAlphabet.RedOrbAlphabetThree;
import redOrbAlphabet.RedOrbAlphabetTwo;
import redOrbAlphabet.RedOrbAlphabetZero;
import utils.HashMap;

public enum ERedOrbClass {

	INSTANCE;

	public HashMap<Integer, Class<? extends RedOrbAlphabet>> numbers = new HashMap<Integer, Class<? extends RedOrbAlphabet>>();

	private ERedOrbClass() {

		this.numbers.put(this.numbers.size(), RedOrbAlphabetZero.class);
		this.numbers.put(this.numbers.size(), RedOrbAlphabetOne.class);
		this.numbers.put(this.numbers.size(), RedOrbAlphabetTwo.class);
		this.numbers.put(this.numbers.size(), RedOrbAlphabetThree.class);
		this.numbers.put(this.numbers.size(), RedOrbAlphabetFour.class);
		this.numbers.put(this.numbers.size(), RedOrbAlphabetFive.class);
		this.numbers.put(this.numbers.size(), RedOrbAlphabetSix.class);
		this.numbers.put(this.numbers.size(), RedOrbAlphabetSeven.class);
		this.numbers.put(this.numbers.size(), RedOrbAlphabetEight.class);
		this.numbers.put(this.numbers.size(), RedOrbAlphabetNine.class);
		this.numbers.put(this.numbers.size(), RedOrbAlphabetTen.class);

	}

}
