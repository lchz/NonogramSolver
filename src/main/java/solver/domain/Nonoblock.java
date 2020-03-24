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
     * Prints all possible permutations of this block according to the given
     * list and the length of the block. The list of data represents how many
     * and in what order the ones should be. Ones in this case simulate black
     * cells in a real Nonogram game.
     * 
     * @param lines a list of cells to be "1"
     * @param length length of this block
     * @return All possible combinations for this line
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
     * Generates all possible permutations of this block. The list of ones
     * represents in which cell should "1" be.
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

    private String repeat(int n, String s) {
        String result = "";
        for (int i = 0; i < n; i++) {
            result += s;
        }

        return result;
    }

    private Integer extractInt(String s) {
        return Integer.parseInt(s);
    }
}
