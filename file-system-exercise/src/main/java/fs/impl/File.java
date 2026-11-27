package fs.impl;

import fs.IFile;

class File extends AbstractFileSystemItem implements IFile {
    private final int size;

    File(String name, int size) {
        super(name);
        this.size = size;
    }

    public int getSize() {
        return this.size;
    }

    public void print(String indent) {
        System.out.println(indent + "├── " + this.getName() + "\t(" + this.getSize() + " kb)");
    }
}
