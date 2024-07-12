import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WineVersionPatternTest {
    public static void main(String[] args) {
        String testString = "wine-8.0-2786-g3061bb04122 (Staging)";

        // Compile the pattern
        Pattern pattern = Pattern.compile("^wine\\-([0-9\\.]+)\\-?([0-9\\.]+)?", Pattern.CASE_INSENSITIVE);

        // Create a matcher for the given string
        Matcher matcher = pattern.matcher(testString);

        // Check if the pattern matches
        if (matcher.find()) {
            // Extract the version and subversion
            String version = matcher.group(1);
            String subversion = matcher.groupCount() >= 2 ? matcher.group(2) : null;

            // Print the results
            System.out.println("Version: " + version);
            if (subversion != null) {
                System.out.println("Subversion: " + subversion);
            } else {
                System.out.println("Subversion: not present");
            }
        } else {
            System.out.println("No match found.");
        }
    }
}

