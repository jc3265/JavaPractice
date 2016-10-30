package jc3265;

public class ExtendToPalindromes {
	public static void main(String[] args) throws InterruptedException {
		ExtendToPalindromes driver = new ExtendToPalindromes();
		System.out.println(driver.palindromes("amanaplanacanal"));
		System.out.println(driver.palindromes("tacoca"));
		System.out.println(driver.palindromes("xyz"));
		System.out.println(driver.palindromes("aaaa"));
		System.out.println(driver.palindromes("abcdefghijklmnopqcba"));
		System.out.println(driver.palindromes("aaaabbaccaaaa"));
		System.out.println(driver.palindromes("aabcaa"));
		System.out.println("aabcaa");
	}

	public String palindromes(String palindrome) throws InterruptedException {
		int first = 0;
		String toAdd = "";
		if (isPalindrome(palindrome))
			return palindrome;
		int last = palindrome.length() - 1;
		for (first = 0; first <= last; first++) {
			if (palindrome.charAt(first) != palindrome.charAt(last))
				toAdd = palindrome.charAt(first) + toAdd;
			else if (isPalindrome(palindrome.substring(first)))
				break;
			else// In case first== but substring is not a palindrome
				toAdd = palindrome.charAt(first) + toAdd;
		}
		return palindrome + toAdd;
	}

	public boolean isPalindrome(String palindrome) throws InterruptedException {
		int first = 0;
		int last = palindrome.length() - 1;
		for (first = 0; first <= (palindrome.length() - 1) / 2; first++, last--)
			if (palindrome.charAt(first) != palindrome.charAt(last))
				return false;
		return true;
	}
}
