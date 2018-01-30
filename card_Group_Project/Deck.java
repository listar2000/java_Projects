package elevenCardProject;

import java.util.List;
import java.util.Random;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;

/**
 * The Deck class represents a shuffled deck of cards.
 * It provides several operations including
 *      initialize, shuffle, deal, and check if empty.
 */
public class Deck {
	
	/*
	 * cards contains all the cards in the deck.
	 */
	private List<Card> cards;
	
	/**
	 * size is the number of not-yet-dealt cards.
	 * Cards are dealt from the top (highest index) down.
	 * The next card to be dealt is at size - 1.
	 */
	private int size;
	
	/**
	 * This part of the code is for testing whether the methods work
	 */

	/**
	 * Creates a new <code>Deck</code> instance.<BR>
	 * It pairs each element of ranks with each element of suits,
	 * and produces one of the corresponding card.
	 * @param ranks is an array containing all of the card ranks.
	 * @param suits is an array containing all of the card suits.
	 * @param values is an array containing all of the card point values.
	 */
	
	public Deck(String[] ranks, String[] suits, int[] values) {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 2 *** */
		
		cards = new ArrayList<Card>();
		
		for(int x=0; x<suits.length; x++) {
			for(int y=0; y<ranks.length; y++) {
				cards.add(new Card(ranks[y], suits[x], values[y]));
			}
		}
	}

	/**
	 * Create a new Deck with ranks, suits, pointValues arrays
	 * the 52 cards in the Deck are in order
	 * @return the deck newly created Deck
	 */
	public static Deck initiateDeck() {
		
		String[] ranks = {"a","2","3","4","5","6","7","8","9","10","jack", "queen", "king"};
		String[] suits = {"ºìÌÒ", "ºÚÌÒ","Ã·»¨","·½¿é"};
		int[] pointValues = {1,2,3,4,5,6,7,8,9,10,11,12,13};
		Deck fullDeck = new Deck(ranks, suits, pointValues);
		
		return fullDeck;
		
	}
	
	/**
	 * To print all the cards undealt in the deck
	 * using the toString method
	 */
	public void printCards() {
		
		Iterator<Card> i = this.cards.iterator();
		
		while(i.hasNext()) {
			
			System.out.println(i.next().toString());
			
		}
	}
	
	/**
	 * Determines if this deck is empty (no undealt cards).
	 * @return true if this deck is empty, false otherwise.
	 */
	public boolean isEmpty() {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 2 *** */
		if (cards.size() == 0) return true;
		else return false;
	}

	/**
	 * Accesses the number of undealt cards in this deck.
	 * @return the number of undealt cards in this deck.
	 */
	public int size() {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 2 *** */
		return cards.size();
	}

	/**
	 * Randomly permute the given collection of cards
	 * and reset the size to represent the entire deck.
	 */
	public void shuffle() {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 4 *** */
		size = cards.size();
		Random generator = new Random();
		while (size > 0){
			int x = generator.nextInt(size);
			cards.add(cards.get(x));
			cards.remove(x);
			size--;
		}
	}

	/**
	 * Deals a card from this deck.
	 * @return the card just dealt, or null if all the cards have been
	 *         previously dealt.
	 */
	public Card deal() {

		if (this.isEmpty()) return null;
		
		Random random = new Random();
		int index = random.nextInt(cards.size());
		Card dealtCard = cards.remove(index);
			
		return dealtCard;
			
		
	}

	/**
	 * Generates and returns a string representation of this deck.
	 * @return a string representation of this deck.
	 */
	@Override
	public String toString() {
		String rtn = "size = " + size() + "\nUndealt cards: \n";

		for (int k = size() - 1; k >= 0; k--) {
			rtn = rtn + cards.get(k);
			if (k != 0) {
				rtn = rtn + ", ";
			}
			if ((size() - k) % 2 == 0) {
				// Insert carriage returns so entire deck is visible on console.
				rtn = rtn + "\n";
			}
		}

		rtn = rtn + "\nDealt cards: \n";
		for (int k = cards.size() - 1; k >= size(); k--) {
			rtn = rtn + cards.get(k);
			if (k != size()) {
				rtn = rtn + ", ";
			}
			if ((k - cards.size()) % 2 == 0) {
				// Insert carriage returns so entire deck is visible on console.
				rtn = rtn + "\n";
			}
		}

		rtn = rtn + "\n";
		return rtn;
	}
}