package com.steventk.jpastudy;

import java.util.HashSet;
import java.util.Set;

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
	
	private Set<String> images = new HashSet<String>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<String> getImages() {
		return images;
	}

	public void setImages(Set<String> images) {
		this.images = images;
	}
	
	public void addImage(String image){
		this.images.add(image);
	}
	
}
