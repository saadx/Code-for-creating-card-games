package proj3fa15;

import java.util.Random;

/**
 * <p> Title: The Deck class </p>
 *
 * <p> Description: This class represents a Deck of 52 playing cards. It can
 * also create multi-deck decks which may include jokers too. It gets created in
 * order and then must be shuffled to randomize the order of the cards. Cards
 * are dealt from the top of the deck. Also has methods to shuffle, cut,
 * putCardsInDeck </p>
 * 
 * @author Professor Burdge and Saad Ahmad
 */
public class Deck
{
	// instance variables
	private Card[] cards;
	private int numCards;

	/**
	 * default constructor which creates the deck of 52 cards (without Jokers)
	 * in order
	 */
	public Deck()
	{
		numCards = 52;
		cards = new Card[numCards];
		for (int i = 0; i < cards.length; i++)
		{
			cards[i] = new Card(i);
		}
	}

	/**
	 * parameterized constructor - creates initializes a multi-deck object that
	 * may contain jokers
	 * 
	 * @param noOfDecks
	 *            - stores the number of decks to be created
	 * @param noOfJokers
	 *            - stores the number of jokers to be created
	 */
	public Deck(int noOfDecks, int noOfJokers)
	{
		numCards = ((52 * noOfDecks) + noOfJokers);
		cards = new Card[numCards];
		int counter = 0; // times needed to loop deck creation
		int last = 0; // remembers last index
		while (counter < noOfDecks)
		{
			for (int i = last; i < last + 52; i++)
			{
				cards[i] = new Card(i - (52 * counter));
			}
			last += 52;
			counter++;
		}
		if (noOfJokers > 0)
		{
			for (int i = 0; i < noOfJokers; i++)
			{
				cards[last] = Card.createJoker();
				last++;
			}
		}
	}

	/**
	 * shuffleDeck method -- places the cards in the deck in a random order
	 */
	public void shuffleDeck()
	{
		if (numCards == 0)
			throw new DeckException("No cards to shuffle; deck empty.");
		Card temp;
		int ran1, ran2;
		for (int i = 0; i < 100; i++)
		{
			ran1 = (int) (Math.random() * numCards);
			ran2 = (int) (Math.random() * numCards);
			temp = cards[ran1];
			cards[ran1] = cards[ran2];
			cards[ran2] = temp;
		}
	}

	/**
	 * dealCard -- deals the top card from the deck and decreases the number of
	 * cards in the deck by 1
	 * 
	 * @return a reference to the Card being dealt
	 */
	public Card dealCard()
	{
		if (numCards == 0)
			throw new DeckException("No cards to deal; deck empty");
		if (numCards > 0)
		{
			numCards--;
			return cards[numCards];
		} else
			return null;
	}

	/**
	 * cut -- cuts the deck into two parts based on a random number
	 * 
	 * @return int - the number of cards cut
	 * 
	 * @throws DeckException
	 *             if deck is empty
	 */
	public int cut()
	{
		if (numCards == 0)
			throw new DeckException("Deck cannot be cut as deck is empty");

		Random generator = new Random();
		int cutIndex = generator.nextInt(numCards - 1) + 1;
		Card[] cutDeck = new Card[cards.length];
		int index = 0;

		// copying the cut cards
		for (int i = numCards - cutIndex; i < numCards; i++)
		{
			cutDeck[index] = cards[i];
			index++;
		}

		// copying the rest of the deck
		for (int i = 1; i <= numCards - cutIndex; i++)
		{
			cutDeck[index] = cards[i - 1];
			index++;
		}

		cards = cutDeck;
		return cutIndex;
	}

	/**
	 * putCardsInDeck -- removes the cards from the Card array received as
	 * parameter and put them at the bottom of the deck
	 * 
	 * @param addCards
	 *            - stores the reference of card array sent as argument
	 * 
	 * @throws DeckException
	 *             if deck is full or cards to be added are more the number of
	 *             spaces remaining
	 */
	public void putCardsInDeck(Card[] addCards)
	{
		if ((addCards.length + numCards) > cards.length)
			throw new DeckException(
					"Deck is full or cards to be added are more the number of spaces remaining");
		Card[] temp = new Card[cards.length];

		for (int i = 0; i < addCards.length; i++)
		{
			temp[i] = addCards[i];
			addCards[i] = null;
			// numCards++;
		}

		for (int i = 0; i < numCards; i++)
		{
			temp[addCards.length + i] = cards[i];
		}

		numCards += addCards.length;
		cards = temp;
	}

	/**
	 * isEmpty -- checks if the deck if empty
	 * 
	 * @return boolean - returns true if deck is empty else false
	 */
	public boolean isEmpty()
	{
		return numCards == 0;
	}

	/**
	 * toString -- returns the state of the deck as a string
	 * 
	 * @return a string containing the cards currently in the deck
	 */
	public String toString()
	{
		String temp = new String();
		for (int i = numCards - 1; i >= 0; i--)
			temp += "Card " + (numCards - i) + ": " + cards[i].toString() + "\n";
		return temp;
	}
}
