import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailCrawler {
    public static void main(String[] args) {
        try {
            // Step 1: Fetch the content from the webpage
            Document doc = Jsoup.connect("https://ccis.ksu.edu.sa/en").get();
            String htmlContent = doc.toString();

            // Step 2: Define the regular expression for KSU emails
            String emailRegex = "[a-zA-Z0-9._%+-]+@ksu\\.edu\\.sa";
            Pattern emailPattern = Pattern.compile(emailRegex);
            Matcher emailMatcher = emailPattern.matcher(htmlContent);

            // Step 3: Initialize a counter for the number of emails found
            int emailCount = 0;

            // Step 4: Count the emails
            while (emailMatcher.find()) {
                emailCount++;
            }

            // Step 5: Print the total number of emails found
            System.out.println("Total KSU emails found: " + emailCount);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
