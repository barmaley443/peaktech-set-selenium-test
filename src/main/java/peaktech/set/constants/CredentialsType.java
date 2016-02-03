package peaktech.set.constants;

public enum CredentialsType {

    VALID(new String[]{"valid", "correct"}),
    INVALID(new String[]{"invalid"});

    private String[] aliases;

    CredentialsType(String[] aliases) {
        this.aliases = aliases;
    }

    public static CredentialsType credentialsTypeForName(String credentialsType) throws IllegalArgumentException {
        for (CredentialsType ct : values()) {
            for (String alias : ct.aliases) {
                if (alias.equalsIgnoreCase(credentialsType)) {
                    return ct;
                }
            }
        }
        throw credentialsTypeNotFound(credentialsType);
    }

    private static IllegalArgumentException credentialsTypeNotFound(String ct) {
        return new IllegalArgumentException(("Invalid credentials type [" + ct + "]"));
    }
}
