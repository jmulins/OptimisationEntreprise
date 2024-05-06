import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvFile01 implements CsvFile {

    public final static char SEPARATOR = ',';

    private File file;
    private List<String> lines;
    private List<String[] > data;

    private CsvFile01() {
    }

    public CsvFile01(File file) {
        this.file = file;

        // Init
        try {
            init();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void init() throws IOException {
        lines = CsvFileHelper.readFile(file);

        data = new ArrayList<String[] >(lines.size());
        String sep = SEPARATOR+"";
        for (String line : lines) {
            String[] oneData = line.split(sep);
            data.add(oneData);
        }
    }

    @Override
    public File getFile() {
        return null;
    }

    @Override
    public List<String[]> getData() {
        return List.of();
    }

}