package backendauth.controllers;

import backendauth.models.Product;
import backendauth.services.implement.ProductServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/product")
@CrossOrigin("*")
public class ProductController {
    @Autowired
    private ProductServiceImp productServiceImp;
    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Product> All(){
        return productServiceImp.All();
    }

    @GetMapping(value = "/all-by-type", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Product> AllByType(@RequestParam int idType){
        return productServiceImp.AllByType(idType);
    }

    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
    public String NewProduct(@RequestBody Product newProduct){
        return productServiceImp.NewProduct(newProduct);
    }

    @PutMapping(value = "/remake", produces = MediaType.APPLICATION_JSON_VALUE)
    public String RemakeProduct(@RequestBody Product reProduct){
        return productServiceImp.RemakeProduct(reProduct);
    }

    @DeleteMapping(value = "/delete", produces = MediaType.APPLICATION_JSON_VALUE)
    public String DeleteProduct(@RequestParam int idDel){
        return productServiceImp.DeleteProduct(idDel);
    }
}
