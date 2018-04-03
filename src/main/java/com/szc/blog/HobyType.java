/**
 * Copyright (c) 2006-2016 Huize Ltd. All Rights Reserved. 
 *  
 * This code is the confidential and proprietary information of   
 * Hzins. You shall not disclose such Confidential Information   
 * and shall use it only in accordance with the terms of the agreements   
 * you entered into with Huize,http://www.huize.com.
 *  
 */
package com.szc.blog;

/**
 * @author hz17052992
 * @date 2018年4月3日 上午10:39:23
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
