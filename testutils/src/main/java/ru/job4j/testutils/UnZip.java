package ru.job4j.testutils;

import org.junit.rules.TemporaryFolder;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.nio.file.Paths;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/**
 * Class UnZip.
 *
 * @author Vladimir Ivanov
 * @version 0.1
 * @since 09.09.2017
 */
public class UnZip {
    /**
     * Unzip to tmpDir directory.
     *
     * @param file   Zip file.
     * @param tmpDir Temporary Folder.
     */
    public static void unzip(String file, TemporaryFolder tmpDir) {
        final int BUFFER = 2048;
        try {
            BufferedOutputStream dest = null;
            BufferedInputStream is = null;
            ZipEntry entry;
            ZipFile zipfile = new ZipFile(file);
            Enumeration e = zipfile.entries();
            while (e.hasMoreElements()) {
                entry = (ZipEntry) e.nextElement();
                is = new BufferedInputStream(zipfile.getInputStream(entry));
                int count;
                byte[] data = new byte[BUFFER];
                FileOutputStream fos = new FileOutputStream(Paths.get(tmpDir.getRoot().getPath(), entry.getName()).toFile());
                dest = new BufferedOutputStream(fos, BUFFER);
                while ((count = is.read(data, 0, BUFFER)) != -1) {
                    dest.write(data, 0, count);
                }
                dest.flush();
                dest.close();
                is.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
