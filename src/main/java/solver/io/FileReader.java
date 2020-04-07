package solver.io;

import solver.util.ComList;


/**
 *
 * @author lchz
 */
public interface FileReader {

    void getData();
    
    String getName();

    ComList<ComList<String>> getRows();

    ComList<ComList<String>> getColumns();

}
