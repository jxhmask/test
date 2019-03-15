package qrcode;

public class QRtest {

    public static void main(String[] args){
        TwoDimensionCode td = new TwoDimensionCode();
//        td.encoderQRCode("this is a test","d://1.jpg","jpg",12);
//        td.encoderQRCode("this is a test","d://2.jpg","jpg",12);
//        td.encoderQRCode("this is a test","d://3.jpg","jpg",12);
        td.encoderQRCode("1","d://11.jpg","jpg",12);
    }
}
