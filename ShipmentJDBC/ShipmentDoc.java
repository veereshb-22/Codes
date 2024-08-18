package com.shipment.doc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Scanner;
import com.shipment.exception.InvalidJDBCTranactionException;
public class ShipmentDoc {

	private static Connection conn;
	private static Statement stmt;
	private PreparedStatement pstmt;	
	Scanner sc=new Scanner(System.in);
	public static Connection dbConnectivity() {
		
		try {
			//Step1 :establish 
			Class.forName("org.postgresql.Driver");
			conn=DriverManager.getConnection("jdbc:postgresql://localhost:5432/DemoShipyard"
					 ,"postgres","crimson@123"); // url,database,password 
			
		}catch(Exception e) {
			
		}
		return conn;		
		
	}
	
	public void createShipment() {
		
		String query="create table shipmentdemo(shipment_id int primary key,shipment_title varchar(20),"
				+ "shipment_estamount float,shipment_custstatus varchar(20),shipment_date date, "
				+ "shipment_arrivaldate date,shipment_status varchar(20));";
		
		try {
			conn=dbConnectivity(); 
			if(conn !=null) {
				stmt= conn.createStatement();
				boolean result=stmt.execute(query);
				if(!result) {
					System.out.println("Created Successfully");
					
				}
				else {
					throw new InvalidJDBCTranactionException(" Table has Not been Created");
				}
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		finally {
			try {
				conn.close();
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
	}
	public void insertShipment() {
		String insertShipment="insert into shipmentdemo values(?,?,?,?,?,?,?);";
		LocalDate ld;String data; Date d;
		try{
			conn = dbConnectivity();
			conn.setAutoCommit(false);
			pstmt =  conn.prepareStatement(insertShipment);	
			System.out.println("Enter The ShipmentDetails");
			System.out.println("Enter ShipmentId");
			pstmt.setInt(1,sc.nextInt());
			System.out.println("Enter Shipement Title");
			pstmt.setString(2,sc.next());
			System.out.println("Enter Shipment Estimate Amount");
			pstmt.setFloat(3,sc.nextFloat());
			System.out.println("Enter Shipment Custom Status ie accepted | rejected ");
			pstmt.setString(4,sc.next());
			System.out.println("Enter Shipement Departure Date in YYYY-MM-DD");
			data=sc.next();
			ld=LocalDate.parse(data);
			d=Date.valueOf(ld);
			pstmt.setDate(5,d);
			System.out.println("Enter the ArrivalTime of Shipment in YYYY_MM_DD");
			data=sc.next();
			ld=LocalDate.parse(data);
			d=Date.valueOf(ld);
			pstmt.setDate(6,d);
			System.out.println("Enter the Shipment Status inprocess | delivered | notdelivered");
			pstmt.setString(7,sc.next());
			int insertRowCount = pstmt.executeUpdate();
			if(insertRowCount != 0){
				System.out.println("row inserted");
				conn.commit();
			}else{
				System.out.println("NOT INSERTED");
				throw new InvalidJDBCTranactionException("check insert syntax");
			}
		}catch (InvalidJDBCTranactionException | SQLException ie) {
			System.out.println(ie.getMessage());
			try {
				conn.rollback();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
	}

	public void displayAllShipments(){
		try {
			conn = dbConnectivity();
			conn.setAutoCommit(false);
				pstmt = conn.prepareStatement("select * from shipmentdemo ");
				//step 4
				ResultSet rs = pstmt.executeQuery();
				if(rs!=null){
				//step 5
				System.out.println();	
				System.out.println(" DISPALY ALL SHIPMENT DETAILS");
				while(rs.next()){
					System.out.println("Shipment Details :"
				+rs.getInt(1)+" "+rs.getString(2)+" "+rs.getFloat(3)+" "+rs.getString(4)+" "+rs.getDate(5)
				+" "+rs.getDate(6)+" "+rs.getString(7));
				}
				}else{
					throw new InvalidJDBCTranactionException("No Data In the Table");
				}
			}catch(InvalidJDBCTranactionException | SQLException ie){
				ie.printStackTrace();
			}finally{
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	}
	public void displayInporcessShipments(){
		try {
			conn = dbConnectivity();
			conn.setAutoCommit(false);
				pstmt = conn.prepareStatement("select * from shipmentdemo where shipment_status='inprocess';");
				ResultSet rs = pstmt.executeQuery();
				if(rs!=null){
				//step 5
			System.out.println();
			System.out.println("ALL SHIPMENT INPROCESS");
				while(rs.next()){
					System.out.println("Shipment Details"
				+rs.getInt(1)+" "+rs.getString(2)+" "+rs.getFloat(3)+" "+rs.getString(4)+" "+rs.getDate(5)
				+" "+rs.getDate(6)+" "+rs.getString(7));
				}
				}else{
					throw new InvalidJDBCTranactionException("No Data In the Table");
				}
			}catch(InvalidJDBCTranactionException | SQLException ie){
				ie.printStackTrace();
			}finally{
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	}
	public void deleteRejectedShipments(){
		try {
			conn = dbConnectivity();
			conn.setAutoCommit(false);
				pstmt = conn.prepareStatement("delete from shipmentdemo where shipment_custstatus='rejected';");
				 int rs = pstmt.executeUpdate();
				if(rs>0){
				System.out.println(" DELETED SHIPMENT DETAILS");
				conn.commit();
				}else{
					throw new InvalidJDBCTranactionException("No Data In the Table");
				}
			}catch(InvalidJDBCTranactionException | SQLException ie){
				ie.printStackTrace();
			}finally{
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	}
	
	public void searchShipmentByID() {
		try {
			conn = dbConnectivity();
			conn.setAutoCommit(false);
				pstmt = conn.prepareStatement("select * from shipmentdemo where shipment_id= ? ;");
				System.out.println("Enter ShipmentID  TO SEARCH ");
				pstmt.setInt(1,sc.nextInt());
				ResultSet rs = pstmt.executeQuery();
				if(rs!=null){
				//step 5
					
				while(rs.next()){
					System.out.println("Shipment Details"
				+rs.getInt(1)+" "+rs.getString(2)+" "+rs.getFloat(3)+" "+rs.getString(4)+" "+rs.getDate(5)
				+" "+rs.getDate(6)+" "+rs.getString(7));
				}
				}else{
					throw new InvalidJDBCTranactionException("No Data In the Table");
				}
			}catch(InvalidJDBCTranactionException | SQLException ie){
				ie.printStackTrace();
			}finally{
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	}
	public void shipmentOrderByDate() {
		try {
			conn = dbConnectivity();
			conn.setAutoCommit(false);
				pstmt = conn.prepareStatement("select * from shipmentdemo order by shipment_date ;");
				
				ResultSet rs = pstmt.executeQuery();
				if(rs!=null){
				//step 5
				System.out.println(" SHIPMENT INOREDR DATE");	
				while(rs.next()){
					System.out.println("Shipment Details"
				+rs.getInt(1)+" "+rs.getString(2)+" "+rs.getFloat(3)+" "+rs.getString(4)+" "+rs.getDate(5)
				+" "+rs.getDate(6)+" "+rs.getString(7));
				}
				}else{
					throw new InvalidJDBCTranactionException("No Data In the Table");
				}
			}catch(InvalidJDBCTranactionException | SQLException ie){
				ie.printStackTrace();
			}finally{
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	}
	public void ShipmentNameStartWith() {
		try {
			conn = dbConnectivity();
			conn.setAutoCommit(false);
				pstmt = conn.prepareStatement("select * from shipmentdemo where shipment_title like 's%' ;");
				
				ResultSet rs = pstmt.executeQuery();
				if(rs!=null){
				//step 5
				System.out.println(" SHIPMENT NAME START WITH 'S' ");	
				while(rs.next()){
					System.out.println("Shipment Details"
				+rs.getInt(1)+" "+rs.getString(2)+" "+rs.getFloat(3)+" "+rs.getString(4)+" "+rs.getDate(5)
				+" "+rs.getDate(6)+" "+rs.getString(7));
				}
				}else{
					throw new InvalidJDBCTranactionException("No Data In the Table");
				}
			}catch(InvalidJDBCTranactionException | SQLException ie){
				ie.printStackTrace();
			}finally{
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	}
	public void ShipmentAmount() {
		try {
			conn = dbConnectivity();
			conn.setAutoCommit(false);
				pstmt = conn.prepareStatement("select * from shipmentdemo where shipment_estamount >50000;");
				
				ResultSet rs = pstmt.executeQuery();
				if(rs!=null){
				//step 5
				System.out.println(" SHIPMENT WITH AMOUNTS START ");	
				while(rs.next()){
					System.out.println("Shipment Details"
				+rs.getInt(1)+" "+rs.getString(2)+" "+rs.getFloat(3)+" "+rs.getString(4)+" "+rs.getDate(5)
				+" "+rs.getDate(6)+" "+rs.getString(7));
				}
				
				}else{
					throw new InvalidJDBCTranactionException("No Data In the Table");
				}
			}catch(InvalidJDBCTranactionException | SQLException ie){
				ie.printStackTrace();
			}finally{
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	}
	public void ShipementUpdateStatus() {
		System.out.println("SHIPMENT STATUS");
		try {
			conn = dbConnectivity();
			conn.setAutoCommit(false);
				pstmt = conn.prepareStatement("update shipmentdemo set shipment_status ='inprocess' where current_date > shipment_arrivaldate;");
				int rs = pstmt.executeUpdate();
				
				if(rs > 0){
				System.out.println("EXECUTED");
				conn.commit();
				
				}else{
					throw new InvalidJDBCTranactionException("No Data In the Table");
				}
			}catch(InvalidJDBCTranactionException | SQLException ie){
				ie.printStackTrace();
			}finally{
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	}
}
