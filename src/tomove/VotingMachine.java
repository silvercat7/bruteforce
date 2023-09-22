package tomove;

public class VotingMachine {
    private int[] candidates;

    public VotingMachine(int numCandidates) {
        candidates = new int[numCandidates];
    }

    public void castVote(int candidateNumber) {
        if (candidateNumber < candidates.length) {
            candidates[candidateNumber] = candidates[candidateNumber] + 1;
        }
    }

    public int getTotalVotesFor(int candidateNumber) {
        if (candidateNumber < candidates.length) {
            return candidates[candidateNumber];
        }
        return -1;
    }

    public int getWinner() {
        int maxVotes = -1;
        int winner = -1;
        for (int i = 0; i < candidates.length; i++) {
            if (candidates[i] > maxVotes) {
                maxVotes = candidates[i];
                winner = i;
            }
        }
        for (int i = 0; i < candidates.length; i++) {
            if (candidates[i] == maxVotes && i != winner) {
                return -1;
            }
        }
        return winner;
    }
}
