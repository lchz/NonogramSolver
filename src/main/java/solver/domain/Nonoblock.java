package solver.domain;

import solver.util.ComList;

/**
 *
 * @author lchz
 */
public class Nonoblock {
    
    /**
     * Generates all possible candidates for every line in the lines.
     * 
     * @param lines data for every block in rows or columns
     * @param length length of the lines
     * @return All possible combinations for every block in the lines
     */
    public ComList<ComList<String>> getCandidates(ComList<ComList<String>>lines, int length) {
        ComList<ComList<String>> candidates = new ComList<>();
        
        for (ComList<String> line: lines) {
            int cellSum = 0;
            for (String l : line) {
                cellSum += extractInt(l);
            }

            ComList<String> ones = new ComList<>();
            line.stream().map(d -> repeat(extractInt(d), "1")).forEach(ones::add);
            
            ComList<String> sequences = generateSequences(ones, length - cellSum + 1);
            
            ComList<String> lineCandidates = new ComList<>();
            
            for (String sequence : sequences) {
                
                lineCandidates.add(sequence.substring(1));
                
            }
            candidates.add(lineCandidates);

        }
        
        return candidates;
    }

    /**
     * Generates all possible permutations of this block. 
     * The list of ones represents in which cells should "1" be.
     *
     * @param ones a list of ones
     * @param numZeros zero numbers in this block
     * @return the list of possible permutations
     */
    private ComList<String> generateSequences(ComList<String> ones, int numZeros) {
        if (ones.isEmpty()) {
            String s = repeat(numZeros, "0");
            return convertString(s);
        }

        ComList<String> result = new ComList<>();

        for (int x = 1; x < numZeros - ones.size() + 2; x++) {
            ComList<String> skipOne = new ComList<>();
            ones.stream().skip(1).forEach(skipOne::add);
            
            ComList<String> tails = generateSequences(skipOne, numZeros - x);
            
            for (String tail : tails) {
                result.add(repeat(x, "0") + ones.get(0) + tail);
            }
        }
        return result;
    }

    /**
     * Returns a string with a repeated substring
     * 
     * @param n times to repeat
     * @param substring a substring to be repeated
     * @return the reconstucted string
     */
    private String repeat(int n, String substring) {
        String result = "";
        for (int i = 0; i < n; i++) {
            result += substring;
        }

        return result;
    }

    /**
     * Converts a string into an integer, if it only consists of integers.
     * 
     * @param s string for converting into integer
     * @return converted integer from string
     */
    private Integer extractInt(String s) {
        return Integer.parseInt(s);
    }
    
    private ComList<String> convertString(String s) {
        ComList<String> l = new ComList<>();
        l.add(s);
        
        return l;
    }
}
