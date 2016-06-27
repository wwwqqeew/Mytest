package com.img;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;
public class ImgTurn {

	
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		String imgName = "QQ截图20151217173342.png";
		String imgNameWater = "6.png";
		String imgUrl = "D:/imgTest";
		int height = 200;
		int width = 300;
		float bili = 0.5f;
		int rotate = 90;
//	    test1(imgName, imgUrl, height, width); //固定高宽，比例不变
//		testCcale(imgName, imgUrl, bili);// 按照比例缩放
//		testHW(imgName, imgUrl, height, width);//按照指定高宽缩放
//		testRotateHW(imgName, imgUrl, height, width, rotate);//按照角度旋转，同时支持固定高宽，比例不变
//	    testShuiYing(imgName, imgNameWater, imgUrl); //(位置，水印图，透明度)
//		imgTailor(imgName, imgUrl, height, width);//图片裁剪
//		imgTailor2(imgName, imgUrl, height, width);//图片裁剪坐标固定
//		imgTurn(imgName, imgUrl);  //图片 格式修改 
//		 test3(imgName, imgUrl); //输入流
		//asBufferedImage() 返回BufferedImage  
		BufferedImage thumbnail = Thumbnails.of(imgUrl+"/"+imgName)   
		        .size(1280, 1024)  
		        .asBufferedImage();  
		ImageIO.write(thumbnail, "jpg", new File(imgUrl+"/2"+imgName)); 
	}
	/**
	 * 输入流
	 * @param imgName
	 * @param imgUrl
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static void test3(String imgName, String imgUrl)
			throws FileNotFoundException, IOException {
		//toOutputStream(流对象)  
	    OutputStream os = new FileOutputStream(imgUrl+"/"+imgName);  
	    Thumbnails.of(imgUrl+"/"+imgName)   
	            .size(1280, 1024)  
	            .toOutputStream(os);
	}

	/**
	 * 图片 格式修改 
	 * @param imgName
	 * @param imgUrl
	 * @throws IOException
	 */
	public static void imgTurn(String imgName, String imgUrl)
			throws IOException {
		Thumbnails.of(imgUrl+"/"+imgName)   
        .size(1280, 1024)  
        .outputFormat("png")   
        .toFile(imgUrl+"/图片格式修改_png");
	}

	/**
	 * 图片裁剪坐标固定
	 * @param imgName
	 * @param imgUrl
	 * @param height
	 * @param width
	 * @throws IOException
	 */
	public static void imgTailor2(String imgName, String imgUrl, int height,
			int width) throws IOException {
		Thumbnails.of(imgUrl+"/"+imgName).
		sourceRegion(200,200,200,200).
		size(width, height).
		keepAspectRatio(false).//保持高宽比
		toFile(imgUrl+"/图片裁剪坐标固定_"+imgName);
	}

	/**
	 * 裁剪，按照尺寸
	 * @param imgName
	 * @param imgUrl
	 * @param height
	 * @param width
	 * @throws IOException
	 */
	public static void imgTailor(String imgName, String imgUrl, int height,
			int width) throws IOException {
		Thumbnails.of(imgUrl+"/"+imgName).
		sourceRegion(Positions.BOTTOM_RIGHT, 200, 233).
		size(width, height).
		keepAspectRatio(false).//保持高宽比
		toFile(imgUrl+"/图片裁剪_"+imgName);
	}

	/**
	 * 水印
	 * @param imgName
	 * @param imgNameWater
	 * @param imgUrl
	 * @throws IOException
	 */
	public static void testShuiYing(String imgName, String imgNameWater,
			String imgUrl) throws IOException {
		//watermark(位置，水印图，透明度)  
		Thumbnails.of(imgUrl+"/"+imgName)   
	            .size(1280, 1024)  
	            .watermark(Positions.BOTTOM_RIGHT, ImageIO.read(new File(imgUrl+"/"+imgNameWater)), 1f)   
	            .outputQuality(1f)   
	            .toFile(imgUrl+"/加图片水印_"+imgName);
	}

	/**
	 * 按照角度旋转，同时支持固定高宽，比例不变
	 * @param imgName
	 * @param imgUrl
	 * @param height
	 * @param width
	 * @param rotate
	 * @throws IOException
	 */
	public static void testRotateHW(String imgName, String imgUrl, int height,
			int width, int rotate) throws IOException {
		Thumbnails.of(imgUrl+"/"+imgName).rotate(rotate).size(height, width).toFile(imgUrl+"/按角度旋转_"+imgName);
	}

	/**
	 * 按照指定高宽缩放
	 * @param imgName
	 * @param imgUrl
	 * @param height
	 * @param width
	 * @throws IOException
	 */
	public static void testHW(String imgName, String imgUrl, int height,
			int width) throws IOException {
		Thumbnails.of(imgUrl+"/"+imgName).size(height, width).keepAspectRatio(false).toFile(imgUrl+"/按照高宽缩放_"+imgName);
	}

	/**
	 * 按照比例缩放
	 * @param imgName
	 * @param imgUrl
	 * @param bili
	 * @throws IOException
	 */
	public static void testCcale(String imgName, String imgUrl, float bili)
			throws IOException {
		Thumbnails.of(imgUrl+"/"+imgName).scale(bili).toFile(imgUrl+"/按照比例缩放_"+imgName);
	}

	/**
	 * 固定高宽，比例不变
	 * @param imgName
	 * @param imgUrl
	 * @param height
	 * @param width
	 * @throws IOException
	 */
	public static void test1(String imgName, String imgUrl, int height,
			int width) throws IOException {
		/*   
	     * 若图片横比200小，高比300小，不变   
	     * 若图片横比200小，高比300大，高缩小到300，图片比例不变   
	     * 若图片横比200大，高比300小，横缩小到200，图片比例不变   
	     * 若图片横比200大，高比300大，图片按比例缩小，横为200或高为300   
	     */   
	    Thumbnails.of(imgUrl+"/"+imgName).size(height, width).toFile(imgUrl+"/固定高宽比例不变_"+imgName);
	}

}
