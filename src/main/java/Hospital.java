package main.java;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Hospital {

    private DecimalFormat df2 = new DecimalFormat("#.##");
    private String hospLocation;
    private List<Patients> patientsList;

    public Hospital(String hospLocation) {
        this.hospLocation = hospLocation;
        patientsList = new ArrayList<>();
    }
    public void addPatients(Patients patient){
        patientsList.add(patient);
    }

    public String getHospLocation(){
        return hospLocation;
    }

    public List<Patients> getPatientsList(){
        return patientsList;
    }

    //GetCountOfAllPatientsByDateRange
    public long getAllPatientsCountByRange(LocalDate startDate, LocalDate endDate){
       return this.getPatientsList().stream().filter(patients -> patients.isVisitedInRange(startDate,endDate)).count();
    }

    //GetCountOfLocalPatientsByDateRange

    public long getLocalPatientsCountByRange(LocalDate startDate, LocalDate endDate){
        return this.getPatientsList().stream().filter(patients -> patients.getPatientLocation().equalsIgnoreCase(hospLocation)
                && patients.isVisitedInRange(startDate,endDate)).count();
    }

    //GetAllOuterPatientsByDateRange

    public long getOuterPatientsCountByRange(LocalDate startDate, LocalDate endDate){
        return this.getPatientsList().stream().filter(patients -> !patients.getPatientLocation().equalsIgnoreCase(hospLocation)
                && patients.isVisitedInRange(startDate,endDate)).count();
    }

    //GetLocalPatientsPercentage

    public String getLocalPatientPercentage(LocalDate startDate, LocalDate endDate){
        double localPatientPercentage = (getLocalPatientsCountByRange(startDate, endDate)*100.0)
                /getAllPatientsCountByRange(startDate,endDate);
        return df2.format(localPatientPercentage);
    }

    //GetLocalPatientsPercentage

    public String getOuterPatientPercentage(LocalDate startDate, LocalDate endDate){
        double OuterPatientPercentage = (getOuterPatientsCountByRange(startDate, endDate)*100.0)
                /getAllPatientsCountByRange(startDate,endDate);
        return df2.format(OuterPatientPercentage);
    }






}
