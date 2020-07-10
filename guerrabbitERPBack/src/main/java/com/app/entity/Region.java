package com.app.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name = "tbl_region")
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
     
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "region_society_id", referencedColumnName = "id")
    private Society society;

    //***************************
    public void setSociety(Society society) {
        this.society = society;
        society.getRegions().add(this);
    }
    //***************************

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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Society getSociety() {
		return society;
	}
    
    
	
	
}
