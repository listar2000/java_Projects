package elevenCardProject;

import java.util.List;

import javax.swing.JOptionPane;

import java.util.ArrayList;

/**
 * The ElevensBoard class represents the board in a game of Elevens.
 */
public class ElevensBoard extends Board{

	/**
	 * The size (number of cards) on the board.
	 */
	private static final int BOARD_SIZE = 9;

	/**
	 * The ranks of the cards for this game to be sent to the deck.
	 */
	private static final String[] RANKS =
		{"ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "jack", "queen", "king"};

	/**
	 * The suits of the cards for this game to be sent to the deck.
	 */
	private static final String[] SUITS =
		{"spades", "hearts", "diamonds", "clubs"};

	/**
	 * The values of the cards for this game to be sent to the deck.
	 */
	private static final int[] POINT_VALUES =
		{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 0, 0, 0};

	public ElevensBoard() {
		super(BOARD_SIZE, RANKS, SUITS, POINT_VALUES);
	}

	
	@Override
	public void newGame() {
		deck = new Deck(RANKS, SUITS, POINT_VALUES);
		super.newGame();
	}
	/**
	 * Determine if there are any legal plays left on the board.
	 * In Elevens, there is a legal play if the board contains
	 * (1) a pair of non-face cards whose values add to 11, or (2) a group
	 * of three cards consisting of a jack, a queen, and a king in some order.
	 * @return true if there is a legal play left on the board;
	 *         false otherwise.
	 */
	@Override
	public boolean anotherPlayIsPossible() {
		
		List<Integer>list = cardIndexes();
//		System.out.println("the list is "+isLegal(list));
		if (isLegal(list)) {
			return true;
		}
		return false;
		
	}


	/**
	 * Deal cards to this board to start the game.
	 */
	private void dealMyCards() {
		for (int k = 0; k < cards.length; k++) {
			cards[k] = deck.deal();
		}
	}

	/**
	 * Determines if the selected cards form a valid group for removal.
	 * In Elevens, the legal groups are (1) a pair of non-face cards
	 * whose values add to 11, and (2) a group of three cards consisting of
	 * a jack, a queen, and a king in some order.
	 * @param selectedCards the list of the indices of the selected cards.
	 * @return true if the selected cards form a valid group for removal;
	 *         false otherwise.
	 */
	@Override
	public boolean isLegal(List<Integer> selectedCards) {
		
		if (containsJQK(selectedCards) || containsPairSum11(selectedCards)) {
			return true;
		}
		return false;
	}
	
	/**
	 * Check for an 11-pair in the selected cards.
	 * @param selectedCards selects a subset of this board.  It is list
	 *                      of indexes into this board that are searched
	 *                      to find an 11-pair.
	 * @return true if the board entries in selectedCards
	 *              contain an 11-pair; false otherwise.
	 */
	private boolean containsPairSum11(List<Integer> selectedCards) {
		
		/* *** TO BE IMPLEMENTED IN ACTIVITY 9 *** */
		for (int i=0; i<BOARD_SIZE; i++) {
			int value = 11- cardAt(selectedCards.get(i)).getPoint();
		for (int j=0; j<BOARD_SIZE; j++) {
			if (cardAt(selectedCards.get(j)).getPoint()==value) return true;
			}
		}
		return false;
	}

	/**
	 * Check for a JQK in the selected cards.
	 * @param selectedCards selects a subset of this board.  It is list
	 *                      of indexes into this board that are searched
	 *                      to find a JQK group.
	 * @return true if the board entries in selectedCards
	 *              include a jack, a queen, and a king; false otherwise.
	 */
	private boolean containsJQK(List<Integer> selectedCards) {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 9 *** */
		boolean YKing = false;
		boolean YQueen = false;
		boolean YJack = false;
		for (Integer c: selectedCards) {
			if (cards[c].getRank() == "jack") YJack=true;
			if (cards[c].getRank() == "queen") YQueen=true;
			if (cards[c].getRank() == "king") YKing=true;
			if (YJack&&YQueen&&YKing) {
				return true;
			}
		}
		return false;
	}
}
