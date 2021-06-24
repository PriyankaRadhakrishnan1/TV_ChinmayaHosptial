package test.java;

import main.java.Visits;
import main.java.Hospital;
import main.java.Patients;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.util.List;

public class ChinmayaTest {
    Hospital hospitalChinmaya;
    Patients p1, p2, p3, p4, p5, p6;

    @BeforeClass
    public void createEntries(){
        hospitalChinmaya = new Hospital("Bangalore");

        p1 = new Patients(01, "Patient1", "Bangalore" );
        p1.addDateOfVisit(new Visits("2021-05-14"));
        p1.addDateOfVisit(new Visits("2021-06-15"));
        hospitalChinmaya.addPatients(p1);

        p2 = new Patients(02, "Patient2", "Chennai");
        p2.addDateOfVisit(new Visits("2021-05-15"));
        hospitalChinmaya.addPatients(p2);

        p3 = new Patients(03,"Patient3", "Bangalore");
        p3.addDateOfVisit(new Visits("2021-05-18"));
        hospitalChinmaya.addPatients(p3);

        p4 = new Patients(04, "Patient4", "Mysore");
        p4.addDateOfVisit(new Visits("2021-05-21"));
        hospitalChinmaya.addPatients(p4);

        p5 = new Patients(05, "Patient5", "Bangalore");
        p5.addDateOfVisit(new Visits("2021-05-19"));
        hospitalChinmaya.addPatients(p5);

        p6 = new Patients(06, "Patient6", "Bangalore");
        p6.addDateOfVisit(new Visits("2021-05-16"));
        p6.addDateOfVisit(new Visits("2021-06-15"));
        hospitalChinmaya.addPatients(p6);

    }

    @Test
    void Test001_All_Patients(){
        List<Patients> patientsList = hospitalChinmaya.getPatientsList();
        Assert.assertEquals(patientsList.size(), 6);
        Reporter.log("Total admitted patients count is 6", true);
    }

    @Test
    void Test002_All_Patients_Count_UnExpected(){
        List<Patients> patientsList = hospitalChinmaya.getPatientsList();
        Assert.assertNotEquals(patientsList.size(), 5);
        Reporter.log("Total admitted patients count is "+hospitalChinmaya.getPatientsList().size()
                +". But expected value is 5", true);
    }

    @Test
    void Test003_All_Local_Patients_Count(){
        List<Patients> patientsList = hospitalChinmaya.getPatientsList();
        long count = patientsList.stream().filter(patients -> patients
                .getPatientLocation().equalsIgnoreCase(hospitalChinmaya.getHospLocation())).count();
        Assert.assertEquals(count,4);
        Reporter.log("Total local admitted patients count is 4", true);
    }

    @Test
    void Test004_All_Outer_Patients_Count(){
        List<Patients> patientsList = hospitalChinmaya.getPatientsList();
        long count = patientsList.stream().filter(patients -> !patients
                .getPatientLocation().equalsIgnoreCase(hospitalChinmaya.getHospLocation())).count();
        Assert.assertEquals(count,2);
        Reporter.log("Total local admitted patients count is 2", true);
    }

    @Test
    void Test005_Verify_Patient_Location(){
        Boolean isLocalPatient = p4.getPatientLocation().equalsIgnoreCase("Bangalore");
        Assert.assertEquals(java.util.Optional.of(isLocalPatient), java.util.Optional.of(false));
        Reporter.log("Patients is not from hospital location",true);
    }

    @Test
    void Test006_All_Outer_Patients_Count_ByRange(){
        long count =  hospitalChinmaya.getOuterPatientsCountByRange(LocalDate.parse("2021-05-14"),
                LocalDate.parse("2021-06-14"));
        Assert.assertEquals(count,2);
        Reporter.log("Total outer admitted patients count by range is "+count, true);
    }

    @Test
    void Test007_All_Local_Patients_Count_ByRange(){
        long count =  hospitalChinmaya.getLocalPatientsCountByRange(LocalDate.parse("2021-05-14"),
                LocalDate.parse("2021-06-14"));
        Assert.assertEquals(count,3);
        Reporter.log("Total outer admitted patients count by range is "+count, true);

    }

   @Test
    void Test008_Local_Patient_Percentage_ByRange(){
        Assert.assertEquals(hospitalChinmaya.getLocalPatientPercentage(LocalDate.parse("2021-05-01"),
                LocalDate.parse("2021-05-30")),"66.67");
        Reporter.log("Total percentage of local patients by range is "+hospitalChinmaya.
                getLocalPatientPercentage(LocalDate.parse("2021-05-01"),LocalDate.parse("2021-05-30")),
                true);
    }

    @Test
    void Test009_Outer_Patient_Percentage_ByRange(){
        Assert.assertEquals(hospitalChinmaya.getOuterPatientPercentage(LocalDate.parse("2021-05-01"),
                LocalDate.parse("2021-05-30")),"33.33");
        Reporter.log("Total percentage of local patients by range is "+hospitalChinmaya.
                getOuterPatientPercentage(LocalDate.parse("2021-05-01"),LocalDate.parse("2021-05-30")),
                true);

    }
}
