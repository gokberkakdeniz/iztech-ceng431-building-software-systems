package tr.edu.iztech.teamstech.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class CSVReader {
    private final Scanner scanner;

    public CSVReader(File csvFile) throws FileNotFoundException {
        this.scanner = new Scanner(csvFile);
    }

    public boolean hasData() {
        return this.scanner.hasNextLine();
    }

    public String[] nextData() throws IllegalStateException {
        String line = this.scanner.nextLine();

        List<String> data = new LinkedList<>();
        StringBuilder currentCell = new StringBuilder();

        boolean doubleQuoth = false;
        for (char c: line.toCharArray()) {
            if (c == ',') {
                if (doubleQuoth) {
                    currentCell.append(c);
                } else {
                    data.add(currentCell.toString());
                    currentCell.setLength(0);
                }
            } else if (c == '"') {
                doubleQuoth = !doubleQuoth;
            } else {
                currentCell.append(c);
            }
        }
        data.add(currentCell.toString());

        return data.toArray(String[]::new);
    }

    public void close() {
        scanner.close();
    }
}