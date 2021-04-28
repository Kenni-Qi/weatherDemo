package com.example.demo.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.dao.TestDao;
import com.example.demo.entity.CityEntity;
import com.example.demo.service.impl.TestServiceImpl;


@Repository("testDaoImpl")
public class TestDaoImpl implements TestDao{

	@Autowired
	private TestServiceImpl testServiceImpl;
	
	
	@Override
	public List<CityEntity> getCityDetail() 
	{
		  List<CityEntity> cityEntityList = new ArrayList<CityEntity>();
		  Connection c = null;
	      Statement stmt = null;
	      try {
	         Class.forName("org.postgresql.Driver");
	         c = testServiceImpl.getConnection();
	         stmt = c.createStatement();
	         //Input SQL Start
	         String sql = 
	        		 "SELECT * " +
	        		 "FROM public.city_select";
	         //Input SQL End
	         ResultSet rs = stmt.executeQuery(sql);
	         while(rs.next()){
	         CityEntity cityEntity = new CityEntity();
	         cityEntity.setCity(rs.getString("city"));
	         cityEntity.setLocationid(rs.getString("locationid"));
	         cityEntity.setValue(rs.getString("value"));
	         cityEntityList.add(cityEntity);
	         }
	         rs.close();
	         stmt.close();
	         c.close();
	         
	      } catch (Exception e) {
	         e.printStackTrace();
	         System.err.println(e.getClass().getName()+": "+e.getMessage());
	         System.exit(0);
	      }
	      return cityEntityList;
	}
}
