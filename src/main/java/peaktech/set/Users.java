package peaktech.set;

public class Users {
    public static User createValidUser() {
        User user = new User();
        user.withUserName("dan@sfdev.com").withPassword("qwerty");
        return user;
    }

    public static User createInvalidUser() {
        User user = new User();
        user.withUserName("test").withPassword("test");
        return user;
    }
}
