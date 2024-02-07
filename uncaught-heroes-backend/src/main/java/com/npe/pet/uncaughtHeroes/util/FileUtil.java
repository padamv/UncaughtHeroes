package com.npe.pet.uncaughtHeroes.util;

import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class FileUtil {

    public File openFile(String fileNameWithExtension) {
        return new File(fileNameWithExtension);
    }
}