package com.itcast.basic.web.util;

import com.swetake.util.Qrcode;
import jp.sourceforge.qrcode.QRCodeDecoder;
import jp.sourceforge.qrcode.data.QRCodeImage;
import jp.sourceforge.qrcode.exception.DecodingFailedException;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.*;

/**
 * Created by treey.qian on 2018/5/30.
 * 构造二维码工具
 */
public final class TowCodeCreateUtil {

    //二维码 SIZE
    private static final int CODE_IMG_SIZE = 235;

    // LOGO SIZE (为了插入图片的完整性，我们选择在最中间插入，而且长宽建议为整个二维码的1/7至1/4)
    private static final int INSERT_IMG_SIZE = CODE_IMG_SIZE / 5;


    /**
     * 本地生成二维码(QRCode)图片
     *
     * @param content       存储内容
     * @param imgPath       二维码图片存储路径
     * @param imgType       图片类型
     * @param insertImgPath logo图片路径
     */
    public static void encoderQRCode(String content, String imgPath, String imgType, String insertImgPath) {
        try {
            BufferedImage bufImg = qRCodeCommon(content, imgType, insertImgPath);

            File imgFile = new File(imgPath);
            if (!imgFile.exists()) {
                imgFile.mkdirs();
            }
            // 生成二维码QRCode图片
            ImageIO.write(bufImg, imgType, imgFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 生成二维码(QRCode)图片
     *
     * @param content 存储内容
     * @param output  输出流
     * @param imgType 图片类型
     */
    public static void encoderQRCode(String content, OutputStream output, String imgType) {
        try {
            BufferedImage bufImg = qRCodeCommon(content, imgType, null);
            // 生成二维码QRCode图片
            ImageIO.write(bufImg, imgType, output);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 解析二维码（QRCode）
     *
     * @param imgPath 图片路径
     * @return
     */
    public static String decoderQRCode(String imgPath) {
        // QRCode 二维码图片的文件
        File imageFile = new File(imgPath);
        BufferedImage bufImg = null;
        String content = null;
        try {
            bufImg = ImageIO.read(imageFile);
            QRCodeDecoder decoder = new QRCodeDecoder();
            content = new String(decoder.decode(new TwoDimensionCodeImage(bufImg)), "utf-8");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (DecodingFailedException dfe) {
            dfe.printStackTrace();
        }
        return content;
    }

    /**
     * 解析二维码（QRCode）
     *
     * @param input 输入流
     * @return
     */
    public static String decoderQRCode(InputStream input) {
        BufferedImage bufImg = null;
        String content = null;
        try {
            bufImg = ImageIO.read(input);
            QRCodeDecoder decoder = new QRCodeDecoder();
            content = new String(decoder.decode(new TwoDimensionCodeImage(bufImg)), "utf-8");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (DecodingFailedException dfe) {
            dfe.printStackTrace();
        }
        return content;
    }

    /**
     * 生成二维码
     *
     * @param content 二维码图片包含信息
     * @param imgType 图片格式
     * @param imgPath logo文件路径
     * @return 二维码图片流
     */
    public static BufferedImage qRCodeCommon(String content, String imgType, String imgPath) {
        BufferedImage bufImg = null;
        try {
            Qrcode qrcodeHandler = new Qrcode();
            // 设置二维码排错率，可选L(7%)、M(15%)、Q(25%)、H(30%)，排错率越高可存储的信息越少，但对二维码清晰度的要求越小
            qrcodeHandler.setQrcodeErrorCorrect('M');
            qrcodeHandler.setQrcodeEncodeMode('B');
            // 设置设置二维码尺寸，取值范围1-40，值越大尺寸越大，可存储的信息越大
            qrcodeHandler.setQrcodeVersion(15);
            // 获得内容的字节数组，设置编码格式
            byte[] contentBytes = content.getBytes("utf-8");
            // 图片尺寸
            int imgSize = CODE_IMG_SIZE;
            bufImg = new BufferedImage(imgSize, imgSize, BufferedImage.TYPE_INT_RGB);
            Graphics2D gs = bufImg.createGraphics();
            // 设置背景颜色
            gs.setBackground(Color.WHITE);
            gs.clearRect(0, 0, imgSize, imgSize);

            // 设定图像颜色> BLACK
            gs.setColor(Color.BLACK);
            // 设置偏移量，不设置可能导致解析出错
            final int pixoff = 2;
            final int sz = 3;
            // 输出内容> 二维码
            if (contentBytes.length > 0 && contentBytes.length < 800) {
                boolean[][] codeOut = qrcodeHandler.calQrcode(contentBytes);
                for (int i = 0; i < codeOut.length; i++) {
                    for (int j = 0; j < codeOut.length; j++) {
                        if (codeOut[j][i]) {
                            gs.fillRect(j * sz + pixoff, i * sz + pixoff, sz, sz);
                        }
                    }
                }
            } else {
                throw new Exception("QRCode content bytes length = " + contentBytes.length + " not in [0, 800].");
            }
            //嵌入logo
            if (imgPath != null) {
                insertImage(bufImg, imgPath, true);
            }
            gs.dispose();
            bufImg.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bufImg;
    }

    /**
     * 插入logo图片到二维码中
     *
     * @param source       源二维码图片
     * @param imgPath      logo图片路径
     * @param needCompress logo图片是否需要压缩
     * @throws Exception logo图片不存在时抛出
     */
    private static void insertImage(BufferedImage source, String imgPath,
                                    boolean needCompress) throws Exception {
        File file = new File(imgPath);
        if (!file.exists()) {
            throw new FileNotFoundException("" + imgPath + "   该文件不存在！");
        }
        Image src = ImageIO.read(new File(imgPath));
        int width = src.getWidth(null);
        int height = src.getHeight(null);
        if (needCompress) { // 压缩LOGO
            if (width > INSERT_IMG_SIZE) {
                width = INSERT_IMG_SIZE;
            }
            if (height > INSERT_IMG_SIZE) {
                height = INSERT_IMG_SIZE;
            }
            Image image = src.getScaledInstance(width, height,
                    Image.SCALE_SMOOTH);
            BufferedImage tag = new BufferedImage(width, height,
                    BufferedImage.TYPE_INT_RGB);
            Graphics g = tag.getGraphics();
            g.drawImage(image, 0, 0, null); // 绘制缩小后的图
            g.dispose();
            src = image;
        }
        // 插入LOGO
        Graphics2D graph = source.createGraphics();
        int x = (CODE_IMG_SIZE - width) / 2;
        int y = (CODE_IMG_SIZE - height) / 2;
        graph.drawImage(src, x, y, width, height, null);
        Shape shape = new RoundRectangle2D.Float(x, y, width, width, 6, 6);
        graph.setStroke(new BasicStroke(3f));
        graph.draw(shape);
        graph.dispose();
    }

    private TowCodeCreateUtil() {

    }


    private static class TwoDimensionCodeImage implements QRCodeImage {

        BufferedImage bufImg;

        public TwoDimensionCodeImage(BufferedImage bufImg) {
            this.bufImg = bufImg;
        }

        @Override
        public int getHeight() {
            return bufImg.getHeight();
        }

        @Override
        public int getPixel(int x, int y) {
            return bufImg.getRGB(x, y);
        }

        @Override
        public int getWidth() {
            return bufImg.getWidth();
        }

    }
}
