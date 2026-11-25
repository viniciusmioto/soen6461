package fs.impl;

import fs.IFile;

public class File extends AbstractFileSystemItem implements IFile {
    int size;

    File(String name, int size) {
        this.size = size;
        this.name = name;
    }

    public int getSize() {
        return this.size;
    }

    public void print() {
        System.out.println("To be implemented");
    }
}
