package org.sid;

import org.sid.dao.ProduitRepository;
import org.sid.entities.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner{
 
	@Autowired
	private ProduitRepository produitRepository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}


	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
//		produitRepository.save(new Produit(null,"Ordinateur pc",3000,3));
//		produitRepository.save(new Produit(null,"Smart Phone",1200,7));
		
		produitRepository.findAll().forEach(p->{
			System.out.println(p.toString());
		});
 
	}

}
