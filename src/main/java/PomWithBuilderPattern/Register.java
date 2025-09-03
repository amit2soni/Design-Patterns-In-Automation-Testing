package PomWithBuilderPattern;

public class Register {
    private final String username;
    private final String password;
    private final String confirmPassword;

    private Register(RegisterBuilder builder){
        this.username = builder.username;
        this.password = builder.password;
        this.confirmPassword = builder.confirmPassword;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public static class RegisterBuilder{
        private String username;
        private String password;
        private String confirmPassword;

        public RegisterBuilder setUsername(String username) {
            this.username = username;
            return this;
        }

        public RegisterBuilder setPassword(String password) {
            this.password = password;
            return this;
        }

        public RegisterBuilder setConfirmPassword(String confirmPassword) {
            this.confirmPassword = confirmPassword;
            return this;
        }

        public Register build(){
            return new Register(this);
        }
    }
}
