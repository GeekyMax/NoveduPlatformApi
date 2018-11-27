package cn.novedu.security;

/**
 * @author Max Huang
 */
public class ServiceException extends RuntimeException {
    public ServiceException(String message) {
        super(message);
    }

    public ServiceException() {
    }
}
