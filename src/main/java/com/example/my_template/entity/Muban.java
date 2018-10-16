package com.example.my_template.entity;

import java.util.Map;

import com.alibaba.fastjson.annotation.JSONField;

public class Muban {
      @JSONField(ordinal=1)
	  private String touser;
      @JSONField(ordinal=2)
	  private String template_id;
      @JSONField(ordinal=3)
	  private String page;
      @JSONField(ordinal=4)
	  private String form_id;
      @JSONField(ordinal=5)
	  private Map<String, Object> data;
      @JSONField(ordinal=6)
	  private String emphasis_keyword;
	public String getTouser() {
		return touser;
	}
	public void setTouser(String touser) {
		this.touser = touser;
	}
	public String getTemplate_id() {
		return template_id;
	}
	public void setTemplate_id(String template_id) {
		this.template_id = template_id;
	}
	public String getPage() {
		return page;
	}
	public void setPage(String page) {
		this.page = page;
	}
	public String getForm_id() {
		return form_id;
	}
	public void setForm_id(String form_id) {
		this.form_id = form_id;
	}

	public Map<String, Object> getData() {
		return data;
	}
	public void setData(Map<String, Object> data) {
		this.data = data;
	}
	public String getEmphasis_keyword() {
		return emphasis_keyword;
	}
	public void setEmphasis_keyword(String emphasis_keyword) {
		this.emphasis_keyword = emphasis_keyword;
	}
	@Override
	public String toString() {
		return "[touser=" + touser + ", template_id=" + template_id + ", page=" + page + ", form_id=" + form_id
				+ ", data=" + data + ", emphasis_keyword=" + emphasis_keyword + "]";
	}
	  


	     

	  

	      
	      
	 

	   
	 

	 

	 

	
	
	
	
	
}
