package GreyScaleAlgorithm;


/**
 * Write a description of GreyScale here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import edu.duke.*;
import java.io.*;
public class GreyScale 
{
    public void GrayScaleMultiple()
    {
        DirectoryResource dr = new DirectoryResource();
        for(File f: dr.selectedFiles())
        {
            ImageResource image = new ImageResource(f);
            ImageResource image1 =  greyScale(image);
            String fileName = image.getFileName();
            String newName = "gray-" + fileName;
            image1.setFileName(newName);
            image1.draw();
            image1.save();
        }
        
    }
    public ImageResource greyScale(ImageResource image1)
    {
        ImageResource image2 = new ImageResource(image1.getWidth(), image1.getHeight());
        for(Pixel p2: image2.pixels())
        {
            Pixel p1 = image1.getPixel(p2.getX(),p2.getY());
            int grey = (p1.getRed() + p1.getGreen() + p1.getBlue()) /3;
            p2.setRed(grey);
            p2.setGreen(grey);
            p2.setBlue(grey);   
        }
        return image2;
    }

}
