package com.example.inventoryservice.init;

import com.example.inventoryservice.model.Inventory;
import com.example.inventoryservice.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class LoadData implements CommandLineRunner {
    private final InventoryRepository inventoryRepository;
    @Override
    public void run(String... args) throws Exception {
        Inventory inventory=new Inventory();
        inventory.setSkuCode("iphone_13");
        inventory.setQuantity(100);

        Inventory inventory1=new Inventory();
        inventory1.setSkuCode("iphone_13_red");
        inventory1.setQuantity(0);

        inventoryRepository.save(inventory);
        inventoryRepository.save(inventory1);
        log.info("Inventory saved db");
    }
}
