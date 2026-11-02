package assignment6_visitor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class SearchVisitor implements FileSystemVisitor {

    private final String searchExtension;
    private final List<FileElement> foundFiles = new ArrayList<>();

    public SearchVisitor(String searchExtension) {
        Objects.requireNonNull(searchExtension, "Search extension cannot be null");
        if (searchExtension.isBlank()) {
            throw new IllegalArgumentException("Search extension cannot be blank");
        }
        this.searchExtension = searchExtension;
    }

    @Override
    public void visitFile(FileElement file) {
        Objects.requireNonNull(file, "FileElement cannot be null");
        if (file.getName().endsWith(searchExtension)) {
            foundFiles.add(file);
        }
    }

    @Override
    public void visitDirectory(DirectoryElement directory) {
        Objects.requireNonNull(directory, "DirectoryElement cannot be null");
    }

    public List<FileElement> getFoundFiles() {
        return Collections.unmodifiableList(foundFiles);
    }
}
