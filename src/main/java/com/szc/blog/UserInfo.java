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
 * @date 2018年4月3日 上午10:20:46
 * @version
 */
public class UserInfo {

    public UserInfo(Integer id, String cardId, String name, String address) {
	this.id = id;
	this.cardId = cardId;
	this.name = name;
	this.address = address;
    }

    private Integer id;

    private String cardId;

    private String name;

    private String address;

    private Hoby hoby;

    public Integer getId() {
	return id;
    }

    public String getCardId() {
	return cardId;
    }

    public String getName() {
	return name;
    }

    public String getAddress() {
	return address;
    }

    public void setId(Integer id) {
	this.id = id;
    }

    public void setCardId(String cardId) {
	this.cardId = cardId;
    }

    public void setName(String name) {
	this.name = name;
    }

    public void setAddress(String address) {
	this.address = address;
    }

    public Hoby getHoby() {
	return hoby;
    }

    public void setHoby(Hoby hoby) {
	this.hoby = hoby;
    }

    @Override
    public String toString() {
	StringBuilder sb = new StringBuilder();
	sb.append("my name is ").append(name).append(" and I come from ").append(address).append(" China, ");
	if(this.hoby != null) {
	    sb.append(hoby).append(" is my greatest hobby");
	}
	return sb.toString();
    }

}
