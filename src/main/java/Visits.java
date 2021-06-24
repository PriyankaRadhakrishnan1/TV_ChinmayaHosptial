package main.java;

import java.time.LocalDate;

public class Visits {

    private LocalDate date;

    public Visits(String dates) {
        this.date = LocalDate.parse(dates);
    }

    @Override
    public String toString() {
        return "main.java.AdmissionDates{" +
                "date=" + date +
                '}';
    }

    public LocalDate getDate() {
        return date;
    }
}
