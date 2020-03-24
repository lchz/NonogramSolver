package solver.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static java.util.stream.Collectors.toList;

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
    public List<List<String>> getCandidates(List<List<String>> lines, int length) {

        List<List<String>> candidates = new ArrayList<>();
        
        for (List<String> line : lines) {
            int cellSum = 0;
            for (String l : line) {
                cellSum += extractInt(l);
            }

            List<String> ones = line.stream().map(d -> repeat(extractInt(d), "1")).collect(toList());
            List<String> sequences = generateSequences(ones, length - cellSum + 1);
            
            List<String> lineCandidates = new ArrayList<>();
            
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
    private List<String> generateSequences(List<String> ones, int numZeros) {
        if (ones.isEmpty()) {
            String s = repeat(numZeros, "0");
            return Arrays.asList(s);
        }

        List<String> result = new ArrayList<>();
        for (int x = 1; x < numZeros - ones.size() + 2; x++) {
            List<String> skipOne = ones.stream().skip(1).collect(toList());

            List<String> tails = generateSequences(skipOne, numZeros - x);

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
     * @param substring substring to be repeated
     * @return 
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
     * @param s string for converting
     * @return converted integer from string
     */
    private Integer extractInt(String s) {
        return Integer.parseInt(s);
    }
}
