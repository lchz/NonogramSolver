/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solver.domain;

import java.util.Arrays;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import solver.io.StubIO;

/**
 *
 * @author lchz
 */
public class NonoblockTest {

    StubIO io;
    Nonoblock block;

    @Before
    public void setUp() {
        io = new StubIO();
        block = new Nonoblock(io);
    }

    @Test
    public void generate_sequences_correctly() {
        
        block.printBlock(Arrays.asList(2, 1), 5);
        assertEquals("11010", io.getOutput(0));
        assertEquals("11001", io.getOutput(1));
        assertEquals("01101", io.getOutput(2));
    }

    @Test
    public void noSolution_if_hints_longer_than_length() {

        block.printBlock(Arrays.asList(2, 4), 5);
        assertEquals("No solution", io.getOutput(0));
    }
}
