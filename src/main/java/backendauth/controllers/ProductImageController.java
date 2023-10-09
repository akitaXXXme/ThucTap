package backendauth.controllers;

import backendauth.models.ProductImage;
import backendauth.services.implement.ProductImageServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/product-image")
@CrossOrigin("*")
public class ProductImageController {
    @Autowired
    private ProductImageServiceImp productImageServiceImp;

    @GetMapping(value = "/all-by-product", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ProductImage> AllByProduct(@RequestParam int idProduct){
        return productImageServiceImp.AllByProduct(idProduct);
    }

    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
    public String NewImage(@RequestBody ProductImage newImage){
        return productImageServiceImp.NewImage(newImage);
    }

    @PutMapping(value = "/remake", produces = MediaType.APPLICATION_JSON_VALUE)
    public String RemakeImage(@RequestBody ProductImage reImage){
        return productImageServiceImp.RemakeImage(reImage);
    }

    @DeleteMapping(value = "/delete", produces = MediaType.APPLICATION_JSON_VALUE)
    public String DeleteImage(@RequestParam int idDel){
        return productImageServiceImp.DeleteImage(idDel);
    }
}
