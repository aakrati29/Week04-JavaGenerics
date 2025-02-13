package com.example.day02collection.insurancepolicymanagement2;

import java.util.*;

public class InsurancePolicyManagement2 {
    private Set<InsurancePolicy2> hashSetPolicies = new HashSet<>();
    private Set<InsurancePolicy2> linkedHashSetPolicies = new LinkedHashSet<>();
    private Set<InsurancePolicy2> treeSetPolicies = new TreeSet<>();
    private int numPolicies;

    // Add policy to all sets
    public void addPolicy(InsurancePolicy2 policy) {
        hashSetPolicies.add(policy);
        linkedHashSetPolicies.add(policy);
        treeSetPolicies.add(policy);
    }

    // Retrieve all unique policies
    public void displayPolicies(Set<InsurancePolicy2> policies) {
        for (InsurancePolicy2 policy : policies) {
            System.out.println(policy);
        }
    }

    // Retrieve policies expiring in the next 30 days
    public Set<InsurancePolicy2> getExpiringPolicies() {
        Set<InsurancePolicy2> expiringPolicies = new TreeSet<>();
        Date today = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(today);
        calendar.add(Calendar.DAY_OF_YEAR, 30); // 30 days from today
        Date thirtyDaysLater = calendar.getTime();

        for (InsurancePolicy2 policy : treeSetPolicies) {
            if (!policy.getExpiryDate().after(thirtyDaysLater)) {
                expiringPolicies.add(policy);
            }
        }
        return expiringPolicies;
    }

    // Retrieve policies by coverage type
    public Set<InsurancePolicy2> getPoliciesByCoverageType(String type) {
        Set<InsurancePolicy2> filteredPolicies = new HashSet<>();
        for (InsurancePolicy2 policy : hashSetPolicies) {
            if (policy.getCoverageType().equalsIgnoreCase(type)) {
                filteredPolicies.add(policy);
            }
        }
        return filteredPolicies;
    }

    // Find duplicate policies based on policy number
    public Set<InsurancePolicy2> getDuplicatePolicies() {
        Map<String, Integer> policyCount = new HashMap<>();
        Set<InsurancePolicy2> duplicates = new HashSet<>();

        for (InsurancePolicy2 policy : hashSetPolicies) {
            policyCount.put(policy.getPolicyNumber(), policyCount.getOrDefault(policy.getPolicyNumber(), 0) + 1);
        }

        for (InsurancePolicy2 policy : hashSetPolicies) {
            if (policyCount.get(policy.getPolicyNumber()) > 1) {
                duplicates.add(policy);
            }
        }

        return duplicates;
    }

    // Performance comparison
    public void comparePerformance() {
        int numPolicies = 10000;
        List<InsurancePolicy2> policies = new ArrayList<>();

        for (int i = 0; i < numPolicies; i++) {
            policies.add(new InsurancePolicy2("P" + i, "Holder" + i, new Date(), "Health", 500.0 + i));
        }

        measurePerformance("HashSet", new HashSet<>(), policies);
        measurePerformance("LinkedHashSet", new LinkedHashSet<>(), policies);
        measurePerformance("TreeSet", new TreeSet<>(), policies);
    }

    private void measurePerformance(String setType, Set<InsurancePolicy2> set, List<InsurancePolicy2> policies) {
        long startTime = System.nanoTime();
        set.addAll(policies);
        long addTime = System.nanoTime() - startTime;

        startTime = System.nanoTime();
        set.contains(policies.get(numPolicies / 2));
        long searchTime = System.nanoTime() - startTime;

        startTime = System.nanoTime();
        set.remove(policies.get(numPolicies / 2));
        long removeTime = System.nanoTime() - startTime;

        System.out.println(setType + " - Add: " + addTime / 1_000_000.0 + " ms, Search: " + searchTime / 1_000_000.0 + " ms, Remove: " + removeTime / 1_000_000.0 + " ms");
    }

    public static void main(String[] args) {
        InsurancePolicyManagement2 system = new InsurancePolicyManagement2();

        // Sample policies
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_YEAR, 10);
        system.addPolicy(new InsurancePolicy2("P123", "Alice", cal.getTime(), "Health", 500.0));

        cal.add(Calendar.DAY_OF_YEAR, 25);
        system.addPolicy(new InsurancePolicy2("P124", "Bob", cal.getTime(), "Auto", 700.0));

        cal.add(Calendar.DAY_OF_YEAR, -20);
        system.addPolicy(new InsurancePolicy2("P125", "Carol", cal.getTime(), "Home", 900.0));

        // Display all policies
        System.out.println("All Policies:");
        system.displayPolicies(system.hashSetPolicies);

        // Policies expiring soon
        System.out.println("\nExpiring Soon:");
        system.displayPolicies(system.getExpiringPolicies());

        // Policies by coverage type
        System.out.println("\nHealth Policies:");
        system.displayPolicies(system.getPoliciesByCoverageType("Health"));

        // Duplicate policies
        System.out.println("\nDuplicate Policies:");
        system.displayPolicies(system.getDuplicatePolicies());

        // Performance Comparison
        System.out.println("\nPerformance Comparison:");
        system.comparePerformance();
    }
}


