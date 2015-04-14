package com.tk.youindex.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.GenericGenerator;

/**
 * Persistent Object - Create ID's for all domain Objects
 * @author Trim Kadriu <trim.kadriu@gmail.com>
 */
@SuppressWarnings("serial")
@MappedSuperclass
public abstract class PersistentObject implements Serializable {

	protected String id;

	@Id
	@Column(name = "id", length = 16)
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
}
