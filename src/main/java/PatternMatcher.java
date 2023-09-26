import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatcher {
    public static void main(String[] args) {
        String pattern = "\\d+"; // Matches one or more digits
        String resumesCount = "MY RESUMES (2/5)";

        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(resumesCount);

        matcher.find();
        int resumeCount = Integer.parseInt(matcher.group());
        System.out.println(resumeCount);
    }
}