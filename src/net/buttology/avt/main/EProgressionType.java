package net.buttology.avt.main;

public enum EProgressionType {
	xPlus("x+", 0),
	xx("xx", 2),
	xxx("xxx", 3),
	xxxx("xxxx", 4),
	xxxxx("xxxxx", 5);
	
	private String display;
	private int count;
	
	private EProgressionType(String display, int count) {
		this.display = display;
		this.count = count;
	}
	
	public String toString() {
		return display;
	}
	
	public int getCount() {
		return count;
	}
}
