package org.leuteds.api;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.leuteds.model.AccountRegistrationPost;
import org.leuteds.model.DiscordAccountPost;
import org.leuteds.model.UpdateAccountPost;

import static org.junit.jupiter.api.Assertions.*;

class ApiTest {
    @BeforeAll
    public static void registrationTest() {
        System.out.println(
                Api.registration(
                        new AccountRegistrationPost(
                                "testuser",
                                "testuser",
                                "I am a test user",
                                "test.test@test.com",
                                "test"
                        )
                )
        );
    }

    @Test
    public void getUserTest() {
        System.out.println(
                Api.getAccount("testuser").toString()
        );
    }

    @Test
    public void chekLogin() {
        System.out.println(
                Api.checkLogin("test.test@test.com", "test")
        );
    }

    @Test
    public void addDiscordAccount() {
        System.out.println(
                Api.addDiscordAccount(
                        new DiscordAccountPost(
                                "testuser",
                                "test",
                                "I am a test user",
                                "0000",
                                "https://google.com"
                        ),
                        "test.test@test.com",
                        "test"
                )
        );
    }

    @Test
    public void getUserById() {
        System.out.println(
                Api.getAccountById("0000").toString()
        );
    }

    @Test
    public void update() {
        System.out.println(
                Api.updateAccount(
                        new UpdateAccountPost(
                                "Im test user",
                                null
                        ),
                        "testuser",
                        "test"
                )
        );

        System.out.println(
                Api.updateAccount(
                        new UpdateAccountPost(
                                null,
                                "Tester name"
                        ),
                        "testuser",
                        "test"
                )
        );

        System.out.println(
                Api.updateAccount(
                        new UpdateAccountPost(
                                "Im... I am a test user); DROP TABLE account;",
                                "Tester name"
                        ),
                        "testuser",
                        "test"
                )
        );
    }

    @AfterAll
    public static void deleteAccout() {
        Api.deleteAccount("testuser", "test");
    }
}