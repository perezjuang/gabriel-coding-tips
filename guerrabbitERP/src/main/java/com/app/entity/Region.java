package com.app.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name = "tbl_regions")
public class Region implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(  strategy= GenerationType.AUTO,   generator="native")
	@GenericGenerator( name = "native",  strategy = "native"  )
	@Column(name = "id")
	private long id;
	
	@Column(name="region_id", length=100, nullable=false, unique=true)
	private String region_id;
	
	@Column(name = "name")
	private String name;
		
	@Column(name = "date_update")
	private Date date_update;
     
	@ManyToOne
	@JoinColumn(name="society_id", referencedColumnName="id")
	private Society society_id;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getRegion_id() {
		return region_id;
	}

	public void setRegion_id(String region_id) {
		this.region_id = region_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDate_update() {
		return date_update;
	}

	public void setDate_update(Date date_update) {
		this.date_update = date_update;
	}

	public Society getSociety_id() {
		return society_id;
	}

	public void setSociety_id(Society society_id) {
		this.society_id = society_id;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date_update == null) ? 0 : date_update.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((region_id == null) ? 0 : region_id.hashCode());
		result = prime * result + ((society_id == null) ? 0 : society_id.hashCode());
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
		Region other = (Region) obj;
		if (date_update == null) {
			if (other.date_update != null)
				return false;
		} else if (!date_update.equals(other.date_update))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (region_id == null) {
			if (other.region_id != null)
				return false;
		} else if (!region_id.equals(other.region_id))
			return false;
		if (society_id == null) {
			if (other.society_id != null)
				return false;
		} else if (!society_id.equals(other.society_id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Region [id=" + id + ", region_id=" + region_id + ", name=" + name + ", date_update=" + date_update
				+ ", society_id=" + society_id + "]";
	}

	public Region(long id, String region_id, String name, Date date_update, Society society_id) {
		
		this.id = id;
		this.region_id = region_id;
		this.name = name;
		this.date_update = date_update;
		this.society_id = society_id;
	}

	public Region() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
