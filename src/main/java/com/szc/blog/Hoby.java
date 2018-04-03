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
 * @date 2018年4月3日 上午10:36:38
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
