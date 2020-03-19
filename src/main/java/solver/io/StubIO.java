package solver.io;

import java.util.ArrayList;

/**
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
    
    
    @Override
    public String read() {
        return inputs[index++];
    }

    @Override
    public void print(String string) {
        outputs.add(string);
    }
    
    public String getOutput(int i) {
        return outputs.get(i);
    }
    
}

