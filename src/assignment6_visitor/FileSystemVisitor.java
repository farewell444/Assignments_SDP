package assignment6_visitor;

public interface FileSystemVisitor {

    void visitFile(FileElement file);

    void visitDirectory(DirectoryElement directory);
}
