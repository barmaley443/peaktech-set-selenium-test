package peaktech.set;

public class Users {

    public static User createValidUser() {
        User user = new User("dan@sfdev.com", "qwerty");
        return user;
    }

    public static User createInvalidUser() {
        User user = new User("test", "test");
        return user;
    }
}
