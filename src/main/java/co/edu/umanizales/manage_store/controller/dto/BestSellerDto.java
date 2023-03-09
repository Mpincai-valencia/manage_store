package co.edu.umanizales.manage_store.controller.dto;

import co.edu.umanizales.manage_store.model.Seller;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class BestSellerDto {
    private Seller seller;
    private int quantity;
}
