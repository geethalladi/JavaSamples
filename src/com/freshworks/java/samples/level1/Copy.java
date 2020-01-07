package com.freshworks.java.samples.level1;

import java.io.*;

public class Copy
{
    private static final int BUFFER_SIZE = 8 * 1024;

    // try-with-resources on multiple resources - short and sweet
    static void copy(String src, String dst) throws IOException {
        // Copy the contents of source -> dest
        // try-with-resource, close the resource, once try is complete
        try (InputStream   in = new FileInputStream(src);
             OutputStream out = new FileOutputStream(dst)) {
            byte[] buf = new byte[BUFFER_SIZE];
            int n;
            while ((n = in.read(buf)) >= 0)
                out.write(buf, 0, n);
        }
    }

    static void copyOldStyle(String src, String dst) throws IOException {
        // how to safely close a stream
        // Credits: lvijay@
        InputStream in = null;
        try {
            in = new FileInputStream(src);
            int read = in.read();
        } catch (IOException e) {
            // logger.info("Unable to read from source %s".format(src));
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    // logger.info("Unable to close source %s".format(src));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        String src = args[0];
        String dst = args[1];
        copy(src, dst);
    }
}
