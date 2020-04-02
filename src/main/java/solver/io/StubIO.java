package solver.io;

import java.util.ArrayList;

/**
 * This class is for testing IO.
 * 
 * @author lchz
 */
public class StubIO implements IO {

    private String[] inputs;
    private ArrayList<String> outputs;
    private int index;

    public StubIO(String... inputs) {
        this.inputs = inputs;
        this.outputs = new ArrayList<>();
    }

    /**
     * Stores an input into an input list.
     * 
     * @return the last input passed in
     */
    @Override
    public String read() {
        return inputs[index++];
    }

    /**
     * Stores the specific output into an output list.
     * 
     * @param string the output to be stored 
     */
    @Override
    public void print(String string) {
        outputs.add(string);
    }

    /**
     * Stores the specific output of a puzzle result.
     * 
     * @param string the output to be stored
     */
    @Override
    public void printPuzzle(String string) {
        outputs.add(string);
    }

    /**
     * Returns the content at the specific index in this output list.
     * 
     * @param i index of the content to be returned
     * @return the content at this specific index
     */
    public String getOutput(int i) {
        return outputs.get(i);
    }
}
