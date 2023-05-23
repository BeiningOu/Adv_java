package main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.List;


//build connection using http with CHATGPTapi
public class ChatGPTapi {




    public static String prompts(String userInput, String lastQ) {
        try {

            String extractedDialogue = extractTextFromContent("/src/main/prompts_to_start.txt");
//            String lastQ = extractTextFromContent("/src/main/last_question.txt");

            String promptToAI = (extractedDialogue + lastQ).replace("\n", "");

            System.out.println(promptToAI);

            URL url = new URL("https://api.openai.com/v1/completions");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type", "application/json");
            con.setRequestProperty("Accept", "application/json");
            con.setRequestProperty("OpenAI-Organization", "");
            con.setDoOutput(true);

            con.setRequestProperty("Authorization", "");
            String jsonInputString = "{\n" +
                    "  \"model\": \"text-davinci-003\",\n" +
                    "  \"prompt\": \"" +promptToAI+  "\",\n" +
                    "  \"max_tokens\": 40,\n" +
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

            String responseString = response.toString();

            int startIndex = responseString.indexOf("\"text\":\"") + 9;
            int endIndex = responseString.indexOf("\"index\":0", startIndex);

            String extractedText = responseString.substring(startIndex, endIndex - 2).replace("\\n","");

            System.out.println("Print out response text:"+ extractedText);


            // Call the writeToFile method to write extractedText to a file


            FileHelper.writeToFile("The last question was:"+ extractedText + ".Then I chose" + userInput + " Base on" + userInput + "give me one following context and question");
            System.out.println("Extracted text successfully written to the file.");

            System.out.println(response);


            return extractedText;


} catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }


    private static String extractTextFromContent(String path) throws FileHelper.FileReadException {

        String currentPath = Paths.get("").toAbsolutePath().toString();
        // Build the file path by appending the relative path to the current directory
        String filePath = currentPath + path;

        return FileHelper.readFileAsString(filePath).replace("\n", "");
    }




//    public static void main(String[] args) {
//        prompts("1");
//    }
}