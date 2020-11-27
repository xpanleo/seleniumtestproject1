package helpers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;

public class Utils {



    public static String formatDate(String pattern, LocalDate dateToFormat) throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(pattern);
        String dateFormatted = dtf.format(dateToFormat);
//        logger.info(dateFormatted);
        return dateFormatted;
    }


    public static String randomText() {

        final String lexicon = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        final java.util.Random rand = new java.util.Random();
        final Set<String> identifiers = new HashSet<String>();

        StringBuilder builder = new StringBuilder();
        while (builder.toString().length() == 0) {
            int length = 9;
            for (int i = 0; i < length; i++) {
                builder.append(lexicon.charAt(rand.nextInt(lexicon.length())));
            }
            if (identifiers.contains(builder.toString())) {
                builder = new StringBuilder();
            }
        }
        //logger.info("Random Text is: " + builder);
        return builder.toString();
    }


    public static LocalDate getSysDate() {
        LocalDate localDate = LocalDate.now();
        return localDate;
    }

}
