package by.bsac.domain.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class User {

    private String userName;

    private String userPassword;

    @Override
    public String toString() {
        return "User{" +
                "user_name='" + userName + '\'' +
                ", user_password= *****}";
    }
}
