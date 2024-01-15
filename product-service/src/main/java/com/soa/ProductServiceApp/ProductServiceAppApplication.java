package com.soa.ProductServiceApp;

import com.soa.ProductServiceApp.model.Product;
import com.soa.ProductServiceApp.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ProductServiceAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductServiceAppApplication.class, args);
	}

	@Bean
	public CommandLineRunner loadData(ProductRepository productRepository) {
		return args -> {
			Product product = new Product();
			product.setName("Algocalmin");
			product.setDescription("Algocalmin apartine grupei de medicamente cunoscuta sub denumirea de antiinflamatoare nesteroidiene. El amelioreaza durerea si reduce temperatura corpului in caz de febra.");
			product.setPrice(25.99);

			Product product1 = new Product();
			product1.setName("Nurofen Forte");
			product1.setDescription("Nurofen Forte este utilizat pentru a calma durerile usoare pana la moderate, cum sunt durerea de cap, incluzand migrena, durerea de dinti, durerea menstruala si a reduce febra.");
			product1.setPrice(30.0);

			Product product2 = new Product();
			product2.setName("Strepsils Miere si Lamaie");
			product2.setDescription("Strepsils Miere şi Lamaie se utilizeaza ca adjuvant in tratamentul infectiilor oro-faringiene, favorizand ameliorarea simptomelor provocate de acestea. Calmare rapida (in 5 minute) şi de lunga durata (de pana la 2 ore) a durerii in gat.");
			product2.setPrice(14.5);

			Product product3 = new Product();
			product3.setName("Ibuprofen");
			product3.setDescription("Ibuprofenul (cu denumirile comerciale Brufen și Advil) este un antiinflamator nesteroidian din clasa derivaților de acid propionic, utilizat ca antiinflamator,analgezic și antipiretic.");
			product3.setPrice(39.99);

			Product product4 = new Product();
			product4.setName("Nidoflor");
			product4.setDescription("Nidoflor este un medicament recomandat pentru aplicare cutanata şi asociaza trei substante: sulfatul de neomicina şi nistatina (cu proprietati antimicrobine şi antifungice) cu un glucocorticoid de sinteza.");
			product4.setPrice(41.5);

			Product product5 = new Product();
			product5.setName("Metoclopramid");
			product5.setDescription("Metoclopramid Arena este utilizat la adulţi: - pentru tratamentul greţei şi vărsăturilor, inclusiv al greţei şi vărsăturilor care pot să apară în timpul migrenei.");
			product5.setPrice(24.2);

			Product product6 = new Product();
			product6.setName("Dymista");
			product6.setDescription("Dymista spray nazal ameliorează simptomele alergiilor, ca de exemplu: senzaţie de curgere a nasului, picurare nazală, strănut şi mâncărimi ale nasului sau nas înfundat.");
			product6.setPrice(100.99);

			Product product7 = new Product();
			product7.setName("Vizik");
			product7.setDescription("Vizik Allergy picaturi de ochi are in compozitie HIALURONAT DE SODIU 0.15% si ECTOINA 2%. Hialuronatul de sodiu formeaza un scut de protectie uniform si de durata pe stratul epitelial al ochiului fara a afecta vederea.");
			product7.setPrice(55.0);

			productRepository.save(product);
			productRepository.save(product1);
			productRepository.save(product2);
			productRepository.save(product3);
			productRepository.save(product4);
			productRepository.save(product5);
			productRepository.save(product6);
			productRepository.save(product7);

		};
	}

}
