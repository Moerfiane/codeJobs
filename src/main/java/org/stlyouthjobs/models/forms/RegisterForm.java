package org.stlyouthjobs.models.forms;

import javax.validation.constraints.NotNull;

/**
 * Created by LaunchCode
 */
public class RegisterForm extends LoginForm {

    @NotNull(message = "Passwords to not match")
    private String verifyPassword;

    public RegisterForm(){

    }

    @Override
    public void setPassword(String password) {
        super.setPassword(password);
        checkPasswordForRegistration();
    }
//    @Override
//    public void setAccess(String access){
//        super.setAccess(access);
//    }

    public String getVerifyPassword() {
        return verifyPassword;
    }

    public void setVerifyPassword(String verifyPassword) {
        this.verifyPassword = verifyPassword;
        checkPasswordForRegistration();
    }

    private void checkPasswordForRegistration() {
        if (!getPassword().equals(verifyPassword)) {
            verifyPassword = null;
        }
    }





}
