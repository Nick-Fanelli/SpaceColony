package world;

public class TimeSystem {

    public enum Month {
        January(31),
        February(28),
        March(31),
        April(30),
        May(31),
        June(30),
        July(31),
        August(31),
        September(30),
        October(31),
        November(30),
        December(31);

        public final int dayCount;

        Month(int dayCount) {
            this.dayCount = dayCount;
        }
    }

    public Month month = Month.October;
    public int day = 20;
    public int year = 2342;

    public TimeSystem() {}

    public TimeSystem(Month month, int day, int year) {
        this.month = month;
        this.day = day;
        this.year = year;
    }

//    public void nextDay() {
//
//        this.day++;
//
//        if(this.day > this.month.dayCount) {
//            this.day = 1;
//
//        }
//
//    }

    public void nextYear() {
        this.year++;
    }

    public String getFormattedDate() {
        return String.format("%s %d, %d", month.name(), day, year);
    }

}
