package com.steventk.jpastudy;

public class BeanWithCompositeKey {

	private CompositeKeyPK key;
	private String name;
	
	public Long getKey1() {
		return key.getKey1();
	}
	public void setKey1(Long key1) {
		key.setKey1(key1);
	}
	public Long getKey2() {
		return key.getKey2();
	}
	public void setKey2(Long key2) {
		key.setKey2(key2);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public CompositeKeyPK getKey() {
		return key;
	}
	public void setKey(CompositeKeyPK key) {
		this.key = key;
	}
	
	
}
