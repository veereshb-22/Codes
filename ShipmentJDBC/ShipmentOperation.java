package com.shipment.operation;

import java.util.Scanner;

import com.shipment.doc.ShipmentDoc;

public class ShipmentOperation {
	Scanner sc=new Scanner(System.in);
	ShipmentDoc sd=new ShipmentDoc();
	public void Operations() {
		while(true) {
		System.out.println("Enter create to CREATE DATABASE");
		System.out.println("Enter insert to INSERT VALUE");
		System.out.println("Enter operate to PERFOREM OPERATION");
		System.out.println("Enter inprocess to DISPLAY INPROCESS SHIPMENT");
		System.out.println("Enter search to SEARCH  DETAILS SHIPMENT BY ID");
		System.out.println("Enter delete TO DELETE SHIPMENT REJECTED");
		System.out.println("Enter order TO DISPALY SHIPMENT BY ORDERED DATE");
		System.out.println("Enter name to DISPLAY SHIPMENT NAME START WITH S");
		System.out.println("Enter amount to DISPALY SHIPMENT AMOUNT >60000");
		System.out.println("Enter show to DISPALY ALL DATABASE");
		System.out.println("ENter exit to EXIT THE PROCESS");
		String choice=sc.next();
		
		switch(choice) {
			case "create":sd.createShipment();
					break;
			case "show": sd.displayAllShipments();
					break;
			case "insert": sd.insertShipment();
					break;
			case "inprocess": sd.displayInporcessShipments();
					break;
			case "delete":sd.deleteRejectedShipments();
					break;
			case "search" :sd.searchShipmentByID();
					break;
			case "order" :sd.shipmentOrderByDate();
					break;
			case "name" :sd.ShipmentNameStartWith();
					break;
			case "amount":sd. ShipmentAmount();
					break;
			case "update":sd.ShipementUpdateStatus();
					break;
			case "exit":System.exit(0);
					break;
			default: System.out.println("INVALID CHOICE");
			}
		}
	}
}
