package validsentence;

public class SentenceCheck {

	/**
	 * Checks a sentence is valid based on the following constraints: 
	 * String starts with a capital letter.
	 * String has an even number of quotation marks. 
	 * String ends with one of the following sentence termination characters: ".", "?", "!"
	 * String has no period characters other than the last character. 
	 * Numbers below 13 are spelled out (”one”, “two”, "three”, etc…)
	 * 
	 * @param sentence
	 * @return
	 */
	private static boolean isSentenceValid(String sentence) {
		
		// check if the sentence begins with quotation mark
		if (sentence.charAt(0) == '"') { // then check if the second letter is a capital
			if (sentence.charAt(1) < 65 || sentence.charAt(1) > 90) 
				return false;
		} else { // check if the first letter is a capital letter
			if (sentence.charAt(0) < 65 || sentence.charAt(0) > 90)
				return false;
		}

		// check sentence has an even number of quotation marks
		if (countQuotes(sentence) % 2 != 0)
			return false;

		// check sentence ends in . ! or ?
		if (sentence.charAt(sentence.length() - 1) != '.' && sentence.charAt(sentence.length() - 1) != '!'
				&& sentence.charAt(sentence.length() - 1) != '?')
			return false;

		// check sentence contains no full stops other than the end char
		for (int i = 0; i < sentence.length() - 1; i++) {
			if (sentence.charAt(i) == '.')
				return false;
		}

		// check for digits in sentence less than 13
		if (!checkDigitsInSentence(sentence))
			return false;

		// if all checks pass sentence is valid
		return true;
	}

	/**
	 * Counts every instance of a quotation mark in a provided string 
	 * Returns the total count
	 * 
	 * @param sentence
	 * @return
	 */
	private static int countQuotes(String sentence) {
		int count = 0;
		for (int i = 0; i < sentence.length(); i++) {
			if (sentence.charAt(i) == '"')
				count++;
		}
		return count;
	}

	/**
	 * Checks for any digits in a sentence
	 * If the number is less than 13 return false
	 * 
	 * @param sentence
	 * @return
	 */
	private static boolean checkDigitsInSentence(String sentence) {
		// check numbers below 13 are spelled out
		int num;
		String temp = "";
		for (int i = 0; i < sentence.length() - 1; i++) {
			if (Character.isDigit(sentence.charAt(i))) { // checks if the current char is a digit
				if (Character.isDigit(sentence.charAt(i + 1))) { // checks if next char is also a digit
					temp += sentence.charAt(i); // add both chars to string
					temp += sentence.charAt(i + 1);
					i++; // increment i so next char is skipped in next loop iteration
				} else {
					// return false as single digit numbers should be spelled out
					return false;
				}
			}
			if (temp != "") {
				num = Integer.parseInt(temp); // parse string to integer and check if less than 13
				if (num < 13)
					return false;
				temp = "";
			}

		}
		return true;
	}

