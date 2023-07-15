import dto.UserDTO;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends TestBase{

    UserDTO userDtoPositive = UserDTO.builder().email("michael_benin@hotmail.com")
            .password("Mb12345$").build();

    @Test
    public void loginTestPositive() {

        app.getHelperLogin().login(userDtoPositive, app.getWait());
        Assert.assertTrue(app.getHelperLogin().validateLoginSuccess());
    }

    @Test
    public void loginTestPasswordInput() {
        logger.info("start test loginTestPasswordInput");
        app.getHelperLogin().openLoginPage();
        app.getHelperLogin().enterEmailLogin(userDtoPositive);
        app.getHelperLogin().clickContinueLogin();
        Assert.assertTrue(app.getHelperLogin().validatePasswordInputEnable(app.getWait()));
    }
}