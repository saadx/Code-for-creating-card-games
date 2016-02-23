package proj3fa15;

/**
 * <p> Title: The DiscardPile class </p>
 *
 * <p>Description: This class contains methods necessary for discard piles used
 * in card games. It has methods to add cards to the pile, remove one card,
 * remove multiple cards, find size of the pile, check if pile is empty and
 * toString to display the state of the pile.</p>
 * 
 * @author Saad Ahmad
 */

public class DiscardPile
{
	private Node dPile;

	/**
	 * default constructor - creates an empty stack
	 */
	public DiscardPile()
	{
		dPile = null;
	}

	/**
	 * addCard method - stores a new item on the top of the pile
	 * 
	 * @param aCard
	 *            - a reference to the card to be stored on top of the pile
	 */
	public void addCard(Card aCard)
	{
		dPile = new Node(aCard, dPile);
	}

	/**
	 * removeCard method - removes the top-most item from the pile
	 * 
	 * @return a reference to the card which was stored on top of the pile
	 * @throws DiscardPileException
	 *             if the pile is empty
	 */
	public Card removeCard()
	{
		if (isEmpty())
			throw new DiscardPileException("No cards to remove");

		Card temp = dPile.getItem();
		dPile = dPile.getNext();

		return temp;
	}

	/**
	 * removeCard method - removes the top-most item from the pile
	 * 
	 * @param num
	 *            - stores the number of cards to be removed
	 * @return a reference to the card which was stored on top of the pile
	 * @throws DiscardPileException
	 *             if the pile is empty
	 */
	public Card[] removeCards(int num)
	{
		if (num > size())
			throw new DiscardPileException(
					"Requested number of cards to remove not available in discard pile.");

		Card[] temp = new Card[num];
		for (int i = 0; i < num; i++)
		{
			temp[i] = removeCard();
		}
		return temp;
	}

	/**
	 * size method - returns a count of the number of items in the pile
	 * 
	 * @return the number of items in the pile
	 */
	public int size()
	{
		int counter = 0;
		Node current = dPile;

		while (current != null)
		{
			counter++;
			current = current.getNext();
		}
		return counter;
	}

	/**
	 * isEmpty method - determines whether or not the pile is empty
	 * 
	 * @return true if the pile is empty; false if the pile is not empty
	 */
	public boolean isEmpty()
	{
		return dPile == null;
	}

	/**
	 * toString method - returns a String representing the state of the pile
	 * 
	 * @return a string containing all items in the pile
	 */
	public String toString()
	{
		String str = "";
		Node current = dPile;
		int index = 1;
		while (current != null)
		{
			str += "Card " + index + ": " + current.getItem().toString() + "\n";
			current = current.getNext();
			index++;
		}
		return str;
	}
}
