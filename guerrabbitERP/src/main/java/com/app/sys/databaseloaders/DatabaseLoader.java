package com.app.sys.databaseloaders;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import com.app.entity.*;
import com.app.repository.EmployeeRepository;

@Component
@ComponentScan(basePackages={"com.app"})
public class DatabaseLoader implements CommandLineRunner { 

	private final EmployeeRepository repository;

	@Autowired 
	public DatabaseLoader(EmployeeRepository repository) {
		this.repository = repository;
	}

	@Override
	public void run(String... strings) throws Exception {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date(Calendar.getInstance().getTime().getTime());
		System.out.println(dateFormat.format(date)); //2016/11/16 12:08:43
		
		
		this.repository.save(new Employee((long)0,"123456789","Capacitacion 1","Apellido 1","pruebamail2@prueba.com",date,Genere.FEMALE));
		
		this.repository.save(new Employee((long)0,"123456710","Capacitacion 2","Apellido 2","pruebamail2@prueba.com",date,Genere.MALE));
				
	}
}
