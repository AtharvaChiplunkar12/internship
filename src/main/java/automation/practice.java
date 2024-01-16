package automation;

import java.io.File;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.TessAPI1;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.Tesseract1;

public class practice {
    public static void main(String[] args) throws Exception {

        String tessdataPath = "/Users/AtharvaChiplunkar/Library/CloudStorage/GoogleDrive-ac2434@g.rit.edu/My Drive/internship-getinge/practice/tessdata/";
        System.setProperty("java.library.path", "/opt/homebrew/Cellar/tesseract/5.3.3/lib");
        System.setProperty("TESSDATA_PREFIX", tessdataPath);
        System.out.println("TESSDATA_PREFIX: " + System.getProperty("TESSDATA_PREFIX"));

         ITesseract imagetext = new Tesseract();
        
        imagetext.doOCR(new File("/Users/AtharvaChiplunkar/Library/CloudStorage/GoogleDrive-ac2434@g.rit.edu/My Drive/internship-getinge/getinge-internship/image/spicejet-logo.png"));
    }
}
