package seedu.duke.common;

public class Appointment {

    protected String location;
    protected String date;
    protected String time;
    protected String purpose;

    public Appointment(String location, String date, String time, String purpose) {
        this.location = location;
        this.date = date;
        this.time = time;
        this.purpose = purpose;
    }

    public String getLocation() {
        return location;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getPurpose() {
        return purpose;
    }

    @Override
    public String toString() {
        return String.format("Location: %s, Date: %s, Time: %s, Purpose of Visit: %s", getLocation(), getDate(),
                getTime(), getPurpose());
    }
}
