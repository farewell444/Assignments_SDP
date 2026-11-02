package assignment6_visitor;

import java.util.Objects;

public class FileElement implements FileSystemElement {

    private final String name;
    private final long sizeBytes;

    public FileElement(String name, long sizeBytes) {
        this.name = validateName(name);
        if (sizeBytes < 0) {
            throw new IllegalArgumentException("File size cannot be negative, but was " + sizeBytes);
        }
        this.sizeBytes = sizeBytes;
    }

    @Override
    public String getName() {
        return name;
    }

    public long getSizeBytes() {
        return sizeBytes;
    }

    @Override
    public void accept(FileSystemVisitor visitor) {
        Objects.requireNonNull(visitor, "FileSystemVisitor cannot be null");
        visitor.visitFile(this);
    }

    private static String validateName(String name) {
        Objects.requireNonNull(name, "File name cannot be null");
        if (name.isBlank()) {
            throw new IllegalArgumentException("File name cannot be blank");
        }
        return name;
    }
}
