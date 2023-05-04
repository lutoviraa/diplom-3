package models;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class UserAccess {


    private String email;
    private String password;

    public UserAccess(String email, String password) {
        this.email = email;
        this.password = password;
    }
//myObjectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);

    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }
    public static UserAccess from(User user) {
        return new UserAccess(user.getEmail(), user.getPassword());
    }
    @Override
    public String toString() {
        return "UserCredentials{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

