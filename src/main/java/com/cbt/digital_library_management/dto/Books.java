package com.cbt.digital_library_management.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Books {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int id;
	private String name;
	private double price;
	@Column(name = "verifystatus")
	private String verifyStatus;
	@Lob
	@Column(columnDefinition = "LONGBLOB")
	private byte[] image;

	@ManyToOne
	private Writers writer;

	public Books(String name, double price, byte[] image, Writers writer) {
		super();
		this.name = name;
		this.price = price;
		this.image = image;
		this.writer = writer;
		this.verifyStatus = "no";
	}

	public Books(int id, String name, double price, byte[] image) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.image = image;
	}

}
