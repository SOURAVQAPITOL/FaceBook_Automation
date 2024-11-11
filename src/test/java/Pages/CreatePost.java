package Pages;

import java.io.IOException;

import static BaseTest.BaseTest.*;


public class CreatePost{

    public static void main(String[] args) throws IOException {
        LoginPage loginPage = new LoginPage();
        loginPage.LoginToTheApp();
        loginPage.createAPost();
        logOut();
//        RegistrationPage registrationPage = new RegistrationPage();
//        registrationPage.createNewAccount();
    }
}
