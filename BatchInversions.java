package GreyScaleAlgorithm;


/**
 * Write a description of InvertedImage here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.io.*;
public class BatchInversions 
{
    
    public ImageResource makeInversion(ImageResource image)
    {
        ImageResource invertedImage = new ImageResource(image.getWidth(), image.getHeight()) ;
        
        for (Pixel p2:invertedImage.pixels())
        {
            Pixel p1 = image.getPixel(p2.getX(),p2.getY());
            p2.setRed(255-p1.getRed());
            p2.setGreen(255-p1.getGreen());
            p2.setBlue(255-p1.getBlue());
        }
        return invertedImage;
    }
    public void selectAndConvert()
    {
        DirectoryResource dr = new DirectoryResource();
        
        for(File f: dr.selectedFiles())
        {
            ImageResource image = new ImageResource(f);
            String fName = image.getFileName();
            String newName = "inverted-" + fName;
            ImageResource image1 = makeInversion(image);
            image1.setFileName(newName);
            image1.draw();
            image1.save();
        }
    }

}
