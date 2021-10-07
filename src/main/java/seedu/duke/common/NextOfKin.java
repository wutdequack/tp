package seedu.duke.common;

public class NextOfKin {

    protected String nokName;
    protected String nokPhoneNumber;
    protected String nokEmail;
    protected String nokAddress;
    protected String nokRelationship;

    public NextOfKin(String nokName, String nokPhoneNumber, String nokEmail, String nokAddress,
                     String nokRelationship) {
        this.nokName = nokName;
        this.nokPhoneNumber = nokPhoneNumber;
        this.nokEmail = nokEmail;
        this.nokAddress = nokAddress;
        this.nokRelationship = nokRelationship;
    }

    public String getNokName() {
        return nokName;
    }

    public String getNokPhoneNumber() {
        return nokPhoneNumber;
    }

    public String getNokEmail() {
        return nokEmail;
    }

    public String getNokAddress() {
        return nokAddress;
    }

    public String getNokRelationship() {
        return nokPhoneNumber;
    }

    @Override
    public String toString() {
        return String.format("%s, %s, %s, %s, %s", getNokName(), getNokPhoneNumber(), getNokEmail(),
                getNokAddress(), getNokRelationship());
    }

}
