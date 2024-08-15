package com.students;

import java.util.ArrayList;
import java.util.HashMap;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Students {
	
	private String studentname;
	private String studentID;
	private ArrayList<String> studentskill;
	private HashMap<Integer,Float> studentper;
	

}	
	
