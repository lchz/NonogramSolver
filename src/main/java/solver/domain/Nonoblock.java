package solver.domain;

import solver.io.IO;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static java.util.stream.Collectors.toList;

/**
 *
 * @author lchz
 */
public class Nonoblock {
    
    private IO io;
    
    public Nonoblock(IO io) {
        this.io = io;
    }
    
    /**
     * Prints all possible permutations of this block from the given list and the length of the block.
     * The list of data represents how many and in what order the continuous ones should be in this block.
     * Ones in this case simulate colour grey in a real Nonogram game.
     * 
     * @param data   a list of cells to be "1"
     * @param length length of this block
     */
    public void printBlock(List<Integer> data, int length) {
        int cellSum = data.stream().reduce(0, (subtotal, element) -> subtotal + element);
        
        if (length - cellSum <= 0) {
            io.print("No solution");
            return;
        }
        
        List<String> ones = data.stream().map(d -> "1".repeat(d)).collect(toList());
        
        List<String> sequences = generateSequences(ones, length - cellSum + 1);
        
        for (String sequence: sequences) {
            io.print(sequence.substring(1));
        }
    }
    
    /**
     * Generates all possible permutations of this block.
     * The list of ones represents in which cell should one be.
     * 
     * @param ones      a list of ones
     * @param numZeros  zero numbers in this block
     * @return          the list of possible permutations
     */
    public List<String> generateSequences(List<String> ones, int numZeros) {
        if (ones.isEmpty()) {
            return Arrays.asList("0".repeat(numZeros));
        }
        
        List<String> result = new ArrayList<>();
        for (int x = 1; x < numZeros - ones.size() + 2; x++) {
            List<String> skipOne = ones.stream().skip(1).collect(toList());
            
            List<String> tails = generateSequences(skipOne, numZeros  - x);
            
            for (String tail: tails) {
                result.add("0".repeat(x) + ones.get(0) + tail);
            }
        }
        return result;
    }
}

