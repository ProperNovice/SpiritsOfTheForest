package redOrbAlphabet;

import controller.Credentials;

public class RedOrbAlphabetMinus extends RedOrbAlphabet {

	protected double getWidth() {
		return Credentials.INSTANCE.redOrbAplhabetSmall;
	}

	@Override
	protected String getFileName() {
		return "-";
	}

}
