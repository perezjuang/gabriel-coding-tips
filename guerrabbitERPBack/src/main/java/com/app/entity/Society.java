package com.app.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "tbl_society")
public class Society implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	@Column(name = "id")
	private long id;

	// @Column(name = "society_key", length = 100, nullable = false, unique = true)
	// private String society_key;

	@Column(name = "name")
	private String name;

	@Column(name = "nit")
	private String nit;

	@Column(name = "enabled")
	private Boolean enabled;

	@Column(name = "date_update")
	private Date date_update;

	@OneToMany(mappedBy = "society", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	private Set<Region> regions;

	// ****************************
	public Set<Region> getRegions() {
		return regions;
	}

	public void setRegions(Set<Region> regions) {
		this.regions = regions;
		for (Region region : regions) {
			region.setSociety(this);
		}
	}

	public Society(long id, String name, String nit, Boolean enabled, Date date_update, Set<Region> regions) {
		this.id = id;
		this.name = name;
		this.nit = nit;
		this.enabled = enabled;
		this.date_update = date_update;
		this.regions = regions;
		this.regions = new HashSet<>();
	}

	public Society() {
		regions = new HashSet<>();
	}
	// *******************************

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

}
