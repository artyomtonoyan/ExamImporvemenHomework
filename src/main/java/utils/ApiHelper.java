package utils;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import okhttp3.*;

import java.io.IOException;
import java.util.Objects;
import java.util.UUID;

public class ApiHelper {

    private final static String GENERATED_USERNAME = UUID.randomUUID().toString();
    private static final String GENERATED_EMAIL = UUID.randomUUID().toString() + "gmail.com";
    private static final String PASSWORD = "ArtyomTest12.";
    private static final String FULL_NAME = "Artyom Tonoyan";

    public static JsonObject login(String username, String password) throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "{\"username\":\"" + username + "\",\"password\":\"" + password + "\",\"type\":\"normal\"}");
        Request request = new Request.Builder()
                .url("https://api.taiga.io/api/v1/auth")
                .method("POST", body)
                .addHeader("Connection", "keep-alive")
                .addHeader("sec-ch-ua", "\" Not;A Brand\";v=\"99\", \"Google Chrome\";v=\"91\", \"Chromium\";v=\"91\"")
                .addHeader("Accept", "application/json, text/plain, */*")
                .addHeader("X-Session-Id", "e393f5e22b354443ce531d183441a30eb2d9bdd9")
                .addHeader("Accept-Language", "en")
                .addHeader("sec-ch-ua-mobile", "?1")
                .addHeader("User-Agent", "Mozilla/5.0 (Linux; Android 6.0; Nexus 5 Build/MRA58N) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.77 Mobile Safari/537.36")
                .addHeader("Content-Type", "application/json")
                .addHeader("Origin", "https://tree.taiga.io")
                .addHeader("Sec-Fetch-Site", "same-site")
                .addHeader("Sec-Fetch-Mode", "cors")
                .addHeader("Sec-Fetch-Dest", "empty")
                .addHeader("Referer", "https://tree.taiga.io/")
                .build();
        Response response = client.newCall(request).execute();
        String json = Objects.requireNonNull(response.body()).string();
        return JsonParser.parseString(json).getAsJsonObject();
    }

    public static void signUp() throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "{\"accepted_terms\":true,\"username\":\"" + GENERATED_USERNAME + "\",\"full_name\":\"" + FULL_NAME + "\",\"email\":\"" + GENERATED_EMAIL + "\",\"password\":\"" + PASSWORD + "\",\"type\":\"public\"}");
        Request request = new Request.Builder()
                .url("https://api.taiga.io/api/v1/auth/register")
                .method("POST", body)
                .addHeader("Host", "api.taiga.io")
                .addHeader("sec-ch-ua", "\" Not;A Brand\";v=\"99\", \"Google Chrome\";v=\"91\", \"Chromium\";v=\"91\"")
                .addHeader("Accept", "application/json, text/plain, */*")
                .addHeader("X-Session-Id", "abdaabdf552d50720282ea57b6b8c6af85c95f0b")
                .addHeader("Accept-Language", "en")
                .addHeader("sec-ch-ua-mobile", "?0")
                .addHeader("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.77 Safari/537.36")
                .addHeader("Content-Type", "application/json")
                .addHeader("Origin", "https://tree.taiga.io")
                .addHeader("Sec-Fetch-Site", "same-site")
                .addHeader("Sec-Fetch-Mode", "cors")
                .addHeader("Sec-Fetch-Dest", "empty")
                .addHeader("Referer", "https://tree.taiga.io/")
                .addHeader("Pragma", "no-cache")
                .addHeader("Cache-Control", "no-cache")
                .build();
        Response response = client.newCall(request).execute();
        String json = Objects.requireNonNull(response.body()).string();
        System.out.println(json);
    }

    public static void main(String[] args) throws IOException {
        signUp(); // It doesn't work for random email, works for real email
    }
}