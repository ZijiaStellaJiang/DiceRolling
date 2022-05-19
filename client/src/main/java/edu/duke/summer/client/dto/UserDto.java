package edu.duke.summer.client.dto;

import edu.duke.summer.client.annotation.PasswordMatches;
import edu.duke.summer.client.annotation.ValidEmail;
import edu.duke.summer.client.database.SignUpGroup;

import javax.validation.constraints.NotNull;

@PasswordMatches(groups = {SignUpGroup.class})
public class UserDto {

    @NotNull
    @ValidEmail
    private String email;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    private String password;

    //if this is not for registration, just pass null
    private String matchingPassword;


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMatchingPassword() {
        return matchingPassword;
    }

    public void setMatchingPassword(String matchingPassword) {
        this.matchingPassword = matchingPassword;
    }
}
