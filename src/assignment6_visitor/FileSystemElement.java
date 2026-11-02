package assignment6_visitor;

public interface FileSystemElement {

    String getName();

    void accept(FileSystemVisitor visitor);
}
