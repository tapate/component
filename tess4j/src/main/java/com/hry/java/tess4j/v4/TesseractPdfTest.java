package com.hry.java.tess4j.v4;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import net.sourceforge.tess4j.util.PdfUtilities;

import java.io.File;
import java.io.IOException;

public class TesseractPdfTest {
	public static void main(String[] args) throws TesseractException, IOException {
		// user.dir = D:\eclipse_study\simpletool
		File root = new File(System.getProperty("user.dir") + "/tess4j/src/main/resources/com/hry/java/tess4j/v4/pdf/");
		System.out.println(root.getAbsolutePath());
		
	//	Tesseract instance = Tesseract.getInstance();
		Tesseract instance = new Tesseract();
		
		/**
		 * 设置语言库: 
		 * 下载地址：https://github.com/tesseract-ocr/tessdata
		 * 
		 */
		instance.setDatapath(System.getProperty("user.dir") + "/tess4j/src/main/resources/com/hry/java/tess4j/v4/tessdata/");

      

        File pdfDoc = new File(root.getAbsoluteFile() + "/ma.pdf");
        File pngImageFiles[] = PdfUtilities.convertPdf2Png(pdfDoc);

        for (int i = 0; i < pngImageFiles.length; i++) {
          String ocrResult = instance.doOCR(pngImageFiles[i]);
          System.out.println("----------" + i + "-----------------");
          System.out.println(ocrResult);
        }
        

	}
}
