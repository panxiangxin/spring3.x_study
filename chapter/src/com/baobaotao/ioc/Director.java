package com.baobaotao.ioc;

public class Director {
	
	public void direct() {
		
		//指定角色的扮演者
		GeLi geli = new LiuDeHua();
		//注入具体扮演者到剧本
//		MoAttack moAttack = new MoAttack(geli);
		MoAttack moAttack = new MoAttack();
		//调用setter方法注入
//		moAttack.setGeli(geli);
		//接口注入
		moAttack.injectGeli(geli);
		moAttack.cityGateAsk();
	}

}
