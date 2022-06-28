package utils;

import java.io.*;

public final class IOUtils {

    public static byte[] LoadApplicationResourceAsBytes(String filepath) {
        InputStream stream = Thread.currentThread().getContextClassLoader().getResourceAsStream(filepath);

        try {
            assert stream != null;
            return stream.readAllBytes();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

}
