package com.baobaotao.chartbean;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.beans.SimpleBeanInfo;

public class ChartBeanBeanInfo extends SimpleBeanInfo{

	@Override
	public PropertyDescriptor[] getPropertyDescriptors() {
		
		try {
			PropertyDescriptor titlePositionDescriptor = new PropertyDescriptor("titlePosition", ChartBean.class);
			titlePositionDescriptor.setPropertyEditorClass(TitlePositionEditor.class);
			
			PropertyDescriptor inverseDescriptor = new PropertyDescriptor("inverse", ChartBean.class);
			inverseDescriptor.setPropertyEditorClass(InverseEditor.class);
			
			return new PropertyDescriptor[] {titlePositionDescriptor,inverseDescriptor};
		} catch (IntrospectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
}
