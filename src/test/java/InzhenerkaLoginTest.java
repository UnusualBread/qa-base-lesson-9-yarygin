import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InzhenerkaLoginTest extends BaseTest {

    @Test
    @DisplayName("Проверка логина")
    void runLoginTest() {
        String username = "admin";
        String password = "admin123";

        LoginPage loginPage = new LoginPage();
        loginPage.openPage();
        loginPage.setUsername(username);
        loginPage.setPassword(password);
        loginPage.checkLoginButtonExists();
        loginPage.login();

        UserDetailsPage userDetailsPage = new UserDetailsPage();
        userDetailsPage.checkHelloUserTitleExists(username);
        userDetailsPage.logout();
    }
}