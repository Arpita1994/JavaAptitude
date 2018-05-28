package com.mcs.bingo.dto;

import java.awt.Color;

import edu.kzoo.grid.Grid;
import edu.kzoo.grid.GridObject;
import edu.kzoo.grid.Location;

public class BingoValueCell extends GridObject {
	private char theValue;
	private Color theColor;

	/**
	 * Constructs objects of class BingoValueCell with the given value and text
	 * color.
	 */
	public BingoValueCell(char value) {
		super();
		theValue = formatNumForCard(value);
	}

	/**
	 * Constructs objects of class BingoValueCell with the given value and text
	 * color.
	 */
	public BingoValueCell(char value, Color textColor) {
		super();
		theValue = value;
		theColor = textColor;
	}

	/**
	 * Returns a formatted string version of the number specified as
	 * <code>num</code> suitable for placing in a cell on a bingo card.
	 */
	private char formatNumForCard(char num) {
		return num;
	}

	/**
	 * Returns the value in this cell as a String.
	 **/
	public char text() {
		return theValue;
	}

	/**
	 * Returns the value in this cell as an integer (if it is an integer).
	 **/
	public char value() {
		return theValue;
	}

	/**
	 * Gets color of value in this cell.
	 **/
	public Color color() {
		return theColor;
	}

}
