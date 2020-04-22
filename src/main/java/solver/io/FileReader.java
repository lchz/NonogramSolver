package solver.io;

import solver.util.ComList;


/**
 * Interface for reading files and storing hints.
 * @author lchz
 */
public interface FileReader {

    void getData();
    
    String getName();

    ComList<ComList<String>> getRows();

    ComList<ComList<String>> getColumns();

}
