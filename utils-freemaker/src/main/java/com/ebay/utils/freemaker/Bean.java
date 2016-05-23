package com.ebay.utils.freemaker;

public class Bean {
	private String column;
	private String field;

	public Bean() {
		super();
	}

	public Bean(String column, String field) {
		super();
		this.column = column;
		this.field = field;
	}

	public String getColumn() {
		return column;
	}

	public void setColumn(String column) {
		this.column = column;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

}
