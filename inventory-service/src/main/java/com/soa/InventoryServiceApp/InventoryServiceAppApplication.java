package com.soa.InventoryServiceApp;

import com.soa.InventoryServiceApp.model.Inventory;
import com.soa.InventoryServiceApp.repository.InventoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InventoryServiceAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceAppApplication.class, args);
	}

	@Bean
	public CommandLineRunner loadData(InventoryRepository inventoryRepository) {
		return args -> {
			Inventory inventory = new Inventory();
			inventory.setQuantity(100);
			inventory.setProductCode(123L);

			Inventory inventory1 = new Inventory();
			inventory1.setQuantity(100);
			inventory1.setProductCode(456L);

			Inventory inventory2 = new Inventory();
			inventory1.setQuantity(0);
			inventory1.setProductCode(789L);

			inventoryRepository.save(inventory);
			inventoryRepository.save(inventory1);
			inventoryRepository.save(inventory2);
		};
	}

}
