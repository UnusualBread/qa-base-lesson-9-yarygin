import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class UserDetailsPage {

    private final SelenideElement helloUserCardTitle = $(".card-title.text-center.mb-4");

    private final SelenideElement logoutButton = $(byText("Выйти"));

    public void checkHelloUserTitleExists(String username) {
        helloUserCardTitle.should(exist);
        helloUserCardTitle.shouldHave(text("Привет, %s".formatted(username)));
    }

    public void logout() {
        logoutButton.click();
    }
}
