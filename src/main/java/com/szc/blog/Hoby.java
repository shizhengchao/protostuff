package com.szc.blog;

/**
 * @author shizhengchao
 * @version
 */
public class Hoby {

    public Hoby(HobyType type) {
	this.type = type;
    }

    private HobyType type;

    public HobyType getType() {
	return type;
    }

    public void setType(HobyType type) {
	this.type = type;
    }

    @Override
    public String toString() {
	return type.toString();
    }
}
