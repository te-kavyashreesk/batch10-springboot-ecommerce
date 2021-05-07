 
package com.te.springbootecomm.bean;
import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.Data;

@Data
@JsonRootName("response")
@JsonPropertyOrder({"status" , "msg"})
@XmlRootElement(name = "response")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ItemRespone implements Serializable{

	@JsonProperty("status")
	@XmlElement(name = "status-code")
	private int statusCode;
	
	
	private String  msg;
	
	@JsonProperty("iteminfo")
	@XmlElement(name = "iteminfo")
	private ItemInfoBean bean;

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public ItemInfoBean getBean() {
		return bean;
	}

	public void setBean(ItemInfoBean bean) {
		this.bean = bean;
	}

	@Override
	public String toString() {
		return "ItemRespone [statusCode=" + statusCode + ", msg=" + msg + ", bean=" + bean + "]";
	}
	

	private List<ItemInfoBean> infobeans;
	public List<ItemInfoBean> getItemInfos(){
		return infobeans;
	}
	public void setItemInfos(List<ItemInfoBean> infobeans) {
		this.infobeans=infobeans;
	}
	
}

	
	
	
	