package com.company;

import java.io.File;

public class FileManagerFactory {

    public static SongReader createSongReader(Enum<Manager> e) {
        if (Manager.ByteFileManager.equals(e)) {
            return new ByteFileManager();
        }
        if (Manager.CharacterFileManager.equals(e)) {
            return new CharacterFileManager();
        }
        if (Manager.ObjectIO.equals(e)) {
            return new ObjectIO();
        }
        if (Manager.FileManager.equals(e)) {
            return new FileManager();
        }
        return null;
    }
}
