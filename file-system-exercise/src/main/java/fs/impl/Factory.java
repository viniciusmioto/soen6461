package fs.impl;

import fs.IFactory;
import fs.IFile;
import fs.IFolder;

public class Factory implements IFactory {
    private Factory() {
    }

    private static final IFactory THE_UNIQUE_FACTORY = new Factory();

    public static IFactory getInstance() {
        return Factory.THE_UNIQUE_FACTORY;
    }


    public IFile createFile(String name, int size) {
        return new File(name, size);
    }

    public IFolder createFolder(String name) {
        return new Folder(name);
    }
}
