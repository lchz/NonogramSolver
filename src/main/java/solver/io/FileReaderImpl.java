package solver.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import solver.util.ComList;

/**
 * This class is for reading file and extracting data of this puzzle.
 *
 * @author lchz
 */
public class FileReaderImpl implements FileReader {

    private String puzzle;

    private ComList<String> data;

    private Integer width;
    private Integer height;

    public FileReaderImpl(String puzzle) {
        this.puzzle = puzzle;
        this.data = new ComList<>();
    }

    /**
     * Reads data from a specific file.
     */
    @Override
    public void getData() {

        try {
            String path = "files/" + puzzle;

            File file = new File(path.trim());
            Scanner s = new Scanner(file);

            while (s.hasNextLine()) {
                data.add(s.nextLine().trim());
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileReaderImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Extracts name of this puzzle from data.
     *
     * @return name of this puzzle
     */
    @Override
    public String getName() {
        return data.get(0).substring(6);
    }

    /**
     * Constructs rows of this puzzle. Rows are consisted of a collection of
     * tips.
     *
     * @return constructed rows
     */
    @Override
    public ComList<ComList<String>> getRows() {
        height = extractInt(data.get(2).substring(7));
        return getLines(5, height);
    }

    /**
     * Constructs columns of this puzzle. Columns are consisted of a collection
     * of tips.
     *
     * @return constructed columns
     */
    @Override
    public ComList<ComList<String>> getColumns() {
        width = extractInt(data.get(1).substring(6));
        return getLines(7 + height, width);
    }

    /**
     * Constructs lines from data.
     *
     * @param start index from where to read data
     * @param length length of data to be read
     * @return constructed lines
     */
    private ComList<ComList<String>> getLines(int start, int length) {
        ComList<ComList<String>> lines = new ComList<>();

        for (int i = start; i < start + length; i++) {
            String line = data.get(i);
            lines.add(convertString(line));

        }
        return lines;
    }

    /**
     * Converts the specific string into Integer. The string should be consisted
     * of only integers.
     *
     * @param s string to be extracted
     * @return integer converted from the specific string.
     */
    private Integer extractInt(String s) {
        return Integer.parseInt(s);
    }

    /**
     * Converts the specific string into a collection of type ComList. If the
     * string is consisted of more than one element joined by ',', then every
     * element of this string will be appended to this collection of ComList.
     *
     * @param s string to be converted
     * @return the collection of type of ComList
     */
    private ComList<String> convertString(String s) {
        ComList<String> l = new ComList<>();

        if (s.contains(",")) {
            String[] nums = s.split(",");
            for (String num : nums) {
                l.add(num);
            }

        } else {
            l.add(s);
        }

        return l;
    }

}
