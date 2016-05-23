/**
 * 
 */
package com.xienan.javaserilize;

import java.io.Serializable;

/**
 * @author nan.xie
 * @date 2014-6-24 下午6:12:02
 */
public class Serilizabled implements Serializable{

	private static final long serialVersionUID = -7321748172172629755L;
	private Noserizable noserizable;
	private boolean bool;

	
	public boolean isBool() {
		return bool;
	}

	public void setBool(boolean bool) {
		this.bool = bool;
	}

	public Noserizable getNoserizable() {
		return noserizable;
	}

	public void setNoserizable(Noserizable noserizable) {
		this.noserizable = noserizable;
	}
}
