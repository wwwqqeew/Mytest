package com.img;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class sss {
	public static void main(String args[]) {
		int[] rgb = new int[3];
		List<int[]> list = new ArrayList();
		
//		int[] readRgb = {171,232,163};//通顺
//		list.add(readRgb);
		
//		int[] readRgbHXMax = {255,159,25};//缓行深色
//		int[] readRgbHXMin = {255,210,147};//缓行浅色
//		list.add(readRgbHXMax);
//		list.add(readRgbHXMin);
		
//		int[] readRgbHXMax = {187,0,0};//严重拥堵深色
//		int[] readRgbHXMin = {238,191,191};//严重拥堵浅色
//		list.add(readRgbHXMax);
//		list.add(readRgbHXMin);
		
//		int[] readRgbHXMax = {242,48,48};//严重拥堵深色
		int[] readRgbHXMin = {245,91,91};//严重拥堵浅色
//		list.add(readRgbHXMax);
		list.add(readRgbHXMin);
		

		File file = new File("ken.png");
		BufferedImage bi = null;
		try {
			bi = ImageIO.read(file);
		} catch (Exception e) {
			e.printStackTrace();
		}

		int width = bi.getWidth();
		int height = bi.getHeight();
		int minx = bi.getMinX();
		int miny = bi.getMinY();
		System.out.println("width=" + width + ",height=" + height + ".");
		System.out.println("minx=" + minx + ",miniy=" + miny + ".");

		for (int i = minx; i < width; i++) {
			for (int j = miny; j < height; j++) {
				// System.out.print(bi.getRGB(jw, ih));
				int pixel = bi.getRGB(i, j);
				rgb[0] = (pixel & 0xff0000) >> 16;
				rgb[1] = (pixel & 0xff00) >> 8;
				rgb[2] = (pixel & 0xff);
				for (int k = 0; k < list.size(); k++) {
					if (rgb[0] == list.get(k)[0] && rgb[1] == list.get(k)[1] && rgb[2] == list.get(k)[2]) {
						System.out.println(pixel+" : i=" + i + ",j=" + j + ":(" + rgb[0] + ","+ rgb[1] + "," + rgb[2] + ")");
					}
				}

			}
		}

	}

}