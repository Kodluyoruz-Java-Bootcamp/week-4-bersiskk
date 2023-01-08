package emlakcepte.service;

import emlakcepte.controller.UserController;
import emlakcepte.model.Product;
import emlakcepte.model.Realty;
import emlakcepte.model.User;
import emlakcepte.model.enums.UserType;
import emlakcepte.repository.ProductRepository;
import emlakcepte.request.ProductRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class ProductService {

    @Autowired
    private UserService userService;

    @Autowired
    private ProductRepository productRepository;


    public Product buy(ProductRequest productRequest) {
        Logger logger = Logger.getLogger(UserController.class.getName());

        Optional<User> foundUser = userService.getById(productRequest.getUserId());

        if (foundUser.isEmpty()) {
            System.out.println("user bulunamadı");
        }



    }

    public List<Product> getAll() {
        return productRepository.findAll();
    }

    public List<Product> getAllById(int id) {
        return productRepository.findAllById(id);
    }
}
