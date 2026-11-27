package client;

import fs.IFactory;
import fs.IFile;
import fs.IFolder;
import fs.impl.Factory;

public class Client {
    static void main() {
        IFactory fileSystemFactory = Factory.getInstance();

        IFolder folderRoot = fileSystemFactory.createFolder("root");
        IFile fileA = fileSystemFactory.createFile("a.txt", 10);
        IFile fileB = fileSystemFactory.createFile("b.txt", 20);
        IFile fileC = fileSystemFactory.createFile("c.png", 30);
        IFile fileD = fileSystemFactory.createFile("d.md", 5);

        IFolder folderDocs = fileSystemFactory.createFolder("docs");
        IFolder folderImg = fileSystemFactory.createFolder("img");

        folderDocs.addItem(fileA);
        folderDocs.addItem(fileB);
        folderImg.addItem(fileC);
        folderRoot.addItem(folderDocs);
        folderRoot.addItem(folderImg);
        folderRoot.addItem(fileD);

        folderRoot.print();

        System.out.println("docs size: " + folderDocs.getSize());
        System.out.println("img size: " + folderImg.getSize());
        System.out.println("root size: " + folderRoot.getSize());
    }
}
