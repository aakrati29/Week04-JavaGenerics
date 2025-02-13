package com.example.day02collection.insurancepolicymanagement2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;
import static org.junit.jupiter.api.Assertions.*;

public class InsurancePolicyTest2 {
    private InsurancePolicyManagement2 policyManagement;
    private InsurancePolicy2 policy1;
    private InsurancePolicy2 policy2;
    private InsurancePolicy2 policy3;

    @BeforeEach
    public void setUp() {
        policyManagement = new InsurancePolicyManagement2();

        // Setting up test policies
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_YEAR, 10);
        policy1 = new InsurancePolicy2("P123", "Alice", cal.getTime(), "Health", 500.0);

        cal.add(Calendar.DAY_OF_YEAR, 25);
        policy2 = new InsurancePolicy2("P124", "Bob", cal.getTime(), "Auto", 700.0);

        cal.add(Calendar.DAY_OF_YEAR, -20);
        policy3 = new InsurancePolicy2("P125", "Carol", cal.getTime(), "Home", 900.0);
    }

    @Test
    public void testAddPolicy() {
        // Add policies to all sets
        policyManagement.addPolicy(policy1);
        policyManagement.addPolicy(policy2);
        policyManagement.addPolicy(policy3);

        // Verify the policies are added correctly
        assertTrue(policyManagement.hashSetPolicies.contains(policy1));
        assertTrue(policyManagement.linkedHashSetPolicies.contains(policy2));
        assertTrue(policyManagement.treeSetPolicies.contains(policy3));
    }

    @Test
    public void testGetPoliciesByCoverageType() {
        policyManagement.addPolicy(policy1);
        policyManagement.addPolicy(policy2);
        policyManagement.addPolicy(policy3);

        // Test filtering by coverage type
        Set<InsurancePolicy2> healthPolicies = policyManagement.getPoliciesByCoverageType("Health");
        assertTrue(healthPolicies.contains(policy1));
        assertFalse(healthPolicies.contains(policy2));
        assertFalse(healthPolicies.contains(policy3));

        Set<InsurancePolicy2> autoPolicies = policyManagement.getPoliciesByCoverageType("Auto");
        assertTrue(autoPolicies.contains(policy2));
        assertFalse(autoPolicies.contains(policy1));
        assertFalse(autoPolicies.contains(policy3));
    }

    @Test
    public void testAddPerformance() {
        // Performance test for adding policies
        policyManagement.comparePerformance();
    }

    @Test
    public void testEqualsAndHashCode() {
        // Create a duplicate policy with the same policy number
        InsurancePolicy2 policy4 = new InsurancePolicy2("P123", "Alice", new Date(), "Health", 500.0);

        // Verify that the equals and hashCode methods work correctly
        assertEquals(policy1, policy4);
        assertEquals(policy1.hashCode(), policy4.hashCode());
    }
}

