package com.example.demo.Scheduler;


import com.sun.org.apache.xml.internal.resolver.readers.ExtendedXMLCatalogReader;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.apache.commons.io.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.zip.*;

@Component
public class Scheduler {


    @Scheduled(cron = "* *  */2 * * * ")//co 2 h
    public void backupToZip()
    {

        System.out.println("Starting backup");
        String source = "FakeDB";
        File srcDir = new File(source);

        String destination= "CopiedDB";
        File destDir = new File(destination);

        //jesli juz taki folder istnieje usuwa go
        if(destDir.exists())
        {
            try {

                FileUtils.deleteDirectory(destDir);
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }


        //kopiuje tworzac nowy folder docelowy
        try {
            FileUtils.copyDirectory(srcDir,destDir);


        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        //Konwersja do zipa

        String zipFolder = destination + ".zip";
        File zipFile = new File(zipFolder);

        if(zipFile.exists()) {
            try {

                Files.delete(zipFile.toPath());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            zipFolder(Paths.get(destination),Paths.get(zipFolder));
        } catch (Exception e) {
            e.printStackTrace();
        }


        System.out.println("Finished backup");
    }

    // Uses java.util.zip to create zip file
    private void zipFolder(Path sourceFolderPath, Path zipPath) throws Exception {
        ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(zipPath.toFile()));
        Files.walkFileTree(sourceFolderPath, new SimpleFileVisitor<Path>() {
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                zos.putNextEntry(new ZipEntry(sourceFolderPath.relativize(file).toString()));
                Files.copy(file, zos);
                zos.closeEntry();
                return FileVisitResult.CONTINUE;
            }
        });
        zos.close();
    }

    
}
