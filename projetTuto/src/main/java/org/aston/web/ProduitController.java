package org.aston.web;

import java.util.List;

import org.aston.dao.ProduitRepository;
import org.aston.entities.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProduitController {
	@Autowired
	private ProduitRepository produitRepository;

	@RequestMapping(value = "/index")
	public String index(Model model, 
			@RequestParam(name = "page", defaultValue = "0") int p,
			@RequestParam(name = "size", defaultValue = "5") int s,
			@RequestParam(name ="mc", defaultValue = "")String mc) {

		Page<Produit> pageProduits = produitRepository.chercher("%" + mc +"%",PageRequest.of(p, s));
		model.addAttribute("listProduits", pageProduits.getContent());
		int[] pages = new int[pageProduits.getTotalPages()];
		model.addAttribute("size",s);
		model.addAttribute("pages", pages);
		model.addAttribute("pageCourante",p);
		return "produits";
	}
}
