package com.baobaotao.i18;

import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.NumberFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.ResourceBundle;

import org.apache.bcel.generic.NEW;

public class LocaleSample {

	public void numberFormat() {
		Locale locale = new Locale("zh","CN");
		NumberFormat currFormat = NumberFormat.getCurrencyInstance(locale);
		
		double dmt = 1234.677;
		System.out.println(currFormat.format(dmt));
	}
	
	public void dateFormat() {
		
		Locale locale = new Locale("zh","CN");
		Date date = new Date();
		DateFormat dFormat = DateFormat.getDateInstance(DateFormat.MEDIUM,locale);
		System.out.println(dFormat.format(date));
	}
	
	public void messageFormat() {
		
		Object[] params = {"John", new GregorianCalendar().getTime(),1.0E3};
		String pattern1 = "{0}，你好！你于{1}在工商银行存入{2} 元。";
		String pattern2 = "At {1,time,short} On{1,date,long}，{0} paid {2,number,currency}.";
		
		String msg1 = MessageFormat.format(pattern1,params);
		MessageFormat mf = new MessageFormat(pattern2,Locale.US);
		String msg2 = mf.format(params);
		System.out.println(msg1);
		System.out.println(msg2);
	}
	
	public void resourceBoundle() {
		
		ResourceBundle rb1 = ResourceBundle.getBundle("com/baobaotao/i18/resource",Locale.US);
		ResourceBundle rb2 = ResourceBundle.getBundle("com/baobaotao/i18/resource",Locale.CHINA);

		System.out.println("us:"+rb1.getString("greeting.morning"));
		System.out.println("cn:"+rb2.getString("greeting.morning"));
	}
	
	public void resourceBundle2() {
		ResourceBundle rb1 = ResourceBundle.getBundle("com/baobaotao/i18/fmt_resource",Locale.US);
		ResourceBundle rb2 = ResourceBundle.getBundle("com/baobaotao/i18/fmt_resource",Locale.CHINA);
		
		Object[] params = {"John", new GregorianCalendar().getTime()};
		
		String str1 = new MessageFormat(rb2.getString("greeting.common"),Locale.CHINA).format(params);
		String str2 = new MessageFormat(rb1.getString("greeting.common"),Locale.US).format(params);
		String str3 = new MessageFormat(rb2.getString("greeting.afternoon"),Locale.CHINA).format(params);
		
		System.out.println(str1);
		System.out.println(str2);
		System.out.println(str3);
	}
	
	public static void main(String[] args) {
		
		LocaleSample localeSample = new LocaleSample();
		localeSample.numberFormat();
		localeSample.dateFormat();
		localeSample.messageFormat();
		localeSample.resourceBoundle();
		localeSample.resourceBundle2();
	}
}
