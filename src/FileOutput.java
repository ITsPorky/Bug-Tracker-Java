import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Scanner;

public class FileOutput {

    // ----------------------------------
    // Variables/Fields
    // ----------------------------------

    private File outputFile;
    private PrintWriter writer;
    private String filePath;

    private Map<Integer, Employee> employees;

    // ----------------------------------
    // Constructors
    // ----------------------------------

    // GUI Constructor
    public FileOutput(String path, Map<Integer, Employee> employee) {
        this.filePath = path;
        this.employees = employee;
        // Code to write data to a file
        try {
            outputEmployees(outputFile, filePath);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    // Argument Constructor
    public FileOutput(Map<Integer, Employee> employee) {
        this.employees = employee;
        // Code to write data to a file
        try {
            outputEmployees(outputFile, filePath);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }


    // Output file
    private void outputEmployees(File file, String filePath) throws FileNotFoundException {
        writer = new PrintWriter(filePath + "\\Data.txt");
        this.employees = employees;

        for (Map.Entry<Integer, Employee> entry : employees.entrySet()) {
            writer.println(entry.getValue().toString());
        }
        closeWriter(writer);
    }

    // Close File Writer
    private void closeWriter(PrintWriter writer) {
        writer.close();
    }

    // -----------------------------------
    // Setters and Getters
    // -----------------------------------

    private String getFilePath() {
        return filePath;
    }
    public String grabFilePath() {
        return getFilePath();
    }

    private File getOutputFile() {
        return outputFile;
    }
    public File grabOutputFile() {
        return getOutputFile();
    }

}
