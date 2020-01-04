package com.baobaotao.event;

import org.springframework.context.ApplicationListener;

public class MailSendListener implements ApplicationListener<MailSendEvent>{

	public void onApplicationEvent(MailSendEvent arg0) {
		MailSendEvent mEvent = (MailSendEvent)arg0;
		System.out.println("MailSenderListener:向"+mEvent.getTo()+"发送了一封邮件。");
		
	}

}
