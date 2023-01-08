package emlakcepte.service;

import emlakcepte.controller.UserController;
import emlakcepte.model.Realty;
import emlakcepte.model.User;
import emlakcepte.model.enums.RealtyType;
import emlakcepte.model.enums.UserType;
import emlakcepte.repository.RealtyRepository;
import emlakcepte.request.RealtyRequest;
import emlakcepte.request.RealtyUpdateRequest;
import emlakcepte.response.RealtyResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class RealtyService {

    @Autowired
    private UserService userService;

    @Autowired
    private RealtyRepository realtyRepository;


    public Realty create(RealtyRequest realtyRequest) {
        Logger logger = Logger.getLogger(UserController.class.getName());

        Optional<User> foundUser = userService.getById(realtyRequest.getUserId());

        if (foundUser.isEmpty()) {
            System.out.println("user bulunamadı");
            return null;
        }

        Realty realty = convert(realtyRequest);
        realty.setUser(foundUser.get());
        Realty savedRealty = realtyRepository.save(realty);

        System.out.println("createRealty :: " + realty);

        return savedRealty;

    }

    private Realty convert(RealtyRequest realtyRequest) {
        Realty realty = new Realty();
        realty.setNo(realtyRequest.getNo());
        realty.setCreateDate(LocalDateTime.now());
        realty.setStatus(RealtyType.IN_REVIEW);
        realty.setTitle(realtyRequest.getTitle());
        realty.setProvince(realtyRequest.getProvince());
        return realty;
    }

    public List<Realty> getAll() {
        return realtyRepository.findAll();
    }

    public List<Realty> getAllById(int id) {
        return realtyRepository.findAllByUserId(id);
    }

    public List<Realty> getAllActiveRealties() {
        return realtyRepository.findAllByStatus(RealtyType.ACTIVE);
    }

    public List<Realty> getAllPassiveRealties() {
        return realtyRepository.findAllByStatus(RealtyType.PASSIVE);
    }

    public RealtyResponse update(RealtyUpdateRequest realtyUpdateRequest) {
    }
}
