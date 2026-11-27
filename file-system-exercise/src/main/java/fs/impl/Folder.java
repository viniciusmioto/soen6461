package fs.impl;

import fs.IFileSystemItem;
import fs.IFolder;

import java.util.ArrayList;
import java.util.List;

class Folder extends AbstractFileSystemItem implements IFolder {
    private final List<IFileSystemItem> items;

    Folder(String name) {
        super(name);
        this.items = new ArrayList<IFileSystemItem>();
    }

    public void addItem(IFileSystemItem anItem) {
        this.items.add(anItem);
    }

    public int getSize() {
        int totalSize = 0;
        for (IFileSystemItem item : this.items) {
            totalSize += item.getSize();
        }
        return totalSize;
    }

    public void print(String indent) {
        System.out.println(indent + "├── " + this.getName() + "/");
        for (IFileSystemItem item : this.items) {
            item.print(indent + "\t");
        }
    }
}
