package proj3fa15;

/**
 * <p>Title: The DeckException class</p>
 *
 * <p>Description: This class holds the DiscardPileException constructor. </p>
 *
 * @author Saad Ahmad
 */

@SuppressWarnings("serial")
public class DiscardPileException extends RuntimeException
{
	/**
	 * Default constructor -- calls the parameterized constructor in its parent
	 * class to initialize a DiscardPileException object.
	 * 
	 * @param ex
	 *            the message sent by the method call
	 */
	public DiscardPileException(String ex)
	{
		super(ex);
	}
}
