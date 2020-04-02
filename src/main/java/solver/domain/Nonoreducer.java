package solver.domain;

import solver.util.ComIterator;
import solver.util.ComList;

/**
 *
 * @author lchz
 */
public class Nonoreducer {

    private ComList<ComList<String>> colCandidates;
    private ComList<ComList<String>> rowCandidate;

    public Nonoreducer(ComList<ComList<String>> cols, ComList<ComList<String>> rows) {
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
     * Reduces for common items. Those without achieving a common value are
     * removed from its list. If a list of candidates is empty, then there is no
     * common value for neither of set a or set b.
     *
     * @param a candidates of a set
     * @param b candidates of another set
     * @return number of removed items
     */
    private int reduce(ComList<ComList<String>> a, ComList<ComList<String>> b) {

        int countRemoved = 0;

        for (int i = 0; i < a.size(); i++) {

            ComList<Integer> commons = new ComList<>();
            
            Boolean[] all = new Boolean[(b.size())];
            for (int k = 0; k < all.length; k++) {
                all[k] = false;
            }
            
            Boolean firstTime = true;

            for (String candidate : a.get(i)) {
                String[] set = candidate.split("");

                ComList<Integer> indexes = new ComList<>();

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
                    ComIterator<Integer> it = new ComIterator(commons);
                    while (it.hasNext()) {
                        Integer c = it.next();
                        if (!indexes.contains(c)) {
                            it.remove(c);
                        }
                    }

                }
            }

            // Remove candidates which not have common cells
            for (int j = 0; j < b.size(); j++) {

                int fi = i;
                int fj = j;

                ComIterator<String> it = new ComIterator(b.get(j));
                while (it.hasNext()) {
                    String row = it.next();
                    
                    if ((commons.contains(fj) && !row.split("")[fi].equals("1"))
                           || (!all[fj] && row.split("")[fi].equals("1"))) {
                        it.remove(row);
                        countRemoved++;
                    }
                }
                if (b.get(j).isEmpty()) {
                    return -1;
                }
            }
        }

        return countRemoved;
    }

}
