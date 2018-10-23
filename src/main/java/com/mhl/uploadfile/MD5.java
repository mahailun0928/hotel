package com.mhl.uploadfile;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
public class MD5 {
	private MessageDigest md5 = null;
	private StringBuffer digestBuffer = null;
	public MD5() {
		try {
			md5 = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		digestBuffer = new StringBuffer();
	}
	public String md5crypt(String s) {
		digestBuffer.setLength(0);
		byte abyte0[] = md5.digest(s.getBytes());
		for (int i = 0; i < abyte0.length; i++){
			digestBuffer.append(toHex(abyte0[i]));
		}
		return digestBuffer.toString();
	}
	public String toHex(byte one) {
		String HEX = "0123456789ABCDEF";
		char[] result = new char[2];
		result[0] = HEX.charAt((one & 0xf0) >> 4);
		result[1] = HEX.charAt(one & 0x0f);
		String mm = new String(result);
		return mm;
	}
	public static void main(String[] args) {
//		MD5 m=new MD5();
//		String ma=m.md5crypt("1234");
//		System.out.println(ma);
		String a="2018-08-08 22:31:34";
		String a1=a.substring(0,10);
		String[] a2=a1.split("-");
		String a3="";
		for (String s : a2) {
			a3=a3+s;
		}
		int a4=Integer.parseInt(a3);
		System.out.println(a4-20180807);
		
	}
}
