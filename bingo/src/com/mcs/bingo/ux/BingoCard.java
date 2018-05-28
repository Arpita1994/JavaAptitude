package com.mcs.bingo.ux;

import com.mcs.bingo.dto.BingoValueCell;
import com.mcs.bingo.service.PlayService;

import edu.kzoo.grid.BoundedGrid;
import edu.kzoo.grid.Location;

public class BingoCard extends BoundedGrid {
	// Private constants defined for use in this class.
	static final String BINGO = "MCS";
	static final String BINGOREVERSE = "SCM";
	private static final int NUMROWS = BINGO.length();
	private static final int NUMCOLS = BINGO.length();
	private int max_value;
	private int subrange_size;

	/**
	 * Constructs a new BingoCard object containing numbers in the range of 1 --
	 * max_value.
	 */
	public BingoCard() {
		super(NUMROWS, NUMCOLS);
		this.subrange_size = max_value / BINGO.length();
	}

	/**
	 * Set up (or reset) the card with column headings and random Bingo values.
	 */
	public void initialize() {
		// Clear the results from a previous game.
		removeAll(); // this method is inherited from BoundedGrid

		for (int col = 0; col < numCols(); col++)
			initCol(col, (col * subrange_size) + 1, (col + 1) * subrange_size);
	}

	/**
	 * Initializes the cells in the given column with numbers from the given
	 * range.
	 * 
	 * @param col
	 *            which column to initialize
	 * @param min
	 *            smallest valid number to appear this column
	 * @param max
	 *            largest valid number to appear in this column
	 */
	private void initCol(int col, int min, int max) {
		// Replace following stub code with a loop to fill the entire
		// column with random numbers from getUnusedRandomNum.
		addCell(new BingoValueCell(PlayService.generateRandomCharacters()), 0, col);// R0C0,
																					// R0C1,
																					// R0C2
		addCell(new BingoValueCell(PlayService.generateRandomCharacters()), 1, col);// R1c0,
																					// R1C1,
																					// R1C2
		addCell(new BingoValueCell(PlayService.generateRandomCharacters()), 2, col);// R2Co,
																					// R2,C1,R2c2

	}

	/**
	 * Initializes the cells in the given column with numbers from the given
	 * range.
	 * 
	 * @param col
	 *            which column to initialize
	 * @param min
	 *            smallest valid number to appear this column
	 * @param max
	 *            largest valid number to appear in this column
	 *//*
		 * private void initCol(int col, int min, int max) { // Replace
		 * following stub code with a loop to fill the entire // column with
		 * random numbers from getUnusedRandomNum. addCell(new
		 * BingoValueCell(min), 0, col); addCell(new BingoValueCell(min + 2), 1,
		 * col); addCell(new BingoValueCell(min + 4), 2, col); addCell(new
		 * BingoValueCell(min + 6), 3, col); addCell(new BingoValueCell(max), 4,
		 * col); }
		 */

	private void addCell(BingoValueCell bingoValueCell, int i, int col) {
		add(bingoValueCell, new Location(i, col));

	}

}
