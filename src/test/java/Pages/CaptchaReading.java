package Pages;

import java.io.File;

import org.ghost4j.GhostscriptException;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class CaptchaReading {
	
	
		
	
	public static void main(String[] args)  {
		ITesseract image = new Tesseract();
		String STR;
		try {
			String filePath = System.getProperty("user.dir") +"\\CaptchaHndle.PNG" ;
			
			String  STRR = image.doOCR(new File(filePath));
			
			System.out.println("Data From image is" + STRR);
			
		
		} catch (TesseractException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
			
		}
}
