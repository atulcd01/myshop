package com.app.ecom.category;

import java.io.Serializable;

public class Filter implements Serializable {
	
	int prize;
	
	boolean flag =false;

	

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public int getPrize() {
		return prize;
	}

	public void setPrize(int prize) {
		this.prize = prize;
	}


}
