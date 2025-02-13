package com.example.day02collection.insurancepolicymanagement;

import java.util.*;

public class InsurancePolicyManagement {
    private Set<InsurancePolicy> hashSetPolicies = new HashSet<>();
    private Set<InsurancePolicy> linkedHashSetPolicies = new LinkedHashSet<>();
    private Set<InsurancePolicy> treeSetPolicies = new TreeSet<>();
    private int numPolicies;

    // Add policy to all sets
    public void addPolicy(InsurancePolicy policy) {
        hashSetPolicies.add(policy);
        linkedHashSetPolicies.add(policy);
        treeSetPolicies.add(policy);
    }

    // Retrieve all unique policies
    public void displayPolicies(Set<InsurancePolicy> policies) {
        for (InsurancePolicy policy : policies) {
            System.out.println(policy);
        }
    }

    // Retrieve policies expiring in the next 30 days
    public Set<InsurancePolicy> getExpiringPolicies() {
        Set<InsurancePolicy> expiringPolicies = new TreeSet<>();
        Date today = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(today);
        calendar.add(Calendar.DAY_OF_YEAR, 30); // 30 days from today
        Date thirtyDaysLater = calendar.getTime();

        for (InsurancePolicy policy : treeSetPolicies) {
            if (!policy.getExpiryDate().after(thirtyDaysLater)) {
                expiringPolicies.add(policy);
            }
        }
        return expiringPolicies;
    }

    // Retrieve policies by coverage type
    public Set<InsurancePolicy> getPoliciesByCoverageType(String type) {
        Set<InsurancePolicy> filteredPolicies = new HashSet<>();
        for (InsurancePolicy policy : hashSetPolicies) {
            if (policy.getCoverageType().equalsIgnoreCase(type)) {
                filteredPolicies.add(policy);
            }
        }
        return filteredPolicies;
    }

    // Find duplicate policies based on policy number
    public Set<InsurancePolicy> getDuplicatePolicies() {
        Map<String, Integer> policyCount = new HashMap<>();
        Set<InsurancePolicy> duplicates = new HashSet<>();

        for (InsurancePolicy policy : hashSetPolicies) {
            policyCount.put(policy.getPolicyNumber(), policyCount.getOrDefault(policy.getPolicyNumber(), 0) + 1);
        }

        for (InsurancePolicy policy : hashSetPolicies) {
            if (policyCount.get(policy.getPolicyNumber()) > 1) {
                duplicates.add(policy);
            }
        }

        return duplicates;
    }

    // Performance comparison
    public void comparePerformance() {
        int numPolicies = 10000;
        List<InsurancePolicy> policies = new ArrayList<>();

        for (int i = 0; i < numPolicies; i++) {
            policies.add(new InsurancePolicy("P" + i, "Holder" + i, new Date(), "Health", 500.0 + i));
        }

        measurePerformance("HashSet", new HashSet<>(), policies);
        measurePerformance("LinkedHashSet", new LinkedHashSet<>(), policies);
        measurePerformance("TreeSet", new TreeSet<>(), policies);
    }

    private void measurePerformance(String setType, Set<InsurancePolicy> set, List<InsurancePolicy> policies) {
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
        InsurancePolicyManagement system = new InsurancePolicyManagement();

        // Sample policies
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_YEAR, 10);
        system.addPolicy(new InsurancePolicy("P123", "Alice", cal.getTime(), "Health", 500.0));

        cal.add(Calendar.DAY_OF_YEAR, 25);
        system.addPolicy(new InsurancePolicy("P124", "Bob", cal.getTime(), "Auto", 700.0));

        cal.add(Calendar.DAY_OF_YEAR, -20);
        system.addPolicy(new InsurancePolicy("P125", "Carol", cal.getTime(), "Home", 900.0));

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
