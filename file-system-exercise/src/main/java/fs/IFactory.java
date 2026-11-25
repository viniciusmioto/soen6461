package fs;

public interface IFactory {
    public IFile createFile(String name, int size);

    public IFolder createFolder(String name);
}
