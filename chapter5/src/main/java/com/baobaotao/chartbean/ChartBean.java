package com.baobaotao.chartbean;

import javax.swing.JPanel;

public class ChartBean extends JPanel{
	
	private float titilePosition = CENTER_ALIGNMENT;
	private boolean inverse;
	
	
	public float getTitilePosition() {
		return titilePosition;
	}
	public void setTitilePosition(float titilePosition) {
		this.titilePosition = titilePosition;
	}
	public boolean isInverse() {
		return inverse;
	}
	public void setInverse(boolean inverse) {
		this.inverse = inverse;
	}
	
	

}
