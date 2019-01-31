import com.sun.deploy.util.StringUtils;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.stream.Stream;

public class CSVFilter {

    public void filterNamesByMonth(String inputFile, String targetMonth, String outputFile) throws IOException {

        String emptyOutputFile = "";
        Path outputPath = Paths.get(outputFile);

        if (Files.exists(outputPath)) {
            Files.write(outputPath, emptyOutputFile.getBytes(), StandardOpenOption.TRUNCATE_EXISTING);
        } else
            Files.createFile(outputPath);

        try (Stream<String> stream = Files.lines(Paths.get(inputFile))) {

            stream
                    .filter(s -> s.contains(targetMonth))
                    .sorted()
                    .forEach(x -> {

                        String[] list = StringUtils.splitString(x, ",");
                        String outputString = list[0] + ", " + list[1] + "\n";

                        try {
                            Files.write(outputPath, outputString.getBytes(), StandardOpenOption.APPEND);

                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
