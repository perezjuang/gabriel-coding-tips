package com.app.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name = "tbl_societis")
public class Society implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(  strategy= GenerationType.AUTO,   generator="native")
	@GenericGenerator( name = "native",  strategy = "native"  )
	@Column(name = "id")
	private long id;
	
	@Column(name="society_key", length=100, nullable=false, unique=true)
	private String society_key;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "nit")
	private String nit;
	
	@Column(name = "enabled")
	private Boolean enabled;
	
	@Column(name = "date_update")
	private Date date_update;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getSociety_key() {
		return society_key;
	}

	public void setSociety_key(String society_key) {
		this.society_key = society_key;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNit() {
		return nit;
	}

	public void setNit(String nit) {
		this.nit = nit;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public Date getDate_update() {
		return date_update;
	}

	public void setDate_update(Date date_update) {
		this.date_update = date_update;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date_update == null) ? 0 : date_update.hashCode());
		result = prime * result + ((enabled == null) ? 0 : enabled.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((nit == null) ? 0 : nit.hashCode());
		result = prime * result + ((society_key == null) ? 0 : society_key.hashCode());
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
		Society other = (Society) obj;
		if (date_update == null) {
			if (other.date_update != null)
				return false;
		} else if (!date_update.equals(other.date_update))
			return false;
		if (enabled == null) {
			if (other.enabled != null)
				return false;
		} else if (!enabled.equals(other.enabled))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (nit == null) {
			if (other.nit != null)
				return false;
		} else if (!nit.equals(other.nit))
			return false;
		if (society_key == null) {
			if (other.society_key != null)
				return false;
		} else if (!society_key.equals(other.society_key))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Society [id=" + id + ", society_key=" + society_key + ", name=" + name + ", nit=" + nit + ", enabled="
				+ enabled + ", date_update=" + date_update + "]";
	}

	public Society(long id, String society_key, String name, String nit, Boolean enabled, Date date_update) {
	
		this.id = id;
		this.society_key = society_key;
		this.name = name;
		this.nit = nit;
		this.enabled = enabled;
		this.date_update = date_update;
	}

	public Society() {
		super();
		// TODO Auto-generated constructor stub
	}
     
}
