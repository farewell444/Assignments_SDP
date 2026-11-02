package assignment6_visitor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class DirectoryElement implements FileSystemElement {

    private final String name;
    private final List<FileSystemElement> children = new ArrayList<>();

    public DirectoryElement(String name) {
        this.name = validateName(name);
    }

    @Override
    public String getName() {
        return name;
    }

    public void addElement(FileSystemElement element) {
        children.add(Objects.requireNonNull(element, "FileSystemElement cannot be null"));
    }

    public List<FileSystemElement> getChildren() {
        return Collections.unmodifiableList(children);
    }

    @Override
    public void accept(FileSystemVisitor visitor) {
        Objects.requireNonNull(visitor, "FileSystemVisitor cannot be null");
        visitor.visitDirectory(this);
        for (FileSystemElement child : children) {
            child.accept(visitor);
        }
    }

    private static String validateName(String name) {
        Objects.requireNonNull(name, "Directory name cannot be null");
        if (name.isBlank()) {
            throw new IllegalArgumentException("Directory name cannot be blank");
        }
        return name;
    }
}
