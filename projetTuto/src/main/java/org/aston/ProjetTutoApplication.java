package org.aston;

import org.aston.dao.ProduitRepository;
import org.aston.entities.Produit;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ProjetTutoApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(ProjetTutoApplication.class, args);
		ProduitRepository produitRepository = ctx.getBean(ProduitRepository.class);
		produitRepository.save(new Produit("LX 4352",670,90));
		produitRepository.save(new Produit("Ordi HP 432",670,90));
		produitRepository.save(new Produit("Imprimante Epson",670,12));
		produitRepository.save(new Produit("Imprimante HP 5400",45,1));
		
		produitRepository.findAll().forEach(p -> {
			System.out.println(p.getId());
		});
		
	}
	

}
