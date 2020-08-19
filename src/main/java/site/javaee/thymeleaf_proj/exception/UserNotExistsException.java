package site.javaee.thymeleaf_proj.exception;

/**
 * @author Tao
 * @create 2020/4/15 19:45
 */
public class UserNotExistsException extends RuntimeException {
    public UserNotExistsException() {
        super("用户不存在");
    }
}
