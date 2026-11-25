package fs.impl;

import fs.IFileSystemItem;
import fs.IFolder;

public class Folder extends AbstractFileSystemItem implements IFolder {
    public void addItem(IFileSystemItem anItem) {
        System.out.println("To be implemented...");
    }

    public int getSize() {
        System.out.println("To be implemented...");
        return 0;
    }

    public void print() {
        System.out.println("To be implemented...");
    }
}
