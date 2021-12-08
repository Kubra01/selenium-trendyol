package testcases;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import tr.com.trendyol.utilities.Constants;

public class LoginTest extends BaseTest {

    @Test
    public void successfulLogin(){

        user.setsMailAddress();
        user.setsPassword();
        user.clicksLoginButton();
        user.closesModalIfExist();
        Assert.assertEquals(homePage.getMailAddressUnderAccountButton(), user.getMailAddress() , Constants.notLoggedinProperly);
    }

    @Test
    //geçersiz parola ile oturumu açıp açmadığını görmek için
    public void failLoginWithInvalidPassword (){
        user.setsMailAddress();
        String password = logInPage.setInvalidPassword();
        user.setsPassword(password);
        user.clicksLoginButton();

    }

    @Test
   // yanlış email ile oturumu açıp açmadığını görmek için
    public void failLoginWithInvalidMailAddress() {
        String mailAddress = logInPage.setInvalidEmailAdress();
        user.setsMailAddress(mailAddress);
        user.setsPassword();
        user.clicksLoginButton();
    }

    @Test
    //geçersiz emaille ile oturumu açıp açmadığını görmek için
    public void failLoginWithInvalidFormatMailAddress()  {
        user.goesTo(logInPage);
        String mailAddress = logInPage.setInvalidFormattedEmailAdress();
        user.setsMailAddress(mailAddress);
        user.setsPassword();
        user.clicksLoginButton();
    }


}
