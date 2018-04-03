package com.szc.blog;

/**
 * @author shizhengchao
 * @version
 */
public enum HobyType {

    SPORT("sport"), MUSIC("music"), READING("reading");

    private String title;

    HobyType(String title) {
	this.title = title;
    }

    @Override
    public String toString() {
	return title;
    }
}
