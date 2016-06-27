package com.img;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

public class createImg {

	/**
	 * 获取图片RGB
	 * @param image
	 * @param x
	 * @param y
	 * @return
	 */
	public List<Integer> getRGB(BufferedImage image, int x, int y) {

		List<Integer> rgb = new ArrayList<Integer>();
		if (image != null && x <= image.getWidth() && y <= image.getHeight()) {
			for (int h = 0; h < y; h++) {
				for (int w = 0; w < x; w++) {
					// 获得w,h坐标的颜色
					int pixel = image.getRGB(w, h);
					//畅通      pixel >= -15220992 && -11153340 >= pixel  
					//缓行   pixel >= -24807 && -11629 >= pixel  
					//严重 拥堵  pixel == -4521984   
					
					if ( pixel >= -905168 && -697509 >= pixel) {
						rgb.add(pixel);
					}else{
						rgb.add(0);
					}
				}
			}
		}
		return rgb;
	}

	/**
	 * 图片生成
	 * @param rbg 颜色
	 * @param width 
	 * @param height
	 */
	public static void paint(Integer[] rbg, int width, int height) {
		File file = new File("D:/image.jpg");
		BufferedImage bi = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_RGB);
		Graphics2D g2 = (Graphics2D) bi.getGraphics();

		for (int h = 0; h < height; h++) {
			for (int w = 0; w < width; w++) {
				int color = rbg[w + width * h];
				Color c = new Color(color);
				g2.setColor(c);
				g2.drawLine(w, h, w + 1, h + 1);
			}
		}
		try {
			ImageIO.write(bi, "jpg", file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		try {
			createImg r = new createImg();
			File f = new File("ken.png");
			BufferedImage bi = ImageIO.read(f);
			int width = bi.getWidth();
			int height = bi.getHeight();
			List<Integer> l = null;
			Integer[] rbg = new Integer[width * height];
			l = r.getRGB(bi, width, height);
			for (int i = 0; i < width * height; i++) {
				rbg[i] = l.get(i);
			}
			paint(rbg, width, height);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}