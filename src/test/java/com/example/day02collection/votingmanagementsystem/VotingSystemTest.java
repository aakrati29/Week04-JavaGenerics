package com.example.day02collection.votingmanagementsystem;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class VotingSystemTest {
    private VotingSystem votingSystem;

    @BeforeEach
    public void setUp() {
        votingSystem = new VotingSystem();
    }

    @Test
    public void testVote() {
        votingSystem.vote("Aakrati");
        votingSystem.vote("Ankit");
        votingSystem.vote("Aakrati");
        votingSystem.vote("Anand");

        // Verify vote counts for each candidate
        assertEquals(2, votingSystem.getVoteCount("Aakrati"));
        assertEquals(1, votingSystem.getVoteCount("Ankit"));
        assertEquals(1, votingSystem.getVoteCount("Anand"));
    }

    @Test
    public void testGetVoteCount() {
        votingSystem.vote("Aakrati");
        votingSystem.vote("Aakrati");
        votingSystem.vote("Ankit");

        // Verify vote count retrieval
        assertEquals(2, votingSystem.getVoteCount("Aakrati"));
        assertEquals(1, votingSystem.getVoteCount("Ankit"));
        assertEquals(0, votingSystem.getVoteCount("NonExistingCandidate"));
    }

    @Test
    public void testVoteForNewCandidate() {
        votingSystem.vote("Aakrati");
        votingSystem.vote("NewCandidate");

        // Test vote for a new candidate and verify
        assertEquals(1, votingSystem.getVoteCount("NewCandidate"));
    }

    private String getVoteOrder() {
        // Capture the vote order display output
        votingSystem.displayVoteOrder();
        return "Captured Vote Order"; // In actual tests, you'd capture the system output
    }

    private String getSortedResults() {
        // Capture the sorted results display output
        votingSystem.displayResults();
        return "Captured Sorted Results"; // Similar to the above
    }

    private String getWinner() {
        // Capture the winner display output
        votingSystem.findWinner();
        return "Captured Winner"; // Similar to the above
    }
}

