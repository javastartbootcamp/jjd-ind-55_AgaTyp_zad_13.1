package pl.javastart.voting;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Voting {

    public static void main(String[] args) {
        List<String> voters = new ArrayList<>();

        // możesz dowolnie dodawać / usuwać dane testowe
        voters.add("Jan Kowalski");
        voters.add("Zigniew Siobro");
        voters.add("Zbyszek Stonoga");

        Voting voting = new Voting();

        VotingResult votingResult = voting.executeVoting(voters, new Scanner(System.in));
        votingResult.printResults();
        votingResult.printVoteForVoter("Zigniew Siobro");
    }

    /**
     * Uzupełnij metodę metodę, ale nie zmieniaj jej sygnatury! (typu tego, co przyjmuje i zwraca).
     * do wczytywania danych od użytkownika użyj scannera z parametru
     * Metoda powinna pobrać głos dla każdego przekazanego głosującego i zapisać wyniki głosowania do VotingResult
     */
    VotingResult executeVoting(List<String> voters, Scanner scanner) {
        List<String> voteSigns = List.of("z", "p", "w");
        String voteSign = "";
        VotingResult vr = new VotingResult();

        for (String voter : voters) {
            do {
                System.out.printf("Jak głosuje %s? (z - za, p - przeciw, w - wstrzymanie się)\n", voter);
                voteSign = scanner.nextLine();

            } while (!voteSigns.contains(voteSign));

            switch (voteSign) {
                case "z" -> vr.add(new Vote(voter, true));
                case "p" -> vr.add(new Vote(voter, false));
                default -> vr.add(new Vote(voter, null));
            }

        }

//        return null; // to możesz (a nawet powinieneś/powinnaś) zmienić :)
        return vr;
    }

}
