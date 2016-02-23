package proj3fa15;

/**
 * <p>Title: Node Class</p>
 *
 * <p>Description: Defines a node class capable of storing a reference to a Card
 * object and a reference to the next node in a linked list. Accessor and
 * mutator methods are defined for both.</p>
 *
 * @author Saad Ahmad
 */

public class Node
{
	private Card item;
	private Node next;

	/**
	 * default constructor - initializes item and next to null
	 */

	public Node()
	{
		item = null;
		next = null;
	}

	/**
	 * parameterized constructor - initializes item to the user specified Card;
	 * next is set to null
	 * 
	 * @param aCard
	 *            the card to be stored in the node
	 */
	public Node(Card aCard)
	{
		item = aCard;
		next = null;
	}

	/**
	 * parameterized constructor - initializes data and next to user specified
	 * values
	 * 
	 * @param aCard
	 *            the Card reference to be stored in the node
	 * @param aNode
	 *            the reference to the next node in the list
	 */
	public Node(Card aCard, Node aNode)
	{
		item = aCard;
		next = aNode;
	}

	/**
	 * setItem - stores the address of a new Card in item
	 * 
	 * @param aCard
	 *            the object reference to be stored in the node
	 */
	public void setItem(Card aCard)
	{
		item = aCard;
	}

	/**
	 * setNext - stores the address of a new node in Next
	 * 
	 * @param aNode
	 *            the reference to be stored in next
	 */
	public void setNext(Node aNode)
	{
		next = aNode;
	}

	/**
	 * getItem - returns the reference stored in Item
	 * 
	 * @return a reference to the Card stored in the node
	 */
	public Card getItem()
	{
		return item;
	}

	/**
	 * getNext - returns the reference stored in next
	 * 
	 * @return the reference stored in next
	 */
	public Node getNext()
	{
		return next;
	}
}
