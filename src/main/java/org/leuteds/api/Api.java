package org.leuteds.api;

import org.leuteds.model.Account;
import org.leuteds.model.AccountRegistrationPost;
import org.leuteds.model.DiscordAccountPost;
import org.leuteds.model.UpdateAccountPost;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

public class Api {
    private static String baseUrl = "http://localhost:8080";
    public static Account getAccount(String nickname) {
        RestTemplate restTemplate = new RestTemplate();
        String url = baseUrl + "/api/v1/user/" + nickname;

        ResponseEntity<Account> response = restTemplate.getForEntity(url, Account.class);

        return response.getBody();
    }

    public static Account getAccountById(String id) {
        RestTemplate restTemplate = new RestTemplate();
        String url = baseUrl + "/api/v1/user/discord_id/" + id;

        ResponseEntity<Account> response = restTemplate.getForEntity(url, Account.class);

        return response.getBody();
    }

    public static boolean checkLogin(String email, String password) {
        RestTemplate restTemplate = new RestTemplate();
        String url = baseUrl + "/api/v1/user/check_login?email="+email+"&password="+password;

        ResponseEntity<Boolean> response = restTemplate.getForEntity(url, Boolean.class);

        return response.getBody();
    }

    public static ResponseEntity<AccountRegistrationPost> registration(AccountRegistrationPost account) {
        String url = baseUrl + "/api/v1/user/registration";
        RestTemplate restTemplate = new RestTemplate();

        HttpEntity<AccountRegistrationPost> request = new HttpEntity<>(account);

        ResponseEntity<AccountRegistrationPost> response = restTemplate
                .exchange(url, HttpMethod.POST, request, AccountRegistrationPost.class);

        return response;
    }

    public static ResponseEntity<DiscordAccountPost> addDiscordAccount(DiscordAccountPost discordAccount, String email, String password) {
        String url = baseUrl + "/api/v1/user/add_discord_account?email="+email+"&password="+password;

        RestTemplate restTemplate = new RestTemplate();

        HttpEntity<DiscordAccountPost> request = new HttpEntity<>(discordAccount);

        ResponseEntity<DiscordAccountPost> response = restTemplate
                .exchange(url, HttpMethod.POST, request, DiscordAccountPost.class);

        return response;
    }

    public static ResponseEntity<UpdateAccountPost> updateAccount(UpdateAccountPost account, String nickname, String password) {
        String url = baseUrl + "/api/v1/user/update/"+nickname+"?password=" + password;
        RestTemplate restTemplate = new RestTemplate();

        HttpEntity<UpdateAccountPost> request = new HttpEntity<>(account);

        ResponseEntity<UpdateAccountPost> response = restTemplate
                .exchange(url, HttpMethod.PUT, request, UpdateAccountPost.class);

        return response;
    }

    public static void deleteAccount(String nickname, String password) {
        String url = baseUrl + "/api/v1/user/delete/"+nickname+"?password=" + password;
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(url, HttpMethod.DELETE);
    }
}
