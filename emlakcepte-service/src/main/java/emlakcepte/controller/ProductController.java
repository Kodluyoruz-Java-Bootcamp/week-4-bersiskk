package emlakcepte.controller;

import emlakcepte.model.Product;
import emlakcepte.request.ProductRequest;
import emlakcepte.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    // GET /products
    @GetMapping
    public ResponseEntity<List<Product>> getAll() {
        return ResponseEntity.ok(productService.getAll());
    }

    // POST /products
    @PostMapping
    public ResponseEntity<Product> purchase(@RequestBody ProductRequest productRequest) {
        Product product = productService.buy(productRequest);
        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<List<Product>> getAllByUserId(@PathVariable int id) {
        List<Product> products = productService.getAllById(id);
        return ResponseEntity.ok(products);
    }


}
