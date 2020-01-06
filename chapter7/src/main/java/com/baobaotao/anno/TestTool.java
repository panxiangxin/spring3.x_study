package com.baobaotao.anno;

import java.lang.reflect.Method;


public class TestTool {
	
	public static void main(String[] args) {
		Class clazz = ForumService.class;
		Method[] methods = clazz.getDeclaredMethods();
		System.out.println(methods.length);
		
		for (Method method : methods) {
			NeedTest needTest = method.getAnnotation(NeedTest.class);
			
			if(needTest!= null) {
				if(needTest.value()) {
					System.out.println(method.getName()+"需要测试");
				}else {
					System.out.println(method.getName()+"不需要测试");
				}
			}
		}
	}

}
