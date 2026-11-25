package fs.impl;

abstract class AbstractFileSystemItem {
    String name;

    public abstract int getSize();

    public abstract void print();

    public String getName() {
        return this.name;
    }
}
