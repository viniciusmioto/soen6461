package fs.impl;

abstract class AbstractFileSystemItem {
    private String name;

    AbstractFileSystemItem(String name) {
        this.name = name;
    }

    public abstract int getSize();

    public abstract void print(String indent);

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
