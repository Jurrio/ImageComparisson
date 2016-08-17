package main;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

import exception.DifferentSizeException;
import exception.NotAPictureException;
import image.Comparisser;
import image.Drawer;
import model.Circle;
import util.ImageUtil;

public class Main {
	public static void main(String[] args) {
		File file1 = new File("image1.png");
		File file2 = new File("image2.png");
		
		ImageUtil util = new ImageUtil();
		try {
			BufferedImage image1 = util.checkImage(file1);
			BufferedImage image2 = util.checkImage(file2);
			if (util.isTheSameSize(image1, image2)) {
				Comparisser compr = new Comparisser(image1, image2);
				List<Circle> circles = compr.compareImages();
				Drawer drawer = new Drawer(image2);
				drawer.fillDifferents(circles);
			}
		} catch (NotAPictureException ex) {
			System.out.println(ex.getMessage());
		} catch (DifferentSizeException ex) {
			System.out.println(ex.getMessage());
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		} 
	}
}
