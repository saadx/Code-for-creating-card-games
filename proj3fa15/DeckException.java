package proj3fa15;

/**
 * <p>Title: The DeckException class</p>
 *
 * <p>Description: This class holds the DeckException constructor. </p>
 *
 * @author Saad Ahmad
 */

@SuppressWarnings("serial")
public class DeckException extends RuntimeException
{
	/**
	 * Default constructor -- calls the parameterized constructor in its parent
	 * class to initialize a DeckException object.
	 * 
	 * @param ex
	 *            the message sent by the method call
	 */
	public DeckException(String ex)
	{
		super(ex);
	}
}
