package com.app.sys.databaseloaders;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import com.app.entity.*;
import com.app.repository.RegionRepository;
import com.app.repository.SocietyRepository;
import com.app.repository.UserRepository;

@Component
@ComponentScan(basePackages={"com.app"})
public class DatabaseLoaderSocietyRegion implements CommandLineRunner { 

	private final SocietyRepository societyrepository;
	private final RegionRepository  regionrepository;
	@Autowired 
	public DatabaseLoaderSocietyRegion(SocietyRepository societyrepository,RegionRepository regionrepository) {
		this.societyrepository = societyrepository;
		this.regionrepository = regionrepository;
	}

	@Override
	public void run(String... strings) throws Exception {
			
	
		Society society = new Society();
		society.setId(1);
		society.setName("CAPACITACION");
		society.setNit("9999999999");
		society.setEnabled(true);
		
		this.societyrepository.save(society);
		society.setId(1);
		
		
		Region region = new Region();
		
		region.setRegion_id("FLORESTA");
		region.setName("Floresta");	
		region.setSociety(society);
		this.regionrepository.save(region);
		
		Region region2 = new Region();
		region2.setRegion_id("POBLADO");
		region2.setName("POBLADO");
		region2.setSociety(society);
		this.regionrepository.save(region2);
		
				
	}
}
