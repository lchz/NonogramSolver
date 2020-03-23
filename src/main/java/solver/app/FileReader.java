package solver.app;

import java.util.List;

/**
 *
 * @author lchz
 */
public interface FileReader {

    void getData();
    
    String getName();

    List<List<String>> getRows();

    List<List<String>> getColumns();

}
