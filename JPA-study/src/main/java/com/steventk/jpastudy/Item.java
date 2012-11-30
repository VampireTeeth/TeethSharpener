package com.steventk.jpastudy;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="`ITEM`")
public class Item {

	@Id
	@GeneratedValue
	@Column(name="`ITEM_ID`")
	private Long id;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
