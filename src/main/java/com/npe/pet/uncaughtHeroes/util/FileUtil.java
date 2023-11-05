package com.npe.pet.uncaughtHeroes.util;

import java.io.File;

public class FileUtil {

    public File openFile(String fileNameWithExtension) {
        return new File(fileNameWithExtension);
    }
}