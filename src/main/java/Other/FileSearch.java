package Other;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileSearch {
    public static void main(String[] args) {
        List<File> fileList = new ArrayList<>();
        searchFiles(new File("D:\\"), fileList);
        for (File file : fileList) {
            System.out.println(file.getAbsoluteFile());
        }
    }

    public static void searchFiles(File rootFile, List<File> fileList) {
        if (rootFile.isDirectory()) {
            System.out.println("searching at: " + rootFile.getAbsoluteFile());
            File[] directoryFiles = rootFile.listFiles();
            if (directoryFiles != null) {
                for (File file : directoryFiles) {
                    if (file.isDirectory()) {
                        searchFiles(file, fileList);
                    } else {
                        if (file.getName().toLowerCase().endsWith(".jpg")) {
                            fileList.add(file);
                        }
                    }
                }
            }
        }
    }
}
