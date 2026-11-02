package assignment6_visitor;

import java.util.Objects;

public class SizeCalculatorVisitor implements FileSystemVisitor {

    private long totalSizeBytes = 0;

    @Override
    public void visitFile(FileElement file) {
        Objects.requireNonNull(file, "FileElement cannot be null");
        totalSizeBytes += file.getSizeBytes();
    }

    @Override
    public void visitDirectory(DirectoryElement directory) {
        Objects.requireNonNull(directory, "DirectoryElement cannot be null");
    }

    public long getTotalSizeBytes() {
        return totalSizeBytes;
    }
}
