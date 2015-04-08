package com.julvdev.bepwhist.server.card;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class CardHand {
	
	private final String EMPTY_HAND = "Empty hand";
	private ArrayList<Card> cards = new ArrayList<Card>();
	
	private Random random = new Random();
	
	public CardHand() {
		
	}
	
	public CardHand(int[] deckValues) {
		for (int i=0; i<deckValues.length; i++) {
			cards.add(new Card(deckValues[i]));
		}
	}
	
	public CardHand(ArrayList<Card> cards) {
		this.cards=cards;
	}
	
	public CardHand(Card[] cards) {
		this.cards = new ArrayList<Card>(Arrays.asList(cards));
	}
	
	public void addCard(int deckValue) {
		cards.add(new Card(deckValue));
	}
	
	public void addCard(Card card) {
		cards.add(card);
	}
	
	public int getSize() {
		return cards.size();
	}
	
	public boolean hasDeckValue(int deckValue) {
		for (Card card : cards) {
			if (card.getDeckValue() == deckValue) {
				return true;
			}
		}
		return false;
	}
	
	public boolean hasFaceValue(int faceValue) {
		for (Card card : cards) {
			if (card.getFaceValue() == faceValue) {
				return true;
			}
		}
		return false;
	}
	
	public boolean hasSuitValue(int suitValue) {
		for (Card card : cards) {
			if (card.getSuitValue() == suitValue) {
				return true;
			}
		}
		return false;
	}
	
	public Card playCardAt(int index) {
		if (index>cards.size()-1 || index<0) {
			return null;
		}
		Card card = cards.get(index);
		cards.remove(index);
		return card;
	}
	
	public Card playCard(int deckValue) {
		for (int i=0; i<cards.size(); i++) {
			if (cards.get(i).getDeckValue() == deckValue) {
				Card card = cards.get(i);
				cards.remove(i);
				return card;
			}
		}
		return null;
	}
	
	public Card playCardRandom() {
		if (cards.isEmpty()) {
			return null;
		}
		int randomNumber = random.nextInt(cards.size());
		Card card = cards.get(randomNumber);
		cards.remove(randomNumber);
		return card;
	}
	
	public String toString() {
		if (cards.isEmpty()) {
			return EMPTY_HAND;
		}
		String result="";
		for (Card card : cards) {
			result+=card.toString()+"\n";
		}
		return result;
	}
	
	public String toStringShort() {
		if (cards.isEmpty()) {
			return EMPTY_HAND;
		}
		String result="";
		for (Card card : cards) {
			result+=card.toStringShort()+" ";
		}
		return result;
	}
}