	public static void main(String[] args) {
		/*
		 * Tests during program creation // test sentence starting with lower case
		 * letter String sentence1 = "hello.";
		 * System.out.println("Expected result of test 1: false");
		 * System.out.println("Result of test 1: " + isSentenceValid(sentence1));
		 * 
		 * // test sentence starting with upper case letter String sentence2 = "Hello.";
		 * System.out.println("Expected result of test 2: true");
		 * System.out.println("Result of test 2: " + isSentenceValid(sentence2));
		 * 
		 * // test sentence with even amount of quotation marks String sentence3 =
		 * "\"Hello\" said the man.";
		 * System.out.println("Expected result of test 3: true");
		 * System.out.println("Result of test 3: " + isSentenceValid(sentence3));
		 * 
		 * // test sentence with odd amount of quotation marks String sentence4 =
		 * "\"Hello\" said the\" man.";
		 * System.out.println("Expected result of test 4: false");
		 * System.out.println("Result of test 4: " + isSentenceValid(sentence4));
		 * 
		 * // test sentence with full stop String sentence5 =
		 * "\"Hello\" said the man?!.";
		 * System.out.println("Expected result of test 5: true");
		 * System.out.println("Result of test 5: " + isSentenceValid(sentence5));
		 * 
		 * // test sentence with no full stop String sentence6 =
		 * "\"Hello\" said the man";
		 * System.out.println("Expected result of test 6: false");
		 * System.out.println("Result of test 6: " + isSentenceValid(sentence6));
		 * 
		 * // test full stop in middle of a sentence String sentence7 =
		 * "\"Hello.\" said the man.";
		 * System.out.println("Expected result of test 7: false");
		 * System.out.println("Result of test 7: " + isSentenceValid(sentence7));
		 * 
		 * // test number in sentence String sentence8 = "\"Hello\" said the man 12.";
		 * System.out.println("Expected result of test 8: false");
		 * System.out.println("Result of test 8: " + isSentenceValid(sentence8));
		 */
		
		// Test cases to be removed from main after use
		/*
		 * Valid Sentences Tests 
		 * The quick brown fox said “hello Mr lazy dog”. 
		 * The quick brown fox said hello Mr lazy dog. 
		 * One lazy dog is too few, 13 is too many.
		 * One lazy dog is too few, thirteen is too many. 
		 * How many "lazy dogs" are there?
		 */
		System.out.println("Valid Test Cases:");
		String s1 = "The quick brown fox said \"hello Mr lazy dog\".";
		System.out.println("Test sentence: " + s1);
		System.out.println("Expected result of test 1: true");
		System.out.println("Result of test 1: " + isSentenceValid(s1) + "\n");

		s1 = "The quick brown fox said hello Mr lazy dog.";
		System.out.println("Test sentence: " + s1);
		System.out.println("Expected result of test 2: true");
		System.out.println("Result of test 2: " + isSentenceValid(s1) + "\n");

		s1 = "One lazy dog is too few, 13 is too many.";
		System.out.println("Test sentence: " + s1);
		System.out.println("Expected result of test 3: true");
		System.out.println("Result of test 3: " + isSentenceValid(s1) + "\n");

		s1 = "One lazy dog is too few, thirteen is too many.";
		System.out.println("Test sentence: " + s1);
		System.out.println("Expected result of test 4: true");
		System.out.println("Result of test 4: " + isSentenceValid(s1) + "\n");

		s1 = "How many \"lazy dogs\" are there?";
		System.out.println("Test sentence: " + s1);
		System.out.println("Expected result of test 5: true");
		System.out.println("Result of test 5: " + isSentenceValid(s1) + "\n");

		/*
		 * Invalid Sentence Tests 
		 * The quick brown fox said "hello Mr. lazy dog". 
		 * the quick brown fox said “hello Mr lazy dog".
		 * "The quick brown fox said “hello Mr lazy dog." 
		 * One lazy dog is too few, 12 is too many. 
		 * Are there 11, 12, or 13 lazy dogs? 
		 * There is no punctuation in this sentence
		 */
		System.out.println("\nInvalid Test Cases:");
		String s2 = "The quick brown fox said \"hello Mr. lazy dog\".";
		System.out.println("Test sentence: " + s2);
		System.out.println("Expected result of test 6: false");
		System.out.println("Result of test 6: " + isSentenceValid(s2) + "\n");

		s2 = "the quick brown fox said “hello Mr lazy dog\".";
		System.out.println("Test sentence: " + s2);
		System.out.println("Expected result of test 7: false");
		System.out.println("Result of test 7: " + isSentenceValid(s2) + "\n");

		s2 = "\"The quick brown fox said “hello Mr lazy dog.\"";
		System.out.println("Test sentence: " + s2);
		System.out.println("Expected result of test 8: false");
		System.out.println("Result of test 8: " + isSentenceValid(s2) + "\n");

		s2 = "One lazy dog is too few, 12 is too many.";
		System.out.println("Test sentence: " + s2);
		System.out.println("Expected result of test 9: false");
		System.out.println("Result of test 9: " + isSentenceValid(s2) + "\n");

		s2 = "Are there 11, 12, or 13 lazy dogs?";
		System.out.println("Test sentence: " + s2);
		System.out.println("Expected result of test 10: false");
		System.out.println("Result of test 10: " + isSentenceValid(s2) + "\n");

		s2 = "There is no punctuation in this sentence";
		System.out.println("Test sentence: " + s2);
		System.out.println("Expected result of test 11: false");
		System.out.println("Result of test 11: " + isSentenceValid(s2) + "\n");

	}

}
