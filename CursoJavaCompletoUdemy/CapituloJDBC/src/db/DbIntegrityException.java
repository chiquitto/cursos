package db;

/**
 *
 * @author Alisson Chiquitto <chiquitto@gmail.com>
 */
public class DbIntegrityException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public DbIntegrityException(String msg) {
		super(msg);
	}
}
