package fs;

public interface IFileSystemItem {
    String getName();

    int getSize();

    void print(String indent);

    default void print() {
        print("");
    }
}
