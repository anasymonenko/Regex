import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HW_Regex {

    public static final String EMAIL_PATTERN = "[A-Za-z0-9.\\-_]{3,25}@[A-Za-z]{3,5}\\.[A-Za-z]{3,}";
    public static final String IP_ADDRESS_PATTERN = "\\d{3}\\.\\d{3}\\.\\d{1,3}\\.\\d{1,3}";
    public static final String BANK_CARD_TEMPLATE = "(\\d{16}|\\d{4}\\s\\d{4}\\s\\d{4}\\s\\d{4})";

    public static String emailExample = "Anastasiia_Symonenko@epam.com";
    public static String ipAddressExample = "192.168.0.101";
    public static String bankCardExample = "4441 1111 2222 5555";

    //Task 1: Implement boolean method to validate whether String matches regular expression1.
    // Implement boolean method to validate whether String matches regular expression

    public static boolean matchStringByRegex(String text, String pattern) {
        return text.matches(pattern);
    }

    public static void main(String[] args) {
        //Task 2: Write regular expression to validate e-mail, IP, bank card

        System.out.println("Is email matching a regular expression? - " +
                matchStringByRegex(emailExample, EMAIL_PATTERN));

        System.out.println("Is IP Address matching a regular expression? - " +
                matchStringByRegex(ipAddressExample, IP_ADDRESS_PATTERN));

        System.out.println("Is Bank Card matching a regular expression? - " +
                matchStringByRegex(bankCardExample, BANK_CARD_TEMPLATE));

        String url = "https://www.epam.com/about/who-we-are/contact";

        List<String> listMatches = getAllMatchesAsList(url);

        System.out.println("Total number of matches: " + listMatches.size());
        System.out.println("ArrayList of all Regex matches: " + listMatches);
    }

    //Task 4: Get Epam address elements as text (https://www.epam.com/about/who-we-are/contact) using regex

    private static List<String> getAllMatchesAsList(String str) {

        List<String> listMatches = new ArrayList<>();

        Pattern pattern = Pattern.compile("([\\w.-]+)");
        Matcher matcher = pattern.matcher(str);

        while( matcher.find() ) {
        listMatches.add( matcher.group() );
        }
        return listMatches;
    }
}



