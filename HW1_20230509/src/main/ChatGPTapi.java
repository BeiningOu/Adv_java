package main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

//build connection using http with CHATGPTapi
public class ChatGPTapi {
    public static void prompts() {
        try {
            URL url = new URL("https://api.openai.com/v1/completions");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type", "application/json");
            con.setRequestProperty("Accept", "application/json");
            con.setRequestProperty("OpenAI-Organization", "org-c0jSQ6qrdR0kU3vkBN2NOALd");
            con.setDoOutput(true);

            con.setRequestProperty("Authorization", "Bearer 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");
            String jsonInputString = "{\n" +
                    "  \"model\": \"text-davinci-003\",\n" +
                    "  \"prompt\": \"give me only one dialogue binary question from an adventure dialogue game.\",\n" +
                    "  \"max_tokens\": 64,\n" +
                    "  \"temperature\": 0.5\n" +
                    "}";

            try (OutputStream os = con.getOutputStream()) {
                byte[] input = jsonInputString.getBytes(StandardCharsets.UTF_8);
                os.write(input, 0, input.length);
            }
            int responseCode = con.getResponseCode();
            System.out.println("Response Code : " + responseCode);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            System.out.println(response);


} catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public static void main(String[] args) {
        prompts();
    }
}