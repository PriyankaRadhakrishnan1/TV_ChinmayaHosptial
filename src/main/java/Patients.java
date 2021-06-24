package main.java;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Patients {
    private int patientId;
    private String patientName;
    private String location;
    private List<Visits> dateOfVisit;

    @Override
    public String toString() {
        return "main.java.Patients{" +
                "patientId=" + patientId +
                ", patientName='" + patientName + '\'' +
                ", location='" + location + '\'' +
                ", admissionDates=" + dateOfVisit +
                '}';
    }

    public Patients(int patientId, String patientName, String location) {
        dateOfVisit = new ArrayList<>();
        this.patientId = patientId;
        this.patientName = patientName;
        this.location = location;
    }

    public List<Visits> getAllVisits(){
        return dateOfVisit;
    }

    public String getPatientLocation() {
        return location;
    }

    //Add
    public List<Visits> addDateOfVisit(Visits admissionDate) {
        dateOfVisit.add(admissionDate);
        return dateOfVisit;
    }


    private List<LocalDate> dateOfVisits(){
        return getAllVisits().stream()
                .map(Visits::getDate).collect(Collectors.toList());
    }

    public boolean isVisitedInRange(LocalDate startDate, LocalDate endDate){
        List<LocalDate> localDates = dateOfVisits().stream().filter(date ->
                date.isAfter(startDate)&& date.isBefore(endDate)).collect(Collectors.toList());
        return localDates.size() > 0;
    }
}
