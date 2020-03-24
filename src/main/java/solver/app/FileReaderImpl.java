package solver.app;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author lchz
 */
public class FileReaderImpl implements FileReader {

    private String home;
    private String puzzle;

    private List<String> data;

    private Integer width;
    private Integer height;

    public FileReaderImpl(String home, String puzzle) {
        this.home = home;
        this.puzzle = puzzle;
        this.data = new ArrayList<>();
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
    public List<List<String>> getRows() {
        height = extractInt(data.get(2).substring(7));
        return getLines(5, height);
    }

    @Override
    public List<List<String>> getColumns() {
        width = extractInt(data.get(1).substring(6));
        return getLines(7 + height, width);
    }

    private List<List<String>> getLines(int start, int length) {
        List<List<String>> lines = new ArrayList<>();

        for (int i = start; i < start + length; i++) {
            String line = data.get(i);

            if (line.length() > 1) {
                String[] nums = line.split(",");
                lines.add(Arrays.asList(nums));
            } else {
                lines.add(Arrays.asList(line));
            }

        }
        return lines;
    }

    private Integer extractInt(String s) {
        return Integer.parseInt(s);
    }

}
