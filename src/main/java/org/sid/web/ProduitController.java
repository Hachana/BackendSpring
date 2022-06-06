package org.sid.web;

import org.sid.service.ProduitService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import javax.persistence.*;

import org.junit.jupiter.api.Test;
import org.sid.entities.Produit;
import org.jboss.logging.Logger;


@CrossOrigin("*")
 
@RestController
@RequestMapping(path="/Products")
public class ProduitController {
	private Logger logger = Logger.getLogger(ProduitController.class);

	@Autowired
	private ProduitService produitService;
    @Autowired
    EntityManager entityManager;

	
	@GetMapping(path="/getAll")
	public List<Produit> getAll() {
         return produitService.getAllProducts() ;
	}
	

	@GetMapping(path="/getAllHQL")
	public List<Produit> getAllHQL() {
		 
        Query query = entityManager.createQuery("select u from Produit u");
        List<Produit> prods= query.getResultList();
        prods.forEach(u -> System.out.println(u.toString()));
         return prods ;
	}
	
	@PostMapping(path="/search")
	public List<Produit> search(@RequestBody String nom) {
            System.out.println("=> search  "+nom) ;
		

            Query query = entityManager.createQuery("select u from Produit u where u.designation like CONCAT('%',?1,'%')");
	        query.setParameter(1, nom);
		

        List<Produit> prods= query.getResultList();
        prods.forEach(u -> System.out.println(u.toString()));
         return prods ;
	}
	
	
	@GetMapping(path="/getOne/{id}")
	public String getOne(@PathVariable Long id) {
		Produit p = produitService.getOne(id);
        return p.toString();

	}
	
	@PostMapping(path="/addProduct")
	public void addProduct(@RequestBody Produit p) {
		
		 produitService.addProduct(p);
		
	}
	
	@PutMapping(path="/updateProduct/{id}")
	public void updateProduct(@PathVariable Long id ,@RequestBody Produit p) {
		System.out.println("=> updateProduct "+id) ;
		 produitService.updateProduct(id, p);
		
	}
	
	@DeleteMapping(path="/deleteProduct/{id}")
	public void deleteProduct(@PathVariable Long id) {
		
		 produitService.deleteProduct(id);
		
	}
	
}
