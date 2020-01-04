package com.baobaotao.ioc;

public class MoAttack implements ActorArrangable{
	
	private GeLi geli;

//	public void cityGateAsk() {
//		//①演员直接侵入剧本
//		LiuDeHua ldh = new LiuDeHua();
//		ldh.responseAsk("墨者革离");
//	}
	
//	//注入革离的具体扮演者 构造方法注入
//	public MoAttack(GeLi geli) {
//		this.geli=geli;
//	}
	
//	//属性注入方法
//	public void setGeli(GeLi geli) {
//		this.geli=geli;
//	}
	
	//实现接口方法
	@Override
	public void injectGeli(GeLi geli) {
		this.geli = geli;
	}
	
	public void cityGateAsk() {
		geli.responseAsk("墨者革离！");
		
	}

}
