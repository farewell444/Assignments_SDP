package assignment6_visitor;

import java.util.List;

public class VisitorDemo {

    public static void main(String[] args) {
        DirectoryElement rootDir = buildFileSystem();

        demonstrateSizeCalculation(rootDir);
        demonstrateSearch(rootDir, ".pdf");
        demonstrateSearch(rootDir, ".java");
        demonstrateFailFastValidation();
    }

    private static DirectoryElement buildFileSystem() {
        DirectoryElement rootDir = new DirectoryElement("ProjectRoot");
        rootDir.addElement(new FileElement("main.java", 1500));
        rootDir.addElement(new FileElement("README.md", 800));

        DirectoryElement docsDir = new DirectoryElement("docs");
        docsDir.addElement(new FileElement("spec.pdf", 24000));
        docsDir.addElement(new FileElement("guide.pdf", 16000));
        rootDir.addElement(docsDir);

        DirectoryElement testsDir = new DirectoryElement("tests");
        testsDir.addElement(new FileElement("Test1.java", 2000));
        rootDir.addElement(testsDir);

        return rootDir;
    }

    private static void demonstrateSizeCalculation(DirectoryElement rootDir) {
        SizeCalculatorVisitor sizeCalculator = new SizeCalculatorVisitor();
        rootDir.accept(sizeCalculator);
        System.out.println("Total size: " + sizeCalculator.getTotalSizeBytes() + " bytes");
    }

    private static void demonstrateSearch(DirectoryElement rootDir, String extension) {
        SearchVisitor searchVisitor = new SearchVisitor(extension);
        rootDir.accept(searchVisitor);

        List<FileElement> foundFiles = searchVisitor.getFoundFiles();
        System.out.println("Files ending with \"" + extension + "\": " + foundFiles.size());
        for (FileElement file : foundFiles) {
            System.out.println("  - " + file.getName());
        }
    }

    private static void demonstrateFailFastValidation() {
        try {
            new FileElement("invalid.txt", -1);
        } catch (IllegalArgumentException ex) {
            System.out.println("Validation caught: " + ex.getMessage());
        }

        try {
            new FileElement(null, 100);
        } catch (NullPointerException ex) {
            System.out.println("Validation caught: " + ex.getMessage());
        }

        try {
            new DirectoryElement("   ");
        } catch (IllegalArgumentException ex) {
            System.out.println("Validation caught: " + ex.getMessage());
        }
    }
}
