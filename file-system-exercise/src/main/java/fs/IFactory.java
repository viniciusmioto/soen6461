package fs;

public interface IFactory {
    IFile createFile(String name, int size);

    IFolder createFolder(String name);
}
