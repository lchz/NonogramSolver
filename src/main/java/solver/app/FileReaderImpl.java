package solver.app;

import java.io.File;
import java.util.Scanner;
import solver.util.ComList;

/**
 *
 * @author lchz
 */
public class FileReaderImpl implements FileReader {

    private String home;
    private String puzzle;

    private ComList<String> data;

    private Integer width;
    private Integer height;

    public FileReaderImpl(String home, String puzzle) {
        this.home = home;
        this.puzzle = puzzle;
        this.data = new ComList<>();
    }

    @Override
    public void getData() {

        try {
            String path = home + "/src/main/java/solver/files/" + puzzle;
            File file = new File(path.trim());
            Scanner s = new Scanner(file);

            while (s.hasNextLine()) {
                data.add(s.nextLine().trim());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getName() {
        return data.get(0).substring(6);
    }

    @Override
    public ComList<ComList<String>> getRows() {
        height = extractInt(data.get(2).substring(7));
        return getLines(5, height);
    }

    @Override
    public ComList<ComList<String>> getColumns() {
        width = extractInt(data.get(1).substring(6));
        return getLines(7 + height, width);
    }

    private ComList<ComList<String>> getLines(int start, int length) {
        ComList<ComList<String>> lines = new ComList<>();

        for (int i = start; i < start + length; i++) {
            String line = data.get(i);
            lines.add(convertString(line));

        }
        return lines;
    }

    private Integer extractInt(String s) {
        return Integer.parseInt(s);
    }

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
