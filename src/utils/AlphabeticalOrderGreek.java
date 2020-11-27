package utils;

import java.util.ArrayList;

public enum AlphabeticalOrderGreek {

	INSTANCE;

	private ArrayList<String> alphabeticalOrder = new ArrayList<>();

	private AlphabeticalOrderGreek() {

		this.alphabeticalOrder.add(" ");
		this.alphabeticalOrder.add(".");
		this.alphabeticalOrder.add("&");
		this.alphabeticalOrder.add("�");
		this.alphabeticalOrder.add("�");
		this.alphabeticalOrder.add("�");
		this.alphabeticalOrder.add("�");
		this.alphabeticalOrder.add("�");
		this.alphabeticalOrder.add("�");
		this.alphabeticalOrder.add("�");
		this.alphabeticalOrder.add("�");
		this.alphabeticalOrder.add("�");
		this.alphabeticalOrder.add("�");
		this.alphabeticalOrder.add("�");
		this.alphabeticalOrder.add("�");
		this.alphabeticalOrder.add("�");
		this.alphabeticalOrder.add("�");
		this.alphabeticalOrder.add("�");
		this.alphabeticalOrder.add("�");
		this.alphabeticalOrder.add("�");
		this.alphabeticalOrder.add("�");
		this.alphabeticalOrder.add("�");
		this.alphabeticalOrder.add("�");
		this.alphabeticalOrder.add("�");
		this.alphabeticalOrder.add("�");
		this.alphabeticalOrder.add("�");
		this.alphabeticalOrder.add("�");

	}

	public String firstInAlphabeticalOrder(String first, String second) {

		String firstString = first.toLowerCase();
		String secondString = second.toLowerCase();

		firstString = replaceTones(firstString);
		secondString = replaceTones(secondString);

		return getFirstInAlphabeticalOrder(first, second);

	}

	private String replaceTones(String string) {

		string = string.replaceAll("�", "�");
		string = string.replaceAll("�", "�");
		string = string.replaceAll("�", "�");
		string = string.replaceAll("�", "�");
		string = string.replaceAll("�", "�");
		string = string.replaceAll("�", "�");
		string = string.replaceAll("�", "�");

		return string;
	}

	private String getFirstInAlphabeticalOrder(String first, String second) {

		String stringToReturn = null;

		for (int counter = 0; counter < Math.min(first.length(), second.length()); counter++) {

			if (this.alphabeticalOrder.indexOf(getStringAtIndex(first, counter)) < this.alphabeticalOrder
					.indexOf(getStringAtIndex(second, counter))) {
				stringToReturn = first;
				break;

			} else if (this.alphabeticalOrder.indexOf(getStringAtIndex(second, counter)) < this.alphabeticalOrder
					.indexOf(getStringAtIndex(first, counter))) {
				stringToReturn = second;
				break;
			}

		}

		if (stringToReturn != null)
			return stringToReturn;

		if (first.length() < second.length())
			return first;

		return second;

	}

	private static String getStringAtIndex(String string, int index) {
		return string.substring(index, index + 1);
	}

}
