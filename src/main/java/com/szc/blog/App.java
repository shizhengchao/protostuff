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

import java.util.Arrays;

/**
 * @author hz17052992
 * @date 2018年4月3日 上午10:21:56
 * @version
 */
public class App {

    public static void main(String[] args) {
	UserInfo user = new UserInfo(1, "4527813541884216844x", "李大爷", "北京");
	Hoby hoby = new Hoby(HobyType.READING);
	user.setHoby(hoby);
	
	byte[] bit = SerializationUtil.serialize(user);
	System.out.println(Arrays.toString(bit));
	
	UserInfo lidaye = SerializationUtil.deserialize(bit, UserInfo.class);
	System.out.println(lidaye.toString());
    }
}
