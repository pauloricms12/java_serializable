package org.example;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Load_image {
    public static byte[] loadImage(String path) throws IOException {
        File image_file = new File(path);
        byte[] image = new byte[(int) image_file.length()];
        try (FileInputStream file = new FileInputStream(image_file)){
            file.read(image);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return image;
    }

}
