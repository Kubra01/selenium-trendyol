package testcases;

import base.BaseTest;
import org.testng.annotations.Test;
import tr.com.trendyol.user.User;

public class SignInTest extends BaseTest {


    @Test
    //başarılı giriş için
    public void successfulSignIn(){
        User user = new User(driver);
        user.goesTo(signInPage);
        user.setsMailAddress();
        user.setsPassword();
    }

    @Test
    public void signInWithAnExistingAccount(){

    }

    @Test
    public void signInWithAnInvalidEmailAddress(){

    }

    @Test
    //7 karakterden az olan giriş için
    public void signInWithAnPasswordShorterThanSevenCharacters(){
        String password = signInPage.getPasswordShorterThanSevenCharacters();
        user.setsPassword(password);
    }

    @Test
    //15 karakter ile parola girişi için
    public void signInWithAnPasswordLongerThanFifteenCharacters(){
        String password = signInPage.getPasswordLongerThan15();
        user.setsPassword(password);
    }

    @Test
    //rakamsız şifre ile giriş yapması için
    public void signInWithAnPasswordWithoutDigits(){
        String password = signInPage.getPasswordWithoutDigits() ;
        user.setsPassword(password);
    }

    @Test
    //harfsiz giriş için
    public void signInWithAnPasswordWithoutLetters(){
        user.goesTo(signInPage);
        user.setsMailAddress();
        String password = signInPage.getPasswordWithoutLetter() ;
        user.setsPassword(password);

    }






}
