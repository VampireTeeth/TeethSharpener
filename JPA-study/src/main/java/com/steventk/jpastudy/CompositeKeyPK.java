package com.steventk.jpastudy;

import java.io.Serializable;

public class CompositeKeyPK implements Serializable{
	private Long key1;
	private Long key2;
	public Long getKey1() {
		return key1;
	}
	public void setKey1(Long key1) {
		this.key1 = key1;
	}
	public Long getKey2() {
		return key2;
	}
	public void setKey2(Long key2) {
		this.key2 = key2;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((key1 == null) ? 0 : key1.hashCode());
		result = prime * result + ((key2 == null) ? 0 : key2.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CompositeKeyPK other = (CompositeKeyPK) obj;
		if (key1 == null) {
			if (other.key1 != null)
				return false;
		} else if (!key1.equals(other.key1))
			return false;
		if (key2 == null) {
			if (other.key2 != null)
				return false;
		} else if (!key2.equals(other.key2))
			return false;
		return true;
	}
	
	
	
}
