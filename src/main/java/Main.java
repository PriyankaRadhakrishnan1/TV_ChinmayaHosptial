package main.java;

import java.time.LocalDate;

public class Main {
  //  public static int patientID = 0;
    public static void main(String[] args){

        Hospital hospitalChinmaya = new Hospital("Bangalore");

        Patients p1 = new Patients(01, "Patient1", "Bangalore" );
        p1.addDateOfVisit(new Visits("2021-05-14"));
        p1.addDateOfVisit(new Visits("2021-06-15"));
        hospitalChinmaya.addPatients(p1);

        Patients p2 = new Patients(02, "Patient2", "Chennai");
        p2.addDateOfVisit(new Visits("2021-05-15"));
        hospitalChinmaya.addPatients(p2);

        Patients p3 = new Patients(03,"Patient3", "Bangalore");
        p3.addDateOfVisit(new Visits("2021-05-18"));
        hospitalChinmaya.addPatients(p3);

        Patients p4 = new Patients(04, "Patient4", "Mysore");
        p4.addDateOfVisit(new Visits("2021-05-21"));
        hospitalChinmaya.addPatients(p4);

        Patients p5 = new Patients(05, "Patient5", "Bangalore");
        p5.addDateOfVisit(new Visits("2021-05-19"));
        hospitalChinmaya.addPatients(p5);

        Patients p6 = new Patients(06, "Patient6", "Bangalore");
        p6.addDateOfVisit(new Visits("2021-05-16"));
        p6.addDateOfVisit(new Visits("2021-06-15"));
        hospitalChinmaya.addPatients(p6);


        Patients p7 = new Patients(07, "Patient7", "Chikmagalur");
        p7.addDateOfVisit(new Visits("2021-05-07"));
        hospitalChinmaya.addPatients(p7);

        System.out.println("From last 30 days "+ hospitalChinmaya
                .getAllPatientsCountByRange(LocalDate.parse("2021-05-01"),LocalDate.parse("2021-05-30"))
                +" OP registrations took place of which "+hospitalChinmaya
                .getLocalPatientPercentage(LocalDate.parse("2021-05-01"),LocalDate.parse("2021-05-30"))
                +"% are from bangalore and " +hospitalChinmaya
                .getOuterPatientPercentage(LocalDate.parse("2021-05-01"),LocalDate.parse("2021-05-30"))+"% are outstation");
    }

}
