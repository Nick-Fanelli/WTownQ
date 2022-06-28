package utils;

import java.io.IOException;
import java.io.InputStream;

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
