package seedu.duke.regex;

import java.util.regex.Pattern;

public class RegexChecker {

    public RegexChecker() {
    }

    public boolean isValidAddElderly(String userLine) {
        return Pattern.matches("^addelderly n/[a-z0-9]+$", userLine.toLowerCase());
    }

    public boolean isValidAddMedicine(String userLine) {
        return Pattern.matches("^addmed n/[a-z0-9]+ m/[a-z0-9\\s]+ f/[a-z0-9\\s]+$", userLine.toLowerCase());
    }

    public boolean isValidAddAppointment(String userLine) {
        boolean case1 = Pattern.matches("^addappt n/[a-z0-9]+ l/[a-z0-9\\s]+ d/[0-9]{8} t/[0-9]{4}$",
                userLine.toLowerCase());
        boolean case2 = Pattern.matches("^addappt n/[a-z0-9]+ l/[a-z0-9\\s]+ d/[0-9]{8} t/[0-9]{4} "
                        + "p/[a-z0-9\\s]+$", userLine.toLowerCase());
        return case1 || case2;
    }

    public boolean isValidViewMedicine(String userLine) {
        return Pattern.matches("^viewmed n/[a-z0-9]+$", userLine.toLowerCase());
    }

    public boolean isValidViewAppointment(String userLine) {
        return Pattern.matches("^viewappt n/[a-z0-9]+$", userLine.toLowerCase());
    }

    public boolean isValidAddNok(String userLine) {
        return Pattern.matches("^addnok n/[a-z0-9]+ k/[a-z0-9\\s]+ p/[0-9]{8}+ e/[A-Za-z0-9+_.-]+@(.+)+ "
                + "a/[a-z0-9\\s]+ r/[a-z0-9]+$", userLine.toLowerCase());
    }

    public boolean isValidViewNok(String userLine) {
        return Pattern.matches("^viewnok n/[a-z0-9]+$", userLine.toLowerCase());
    }

    public boolean isValidAddRecord(String userLine) {
        return Pattern.matches("^addrec n/[a-z0-9]+ p/[0-9]{8}+ a/[a-z0-9\\s]+$", userLine.toLowerCase());
    }

    public boolean isValidViewRec(String userLine) {
        return Pattern.matches("^viewrec n/[a-z0-9]+$", userLine.toLowerCase());
    }
}
