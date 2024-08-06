package com.cbt.digital_library_management.dto;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
@Entity
@Data
public class Writers implements Serializable{
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	private int id;
	private String name;
	
	@Column(unique=true)
	private String email;
	private String password;
	private long phone;
	private String verify;
	@OneToMany
	List<Books> books;

	public Writers() {
		super();
	}

	public Writers(int id, String name, String email, String password, long phone, List<Books> books) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.books = books;
	}

	public Writers(  String email,String name, String password, long phone) {
		super();

		this.name = name;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.verify="no";
	}

	public Writers(int id, String name, String email, String password, long phone, String verify) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.verify = verify;
	}

	
	
	
}
