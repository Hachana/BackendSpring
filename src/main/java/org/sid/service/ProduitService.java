package org.sid.service;

import java.util.List;

import org.sid.entities.Produit;

public interface ProduitService {
	
	public List<Produit> getAllProducts();
	public Produit getOne(Long id);
	public void addProduct(Produit p);
	public void updateProduct(Long id,Produit p);
	public void deleteProduct(Long id);


}
