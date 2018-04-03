package com.szc.blog;

import java.util.Arrays;

/**
 * @author shizhengchao
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
