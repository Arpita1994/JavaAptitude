package com.mcs.bingo.ux;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JTextField;

import edu.kzoo.grid.gui.EnabledDisabledStates;
import edu.kzoo.grid.gui.GeneratedButtonList;
import edu.kzoo.grid.gui.GridAppFrame;

public class BingoGUI extends GridAppFrame {
	// Specify dimensions of grid display and individual cell size.
	private static final int DISPLAY_WIDTH = 300;
	private static final int DISPLAY_HEIGHT = 300;
	private static final int MIN_CELL_SIZE = 10;

	// Define control buttons attributes.
	private static final boolean INCLUDE_ONLY_ON_BUTTONCLICK_METHODS = true;
	private static final boolean DISPLAY_GRID_AFTER_BUTTON_PRESSES = true;

	/**
	 * Constructs a graphical user interface to display the given Bingo card.
	 * 
	 * @param card
	 *            the card to display
	 * @param game
	 *            the game controller
	 * @param author
	 *            the author(s) of the program
	 * @param assistance
	 *            the names of anyone who provided assistance to the author(s)
	 * @param versionOrDate
	 *            a number or date identifying the version of the program being
	 *            executed
	 */
	public BingoGUI(BingoCard card, BingoGame game) {
		// Create graphical user interface capable of displaying a
		// bingo game. Column headings and numbers on the bingo card
		// will be represented with text cells.

		// Generate control buttons derived from the methods of the target
		// BingoGame object and include them in the user interface.
		GeneratedButtonList generatedButtonList = new GeneratedButtonList(this, game,
				INCLUDE_ONLY_ON_BUTTONCLICK_METHODS, DISPLAY_GRID_AFTER_BUTTON_PRESSES);
		JTextField textField = new JTextField(20);
		add(textField);
		setSize(500, 500);
		setVisible(true);
		includeControlComponents(generatedButtonList, EnabledDisabledStates.NEEDS_GRID_AND_APP_WAITING);

		constructWindowContents("Bingo Game", Color.BLUE, DISPLAY_WIDTH, DISPLAY_HEIGHT, MIN_CELL_SIZE);

		setGrid(card);
		showGrid();
	}

	/** Defines contents of main window panel. */
	protected JPanel defineContent() {
		JPanel content = new JPanel();
		content.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
		content.setLayout(new BorderLayout());

		// Create a panel to display the grid and speed slider bar
		// and another for the control buttons (e.g., a Reset button),
		// and add them to the main panel.
		JPanel grid = new JPanel();
		grid.setLayout(new BorderLayout());

		grid.add(makeDisplayPanel(), BorderLayout.CENTER);

		JComponent sliderPanel = makeSliderPanel();
		if (sliderPanel != null)
			grid.add(sliderPanel, BorderLayout.SOUTH);

		content.add(grid, BorderLayout.CENTER);

		JComponent controlPanel = makeControlPanel(null);
		if (controlPanel != null)
			content.add(controlPanel, BorderLayout.WEST);

		return content;
	}
}
