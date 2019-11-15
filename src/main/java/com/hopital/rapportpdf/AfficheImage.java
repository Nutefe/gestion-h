package com.hopital.rapportpdf;

import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.layout.element.Image;

import java.net.MalformedURLException;

public class AfficheImage {


    public Image monImage(){
        String url = "../image/code.jpg";

        ImageData data = null;
        try {
            data = ImageDataFactory.create(url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        Image image = new Image(data);

        return image;
    }
}
