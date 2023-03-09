package co.edu.umanizales.manage_store.controller;
import co.edu.umanizales.manage_store.controller.dto.ResponseDTO;
import co.edu.umanizales.manage_store.model.Seller;
import co.edu.umanizales.manage_store.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="seller")
public class SellerController {
    @Autowired
    private SellerService sellerService;
    @GetMapping
    public ResponseEntity<ResponseDTO>getSellers()
    {
        return new ResponseEntity(new ResponseDTO(200,sellerService.getSellers(),null),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ResponseDTO>createSeller(@RequestBody Seller seller)
    {
        Seller findSeller=sellerService.getSellerById(seller.getCode());
        if(findSeller==null)
        {
            sellerService.addSeller(seller);
            return new ResponseEntity<>(new ResponseDTO(200,"Vendedor agregado",null),HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>(new ResponseDTO(409,"El vendedor ya exsite",null),HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(path ="/{code}")
    public ResponseEntity<ResponseDTO>getSellerById(@PathVariable String code)
    {
        Seller findseller=sellerService.getSellerById(code);
        if(findseller==null)
        {
            return new ResponseEntity<>(new ResponseDTO(404,"No exsite un vendedor con ese código",null),HttpStatus.BAD_REQUEST);
        }
        else
        {
            return new ResponseEntity<>(new ResponseDTO(200,findseller,null),HttpStatus.OK);
        }
    }

}
