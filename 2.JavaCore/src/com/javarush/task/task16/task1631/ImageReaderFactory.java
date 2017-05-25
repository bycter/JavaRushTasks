package com.javarush.task.task16.task1631;

import com.javarush.task.task16.task1631.common.*;

public class ImageReaderFactory {

    public static ImageReader getImageReader(ImageTypes type) throws IllegalArgumentException {

        ImageReader reader;
        if (ImageTypes.BMP.equals(type)) {
            reader = new BmpReader();
        } else if (ImageTypes.JPG.equals(type)) {
            reader = new JpgReader();
        } else if (ImageTypes.PNG.equals(type)) {
            reader = new PngReader();
        } else {
            throw new IllegalArgumentException("Неизвестный тип картинки");
        }

        return reader;
    }
}
