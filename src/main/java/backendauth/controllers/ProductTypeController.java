package backendauth.controllers;

import backendauth.models.ProductType;
import backendauth.services.implement.ProductTypeServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/product-type")
@CrossOrigin("*")
public class ProductTypeController {
    @Autowired
    private ProductTypeServiceImp productTypeServiceImp;

    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
    public String AddType(@RequestBody ProductType newType){
        return productTypeServiceImp.NewType(newType);
    }
    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ProductType> AllType(){
        return productTypeServiceImp.AllType();
    }

    @PutMapping(value = "/remake", produces = MediaType.APPLICATION_JSON_VALUE)
    public String RemakeType(@RequestBody ProductType reType){
        return productTypeServiceImp.RemakeType(reType);
    }

    @DeleteMapping(value = "/delete", produces = MediaType.APPLICATION_JSON_VALUE)
    public String DeleteType(@RequestParam int idDelete){
        return productTypeServiceImp.DeleteType(idDelete);
    }
}
