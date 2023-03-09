package co.edu.umanizales.manage_store.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@Data
public class Sale
{
    private Store store;
    private Seller seller;
    private int quantity;
}
