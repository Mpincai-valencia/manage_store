package co.edu.umanizales.manage_store.service;
import co.edu.umanizales.manage_store.model.Store;
import org.springframework.stereotype.Service;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;


@Service
@Getter
public class StoreService
{
    private List<Store> stores;

    public StoreService()
    {
        stores = new ArrayList<>();
        stores.add(new Store("23", "Pepeganga"));
        stores.add(new Store("222", "Dollarcity"));
    }

    public void addStore(Store store)
    {
        stores.add(store);
    }
    public Store getStoreById(String code)
    {
        for(Store store:stores)
        {
            if(store.getCode().equalsIgnoreCase(code))
            {
                return store;
            }
        }
        return null;
    }
}
