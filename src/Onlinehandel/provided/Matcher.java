package Onlinehandel.provided;

/**
 * a matcher interface.<br>
 * <br>
 * 
 * Matchers are used for filtering operations. In more formal terms a matcher is
 * a predicate, mapping an object to a boolean value. Implementing classes match
 * objects to some pattern.<br>
 * <br>
 * 
 * @ProgrammingProblem.Hint provided
 * 
 * @param <T>
 *        the type of the object to match
 */
public interface Matcher<T> {

	/**
	 * checks whether some object matches the pattern of this matcher.
	 * 
	 * @param t
	 *          the object to match
	 * @return true if t matches, false otherwise
	 */
	public abstract boolean matches(T t);

}
