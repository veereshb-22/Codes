package com.banking.p1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Users {
	private String user_name;
	private String user_id;
	private String account_number;
	private String password;
	
	public Users(String user_name, String user_id, String account_number, String password) {
		super();
		this.user_name = user_name;
		this.user_id = user_id;
		this.account_number = account_number;
		this.password = password;	
		
		
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((account_number == null) ? 0 : account_number.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((user_id == null) ? 0 : user_id.hashCode());
		result = prime * result + ((user_name == null) ? 0 : user_name.hashCode());
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
		Users other = (Users) obj;
		if (account_number == null) {
			if (other.account_number != null)
				return false;
		} else if (!account_number.equals(other.account_number))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (user_id == null) {
			if (other.user_id != null)
				return false;
		} else if (!user_id.equals(other.user_id))
			return false;
		if (user_name == null) {
			if (other.user_name != null)
				return false;
		} else if (!user_name.equals(other.user_name))
			return false;
		return true;
	}

	public Users(){	
 	
	}
	public String getUser_id() {
		return user_id;
	}

	public String getAccount_number() {
		return account_number;
	}

	public String getPassword() {
		return password;
	}
}
