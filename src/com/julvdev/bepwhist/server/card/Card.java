package com.julvdev.bepwhist.server.card;

public class Card {
	
	public static final int SPADES=1;
	public static final int CLUBS=2;
	public static final int DIAMONDS=3;
	public static final int HEARTS=4;
	
	private static final String[] suitNames = new String[]
			{
			"spades","clubs","diamonds","hearts"
			};
	public static final int JACK=11;
	public static final int QUEEN=12;
	public static final int KING=13;
	public static final int ACE=14;
	
	private static final String[] faceNames = new String[]
			{
			"2","3","4","5","6","7","8","9","10","Jack","Queen","King","Ace"
			};
	/**
	 * The face value of the card
	 */
	private final int faceValue;
	/**
	 * The suit value of the card
	 */
	private final int suitValue;
	/**
	 * Position of the card in a sorted deck
	 */
	private final int deckValue;
	/**
	 * Constructs a Card object with a face and a suit value
	 * @param faceValue The face value
	 * @param suitValue The suit value
	 */
	public Card(int faceValue, int suitValue) {
		if (faceValue<2 || faceValue>14 || suitValue<1 || suitValue>4) {
			throw new IllegalArgumentException();
		}
		this.faceValue=faceValue;
		this.suitValue=suitValue;
		deckValue=toDeckValue(faceValue, suitValue);
	}
	/**
	 * Constructs a Card object with a deck value
	 * @param deckValue The deck value
	 */
	public Card(int deckValue) {
		if (deckValue<0 || deckValue>52) {
			throw new IllegalArgumentException();
		}
		this.deckValue=deckValue;
		faceValue=toFaceValue(deckValue);
		suitValue=toSuitValue(deckValue);
	}
	/**
	 * Verifies if the object is a card with the same value
	 * @param object The Object to test
	 * @return true if the object is a card of the same value, false otherwise
	 */
	public boolean sameAs(Object object) {
		if (!(object instanceof Card)) {
			return false;
		}
		return (deckValue == ((Card)object).getDeckValue());
	}
	
	public int getDeckValue() {
		return deckValue;
	}
	
	public int getFaceValue() {
		return faceValue;
	}
	
	public int getSuitValue() {
		return suitValue;
	}
	
	public String getFaceName() {
		return faceNames[faceValue-2];
	}
	
	public String getSuitName() {
		return suitNames[suitValue-1];
	}
	
	public String toString() {
		return getFaceName()+" of "+getSuitName();
	}
	/**
	 * Get a short version of the toString output
	 * @return short toString output
	 * @see Card#toString()
	 */
	public String toStringShort() {
		String faceShortName;
		if (faceValue == 10) {
			faceShortName=getFaceName();
		}
		else {
			faceShortName=getFaceName().substring(0,1);
		}
		return faceShortName+getSuitName().substring(0,1);
	}
	
	private int toFaceValue(int deckValue) {
		return (deckValue%13)+2;
	}
	
	private int toSuitValue(int deckValue) {
		return (deckValue/13)+1;
	}
	
	private int toDeckValue(int faceValue, int suitValue) {
		return (suitValue-1)*13+(faceValue-2);
	}
	
}
