package com.mcs.bingo.service;

import java.util.Random;

public class PlayService {

	public static char generateRandomCharacters() {
		Random r = new Random();
		String alphabet = "MCS";
		return alphabet.charAt(r.nextInt(alphabet.length()));
	}
}
