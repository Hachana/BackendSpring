package org.sid.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Produit implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String designation;
	private double price;
	private int quantite;

	public Produit() {
	}

	public Produit(Long id, String designation, double price, int quantite) {
		super();
		this.id = id;
		this.designation = designation;
		this.price = price;
		this.quantite = quantite;
	}

	public Long getId() {
		return id;
	}

	public String getDesignation() {
		return designation;
	}

	public void prod(String designation) {
		this.designation = designation;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	@Override
	public String toString() {
		return "Produit [id=" + id + ", designation=" + designation + ", price=" + price + ", quantite=" + quantite
				+ "]";
	}

}
