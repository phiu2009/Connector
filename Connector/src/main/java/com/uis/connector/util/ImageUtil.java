package com.uis.connector.util;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.imageio.ImageIO;

public class ImageUtil {

	public static byte[] getImageFromURL(String imageUrl){
		URL url;
		try {
			 url = new URL(imageUrl);
			 InputStream in = new BufferedInputStream(url.openStream());
			 ByteArrayOutputStream out = new ByteArrayOutputStream();
			 byte[] buf = new byte[1024];
			 int n = 0;
			 while (-1!=(n=in.read(buf)))
			 {
			    out.write(buf, 0, n);
			 }
			 out.close();
			 in.close();
			 byte[] byteArray = out.toByteArray();
//			 FileOutputStream fos = new FileOutputStream("C://temp//uis_image.jpg");
//			 fos.write(byteArray);
//			 fos.close();
			 
			 return byteArray;
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
//		 Base64.getEncoder().encodeToString(response);
		 
//		 String imageDataString = Base64.encodeBase64URLSafeString(imageByteArray);
//		 byte[] imageDataBytes = Base64.decodeBase64(imageDataString);
	}
	
	public static List<String> encodeImage(String imageUrl){
		byte[] data = getImageFromURL(imageUrl);
		
		if (data != null){
			StringBuffer base64String = new StringBuffer(Base64.getEncoder().encodeToString(data));
			List<String> base64ImageList = new ArrayList<String>();
			
			final int MAX_LENGTH = 20480;
			while (base64String.length() > 0){
				if (base64String.length() >= MAX_LENGTH){
					base64ImageList.add(base64String.substring(0, MAX_LENGTH));
					base64String.delete(0, MAX_LENGTH);
				}else{
					base64ImageList.add(base64String.substring(0, base64String.length()));
					base64String.delete(0, base64String.length());
				}
			}
			return base64ImageList;
		}
		return null;
	}
	
//	public static String resizeImage(String imageUrl, int height, int width){
//		URL url;
//		try {
//			url = new URL(imageUrl);
//			BufferedImage originalImage = ImageIO.read(url);
//			return resizeImage(height, width, originalImage);
//		} catch (MalformedURLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return null;
//	}

	private static String resizeImage(BufferedImage originalImage, int height, int width) throws IOException {
		int newHeight = height;
		int newWidth = width;
		BufferedImage resizedImage = new BufferedImage(newWidth, newHeight, originalImage.getType());
		Graphics2D g = resizedImage.createGraphics();
		g.drawImage(originalImage, 0, 0, newWidth, newHeight, null);
		g.dispose();
		
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		ImageIO.write(resizedImage, "png", out);
		
		byte[] byteArray = out.toByteArray();
		return Base64.getEncoder().encodeToString(byteArray);
	}
	
	public static String resizeImageForThumbNail(String imageUrl){
		URL url;
		try {
			url = new URL(imageUrl);
			BufferedImage originalImage = ImageIO.read(url);
			return resizeImage(originalImage, 48, 64);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
//		return resizeImage(imageUrl, 48, 64);
    }
	
	public static String resizeImageForWeb(String imageData){
		ByteArrayInputStream bis = new ByteArrayInputStream(Base64.getDecoder().decode(imageData));
		BufferedImage image;
		try {
			image = ImageIO.read(bis);
			bis.close();
			return resizeImage(image, 800, 600);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
    }
}
