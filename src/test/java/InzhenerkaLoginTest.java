import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InzhenerkaLoginTest extends BaseTest {
    @Test
    @DisplayName("Проверка логина")
    void runLoginTest() {
        LoginPage loginPage = new LoginPage();
        loginPage.openPage();
        loginPage.setUsername("admin");
        loginPage.setPassword("admin123");
        loginPage.checkLoginButtonExists();
        loginPage.login();
        loginPage.logout();
    }
}