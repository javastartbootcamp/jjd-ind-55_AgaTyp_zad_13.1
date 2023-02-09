package pl.javastart.voting;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;

/**
 * Możesz dodać kolejne metody i pola do klasy. Nie zmieniaj istniejących metod.
 */
public class VotingResult {
    private int maxVotes = 10;
    private Vote[] votes = new Vote[maxVotes];
    private int votesNo = 0;

    void add(Vote vote) {
        if (votesNo >= votes.length) {
            votes =  Arrays.copyOf(votes, votes.length * 2);
        }
        if (votesNo < votes.length) {
            votes[votesNo] = vote;
            votesNo++;
        }
    }

    /**
     * Metoda powinna drukować wyniki głosowania w takiej postaci:
     * Głosów za: 56.53%
     * Głosów przeciw: 35.00%
     * Wstrzymało się: 8.47%
     */
    public void printResults() {
        // metoda powinna drukować wyniki głosowania

        int votesFor = 0;
        int votesAgainst = 0;
        int nonVoting = 0;

        for (int i = 0; i < votesNo; i++) {
            try {
                if (votes[i].getVote()) {
                    votesFor++;
                } else {
                    votesAgainst++;
                }
            } catch (NullPointerException e) {
                nonVoting++;
            }

        }
        BigDecimal votesForPercent = BigDecimal.valueOf(votesFor * 100).divide(BigDecimal.valueOf(votesNo), 2, RoundingMode.HALF_DOWN);
        BigDecimal votesAgainstPercent = BigDecimal.valueOf(votesAgainst * 100).divide(BigDecimal.valueOf(votesNo), 2, RoundingMode.HALF_DOWN);
        BigDecimal nonVotingPercent = BigDecimal.valueOf(nonVoting * 100).divide(BigDecimal.valueOf(votesNo), 2, RoundingMode.HALF_DOWN);

        System.out.printf("Głosów za: %s%%\n", votesForPercent);
        System.out.printf("Głosów przeciw: %s%%\n", votesAgainstPercent);
        System.out.printf("Wstrzymało się: %s%%\n", nonVotingPercent);
    }

    /**
     * Metoda przyjmuje imię i nazwisko głosującego, np "Zigniew Siobro".
     * Uzupełnij tę metodę, żeby drukowała informację w formie:
     * Zigniew Siobro: ZA
     * Nie zmieniaj sygnatury tej metody!
     */
    public void printVoteForVoter(String voterName) {

        for (int i = 0; i < votesNo; i++) {
            if (votes[i].getVoter().equals(voterName)) {
                System.out.printf("%s", votes[i].toString());
            }
        }

    }
}
