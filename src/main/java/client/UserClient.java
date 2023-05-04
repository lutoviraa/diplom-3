package client;

import models.User;
import models.UserAccess;
import client.base.Client;
import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;

public class UserClient extends Client {
    private static final String USER = "api/auth/";
    @Step("Создание пользователя")
    public ValidatableResponse createUser(User user) {
        return given()
                .spec(getBaseSpec())
                .body(user)
                .when()
                .post(USER +  "register/")
                .then();
    }

    @Step("Логин пользователя")
    public ValidatableResponse loginUser(UserAccess userCredentials) {
        return given()
                .spec(getBaseSpec())
                .body(userCredentials)
                .when()
                .post(USER + "login/")
                .then();
    }

    @Step("Обновление данных пользователя")
    public ValidatableResponse updateUser(User user, String accessToken) {
        return given()
                .spec(getBaseSpec())
                .header("authorization", accessToken)
                .body(user)
                .when()
                .patch(USER + "user/")
                .then();
    }

    @Step("Удаление пользователя")
    public ValidatableResponse deleteUser(String accessToken) {
        return given()
                .spec(getBaseSpec())
                .header("authorization", accessToken)
                .when()
                .delete(USER + "user/")
                .then();
    }
}
