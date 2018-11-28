package cn.novedu.security;

public class PermissionException extends RuntimeException {
    public PermissionException(String message) {
        super(message);
    }

    public PermissionException() {
    }
}
