import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage extends BaseTest {
    private final SelenideElement usernameField = $("#username");
    private final SelenideElement passwordField = $("[name='password']");
    private final SelenideElement loginButton = $("button[type='submit']");

    public void openPage() {
        String URL = "http://qa-stand-login.inzhenerka.tech/login";
        Selenide.open(URL);
    }

    public void setUsername(String username) {
        usernameField.setValue(username);
    }

    public void setPassword(String password) {
        passwordField.setValue(password);
    }

    public void login() {
        loginButton.click();
    }

    public void checkLoginButtonExists() {
        loginButton.exists();
        loginButton.shouldHave(text("Войти"));
    }
}
