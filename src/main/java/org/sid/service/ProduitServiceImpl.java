package org.sid.service;

import java.util.List;

import org.sid.dao.ProduitRepository;
import org.sid.entities.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
@Service
public class ProduitServiceImpl implements ProduitService {
    
	@Autowired
	private ProduitRepository produitRepositroy;
	
	@Override
	public List<Produit> getAllProducts() {
		// TODO Auto-generated method stub
		return produitRepositroy.findAll();
	}

	@Override
	public Produit getOne(Long id) {
		// TODO Auto-generated method stub
		return  produitRepositroy.getById(id);
	}

	@Override
	public void addProduct(Produit p) {
		// TODO Auto-generated method stub
		
		Produit prod = new Produit();
		prod.setDesignation(p.getDesignation());
		prod.setPrice(p.getPrice());
		prod.setQuantite(p.getQuantite());
		
		produitRepositroy.save(prod);
	}

	@Override
	public void updateProduct(Long id, Produit p) {
		// TODO Auto-generated method stub
		
		Produit prod = produitRepositroy.getById(id);
		System.out.println("prod "+prod.getDesignation()) ;
		System.out.println("p "+p.getDesignation()) ;

		prod.setDesignation(p.getDesignation());
		prod.setPrice(p.getPrice());
		prod.setQuantite(p.getQuantite());
		produitRepositroy.save(prod);
	}

	@Override
	public void deleteProduct(Long id) {
		// TODO Auto-generated method stub
		Produit prod = produitRepositroy.getById(id);
		produitRepositroy.delete(prod);
	}

}
