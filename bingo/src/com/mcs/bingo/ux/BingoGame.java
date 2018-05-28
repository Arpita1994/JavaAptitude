package com.mcs.bingo.ux;

import java.util.Random;

import com.mcs.bingo.dto.BingoValueCell;
import com.mcs.bingo.service.PlayService;

import edu.kzoo.grid.GridObject;

public class BingoGame {

	private BingoCard card;
	private BingoGUI display;
	private int score;

	/**
	 * Constructs an object that controls games of Bingo.
	 */
	public BingoGame() {
		this.card = new BingoCard();

		this.display = new BingoGUI(card, this);

	}

	public void onPlayButtonClick() {
		score = 0;
		this.card.initialize();
		GridObject[] allObjects = this.card.allObjects();
		getRow(allObjects, 0);
		getRow(allObjects, 1);
		getRow(allObjects, 2);

		getColumn(allObjects, 0);
		getColumn(allObjects, 1);
		getColumn(allObjects, 2);

		System.out.println(score);

	}

	public void getRow(GridObject[] object, int rowNumber) {

		StringBuffer rowBuffer = new StringBuffer();
		for (GridObject grid : object) {
			BingoValueCell cell = (BingoValueCell) grid;

			if (cell.location().row() == rowNumber) {
				rowBuffer.append(cell.text());
			}

		}
		if (rowBuffer.toString().equals(BingoCard.BINGO) || rowBuffer.toString().equals(BingoCard.BINGOREVERSE)) {
			score++;
		}
	}

	public void getColumn(GridObject[] object, int colNumber) {
		StringBuffer columnBuffer = new StringBuffer();
		for (GridObject grid : object) {
			BingoValueCell cell = (BingoValueCell) grid;

			if (cell.location().col() == colNumber) {
				columnBuffer.append(cell.text());
			}

		}
		if (columnBuffer.toString().equals(BingoCard.BINGO) || columnBuffer.toString().equals(BingoCard.BINGOREVERSE)) {
			score++;
		}
	}
}
