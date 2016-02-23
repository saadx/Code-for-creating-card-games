package proj3fa15;

/**
 * <p>Title: Project 3 Application class</p>
 *
 * <p>Description: Testing different methods of the Card, Deck and DiscardPile classes
 * 					in different situations</p>
 * 
 * @author Saad Ahmad
 */

public class Proj3App 
{
	public static void main (String args[])
	{
		System.out.println("...Testing createJoker method...");
		Card c1 = Card.createJoker();
		System.out.println("testing toString on joker card: " + c1.toString());
		System.out.println("Value stored in joker card: " + c1.getValue());
		System.out.println("Suit of joker card: " + c1.getSuit());

		System.out.println("\n...Testing Deck class...");
		Deck singleDeck = new Deck();    //regular deck of 52 cards
		Deck multiDeck = new Deck(2,3);  //deck of 107 cards (2 decks + 3 jokers)
		Deck emptyDeck = new Deck();	 //will be used for error testing (not yet empty)
		Deck partialDeck = new Deck();	 //partially filler deck(not yet partially filled)

		//emptying emptyDeck
		for (int i = 0; i < 52; i++)
		{
			emptyDeck.dealCard();
		}
		//removing few cards from partialDeck
		for (int i = 0; i < 30; i++)
		{
			partialDeck.dealCard();
		}

		System.out.println("\nMaking sure emptyDeck is empty: " + emptyDeck.isEmpty());

		System.out.println("\n***Testing constructors***");
		System.out.println("\n--toString on singleDeck: \n" + singleDeck.toString());
		System.out.println("\n--toString on multiDeck: \n" + multiDeck.toString());
		System.out.println("\n--toString on partialDeck: \n" + partialDeck.toString());
		System.out.println("\n--toString on emptyDeck: \n" + emptyDeck.toString());

		//testing cut before shuffling because it easier to test cut when cards are in order
		System.out.println("\n***Testing cut method***");

		System.out.println("---cut on singleDeck:");
		System.out.println(singleDeck.cut() + " cards cut.");
		System.out.println("singleDeck after cutting:\n" + singleDeck.toString());

		System.out.println("---cut on multiDeck:");
		System.out.println(multiDeck.cut() + " cards cut.");
		System.out.println("multiDeck after cutting:\n" + multiDeck.toString());

		System.out.println("---cut on partialDeck:");
		System.out.println(partialDeck.cut() + " cards cut.");
		System.out.println("partialDeck after cutting:\n" + partialDeck.toString());

		try
		{
			System.out.println("\n--trying cut on emptyDeck: \n");
			emptyDeck.dealCard();
			System.out.println("\n--error in cut method");
		}
		catch (DeckException ex)
		{
			System.out.println(ex.getMessage());
		}

		System.out.println("\n***Testing shuffleDeck method***");
		singleDeck.shuffleDeck();
		System.out.println("\n--singleDeck after shuffling: \n" + singleDeck.toString());
		multiDeck.shuffleDeck();
		System.out.println("\n--multiDeck after shuffling: \n" + multiDeck.toString());
		partialDeck.shuffleDeck();
		System.out.println("\n--partialDeck after shuffling: \n" + partialDeck.toString());

		try
		{
			System.out.println("\n--trying shuffling on emptyDeck: \n");
			emptyDeck.shuffleDeck();
			System.out.println("\n--error in shuffle method");
		}
		catch (DeckException ex)
		{
			System.out.println(ex.getMessage());
		}

		System.out.println("\n***Testing dealCard method***");
		System.out.println("---dealCard on singleDeck: card dealt: " + singleDeck.dealCard());
		System.out.println("Checking if card is removed after dealing: \n" + singleDeck.toString());
		System.out.println("---dealCard on multiDeck: card dealt: " + multiDeck.dealCard());
		System.out.println("Checking if card is removed after dealing: \n" + multiDeck.toString());
		System.out.println("---dealCard on partialDeck: card dealt: " + partialDeck.dealCard());
		System.out.println("Checking if card is removed after dealing: \n" + partialDeck.toString());
		try
		{
			System.out.println("\n--trying dealCard on emptyDeck: \n");
			emptyDeck.dealCard();
			System.out.println("\n--error in dealCard method");
		}
		catch (DeckException ex)
		{
			System.out.println(ex.getMessage());
		}

		System.out.println("\n***Testing putCardsInDeck method***");

		//for testing putCardsInDeck
		Card[] someCards = new Card[3];
		someCards[0] = new Card(1);
		someCards[1] = Card.createJoker();
		someCards[2] = new Card(22);

		try
		{
			System.out.println("\n---Trying to put cards in singleDeck which is full");
			singleDeck.putCardsInDeck(someCards);
			System.out.println("\n--error in putCardsInDeck method");
		}
		catch (DeckException ex)
		{
			System.out.println(ex.getMessage());
		}

		try
		{
			System.out.println("\n---Trying to put cards in multiDeck which is full");
			singleDeck.putCardsInDeck(someCards);
			System.out.println("\n--error in putCardsInDeck method");
		}
		catch (DeckException ex)
		{
			System.out.println(ex.getMessage());
		}

		System.out.println("\n---Trying to put cards in partialDeck");
		partialDeck.putCardsInDeck(someCards);
		System.out.println("partialDeck after adding cards:\n" + partialDeck.toString());

		//need to put cards in someCards[] again because 
		//putting in partial deck made all indexes null
		someCards[0] = new Card(1);
		someCards[1] = Card.createJoker();
		someCards[2] = new Card(22);
		System.out.println("\n---Trying to put cards in emptyDeck");
		emptyDeck.putCardsInDeck(someCards);
		System.out.println("emptyDeck after adding cards:\n" + emptyDeck.toString());

		//isEmpty on non-empty deck
		System.out.println("isEmpty on multiDeck: " + multiDeck.isEmpty());


		System.out.println("\n...Testing DiscardPile class...");

		DiscardPile aPile = new DiscardPile();
		System.out.println("\nCurrent state of pile: " + aPile.toString());

		aPile.addCard(new Card(3));
		aPile.addCard(Card.createJoker());
		aPile.addCard(new Card(24));
		aPile.addCard(new Card(17));
		System.out.println("\nState of pile after adding 4 cards: \n" + aPile.toString());

		aPile.removeCard();
		System.out.println("State of pile after removing 1 card: \n" + aPile.toString());

		try
		{
			System.out.println("Trying to remove more than the number of cards in the pile:");
			aPile.removeCards(5);
			System.out.println("Error in removeCards");
		}
		catch(DiscardPileException ex)
		{
			System.out.println(ex.getMessage());
		}

		System.out.println("\nTrying to remove all 3 cards from the pile and checking output:");
		Card[] temp = aPile.removeCards(3);
		for(int i = 0; i < temp.length; i++)
		{
			System.out.println(temp[i].toString());
		}
		System.out.println("\nState of pile after removing those 3 cards: " + aPile.toString());

		try
		{
			System.out.println("\nTesting removeCard on empty pile---");
			aPile.removeCard();
			System.out.println("Error in removeCards");
		}
		catch(DiscardPileException ex)
		{
			System.out.println(ex.getMessage());
		}

		System.out.println("\nTesting size on empty pile---:" + aPile.size());
		System.out.println("\nTesting isEmpty on empty pile---:" + aPile.isEmpty());

		aPile.addCard(new Card(24));
		aPile.addCard(new Card(17));
		System.out.println("\nTesting size on non empty pile---:" + aPile.size());
		System.out.println("\nTesting isEmpty non empty pile---:" + aPile.isEmpty());
	}
}
