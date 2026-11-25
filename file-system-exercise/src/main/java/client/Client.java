package client;

import fs.IFile;
import fs.impl.Factory;

public class Client {
    static void main() {
        IFile myFile = Factory.getInstance().createFile("d.md", 5);
        System.out.println(myFile.getName());
    }
}
