package com.one.vo;

public class Encrypt {

	static int key = 2;

	public static String passwordEncyption(String pass) {

		String password = "";

		for (int i = 0; i < pass.length(); i++) {
			if ((pass.charAt(i) >= 'a' && pass.charAt(i) <= 'z') || (pass.charAt(i) >= 'A' && pass.charAt(i) <= 'Z')) {

				password = password + ((char) (pass.charAt(i) + key));
//System.out.println(password);
			} else
				password = password + ((char) (pass.charAt(i) + key));
		}
		return password;
	}

}
