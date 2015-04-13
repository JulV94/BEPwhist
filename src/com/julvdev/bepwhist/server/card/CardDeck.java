package com.julvdev.bepwhist.server.card;

import java.util.ArrayList;

public class CardDeck {
	
	private final String EMPTY_DECK = "Empty deck";
	
	private ArrayList<Card> deck = new ArrayList<Card>();
	
	public CardDeck() {
		
	}
	
	public void fillDeck() {
		if (deck.isEmpty()) {
			for (int i=0; i<52; i++) {
				deck.add(new Card(i));
			}
		}
	}
	
	public void addCards(ArrayList<Card> cards) {
		this.deck.addAll(cards);
	}
	
	public CardHand[] DealHands() {
		if (deck.size() != 52) {
			return null;
		}
		CardHand[] hands = new CardHand[4];
		for (int i=0; i<4; i++) {
			hands[i] = new CardHand();
			hands[i].addCards(deck.subList(i*4, (i*4)+3));
			hands[i].addCards(deck.subList(16+(i*5), (i*5)+20));
			hands[i].addCards(deck.subList(36+(i*4), (i*4)+40));
		}
		deck.clear();
		return hands;
	}
	
	public ArrayList<Card> getDeck() {
		return deck;
	}
	
	public void shuffleDeck() {
		// Shuffle the deck just for a new whist round
	}
	
	public String toString() {
		if (deck.isEmpty()) {
			return EMPTY_DECK;
		}
		String result="";
		for (Card card : deck) {
			result+=card.toString()+"\n";
		}
		return result;
	}
	
	public String toStringShort() {
		if (deck.isEmpty()) {
			return EMPTY_DECK;
		}
		String result="";
		for (Card card : deck) {
			result+=card.toStringShort()+" ";
		}
		return result;
	}
}
