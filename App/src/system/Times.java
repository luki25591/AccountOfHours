package system;

import java.time.LocalDate;

public class Times {
    private int hours;
    private int minutes;
    private LocalDate date;


    public Times(LocalDate createDate, int hours, int minutes){
        this.date = createDate;
        this.hours = hours;
        this.minutes = minutes;
    }
    public Times(int hours, int minutes){
        this.hours = hours;
        this.minutes = minutes;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public Integer minutes(){
        int count = ((hours*60) + minutes);
        return count;
    }

    @Override
    public String toString() {
        return "Data: " + date + ", minuty: " + minutes();
    }
}
