package solver.domain;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lchz
 */
public class Nonoreducer {
    
    private List<List<String>> colCandidates;
    private List<List<String>> rowCandidate;
    
    public Nonoreducer(List<List<String>> cols, List<List<String>> rows) {
        this.colCandidates = cols;
        this.rowCandidate = rows;
    }

    /**
     * Calculates numbers of items that have achieved their common values.
     * Method returns different states of reduction for further activities.
     * 
     * @return the state of reduction
     */
    public int reduceMutual() {
        int countRemoved1 = reduce(this.colCandidates, this.rowCandidate);
        if (countRemoved1 == -1) {
            return -1;
        }

        int countRemoved2 = reduce(this.rowCandidate, this.colCandidates);
        if (countRemoved2 == -1) {
            return -1;
        }

        return countRemoved1 + countRemoved2;
    }

    /**
     * Reduces for common items. 
     * Those without achieving a common value are removed from its list.
     * If a list of candidates is empty, no common values for both of set a and set b.
     * 
     * @param a candidates of a set
     * @param b candidates of another set
     * @return number of removed items
     */
    private int reduce(List<List<String>> a, List<List<String>> b) {

        int countRemoved = 0;

        for (int i = 0; i < a.size(); i++) {

            List<Integer> commons = new ArrayList<>();
            Boolean[] all = new Boolean[(b.size())];
            for (int k = 0; k < all.length; k++) {
                all[k] = false;
            }
            Boolean firstTime = true;

            for (String candidate : a.get(i)) {
                String[] set = candidate.split("");

                List<Integer> indexes = new ArrayList<>();

                // For each candidate, get a list of the cell indexes that contains a "1"
                for (int j = 0; j < set.length; j++) {
                    if ("1".equals(set[j])) {
                        indexes.add(j);
                        if (!all[j]) {
                            all[j] = true;
                        }
                    }
                }

                // For the first condidate, no need to compare
                if (firstTime) {
                    firstTime = false;
                    for (Integer index : indexes) {
                        commons.add(index);
                    }
                } else {
                    // Loop COMMONS to reset common sells
                    commons.removeIf(c -> !indexes.contains(c));
                }
            }

            // Remove candidates that not have common cells
            for (int j = 0; j < b.size(); j++) {

                int fi = i;
                int fj = j;

                if (b.get(j).removeIf(rowCandidate
                        -> (commons.contains(fj) && !rowCandidate.split("")[fi].equals("1"))
                        || (!all[fj] && rowCandidate.split("")[fi].equals("1")))) {

                    countRemoved++;
                }

                if (b.get(j).isEmpty()) {
                    return -1;
                }
            }
        }

        return countRemoved;
    }

}
