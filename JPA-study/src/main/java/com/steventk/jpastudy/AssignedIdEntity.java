package com.steventk.jpastudy;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="`ASSIGNED_ID_ENTITY`")
public class AssignedIdEntity {

	private Long id;
	private String name;

	@Id
	@Column(name="`ID`", nullable=false, length=3)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name="`NAME`")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
