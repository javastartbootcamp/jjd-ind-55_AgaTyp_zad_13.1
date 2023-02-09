package pl.javastart.voting;

// klasa pomocnicza, możesz ją dowolnie zmieniać, albo usunąć
public class Vote {

    private String voter;
    private Boolean vote; // true - ZA, false - PRZECIW, null - wstrzymanie się

    public Vote(String voter, Boolean vote) {
        this.voter = voter;
        this.vote = vote;
    }

    @Override
    public String toString() {
        String voteType;

        try {
            if (vote) {
                voteType = "ZA";
            } else {
                voteType = "PRZECIW";
            }
        } catch (NullPointerException e) {
            voteType = "WSTRZYMAŁ SIĘ";
        }
            
        return voter + ": " +
                voteType +
                '\n';
    }

    public String getVoter() {
        return voter;
    }

    public Boolean getVote() {
        return vote;
    }
}
