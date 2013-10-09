package de.weichand.inspire.opensearch.exception;

/**
 * @author Juergen Weichand
 */
public class OpenSearchException extends Exception {

	public OpenSearchException(String message) {
		super(message);
	}

	public OpenSearchException(String message, Throwable cause) {
		super(message, cause);
	}

	public OpenSearchException(Throwable cause) {
		super(cause);
	}
}
