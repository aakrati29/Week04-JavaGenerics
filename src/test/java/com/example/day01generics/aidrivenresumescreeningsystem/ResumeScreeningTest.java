package com.example.day01generics.aidrivenresumescreeningsystem;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

class ResumeScreeningTest {

    @Test
    void testDataScientistToString() {
        DataScientist ds = new DataScientist("Aakrati", "Under Graduate", "85%", 4);
        assertEquals("Name : Aakrati, DegreeStatus : Under Graduate, HigherSecondaryPercent : 85%, NumberOfCertificate : 4", ds.toString());
    }

    @Test
    void testSoftwareEngineerToString() {
        SoftwareEngineer se = new SoftwareEngineer("Ram", "Post Graduate", "90%", 3);
        assertEquals("Name : Ram, DegreeStatus : Post Graduate, HigherSecondaryPercent : 90%, NumberOfCertificate : 3", se.toString());
    }

    @Test
    void testProductManagerToString() {
        ProductManager pm = new ProductManager("Avinash", "Post Graduate", "80%", 3);
        assertEquals("Name : Avinash, DegreeStatus : Post Graduate, HigherSecondaryPercent : 80%, NumberOfCertificate : 3", pm.toString());
    }

    @Test
    void testAddCandidateToResume() {
        Resume<DataScientist> resume = new Resume<>();
        DataScientist ds = new DataScientist("Ankit", "Post Graduate", "80%", 5);
        resume.addCandidate(ds);
        List<DataScientist> candidates = resume.getAllCandidates();
        assertEquals(1, candidates.size());
        assertEquals(ds, candidates.get(0));
    }

    @Test
    void testGetAllCandidates() {
        Resume<SoftwareEngineer> resume = new Resume<>();
        SoftwareEngineer se1 = new SoftwareEngineer("Ram", "Post Graduate", "90%", 3);
        SoftwareEngineer se2 = new SoftwareEngineer("Anand", "Under Graduate", "80%", 2);
        resume.addCandidate(se1);
        resume.addCandidate(se2);
        List<SoftwareEngineer> candidates = resume.getAllCandidates();
        assertEquals(2, candidates.size());
        assertEquals(se1, candidates.get(0));
        assertEquals(se2, candidates.get(1));
    }
}

