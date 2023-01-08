package emlakcepte.controller;

import emlakcepte.model.Realty;
import emlakcepte.request.RealtyRequest;
import emlakcepte.request.RealtyUpdateRequest;
import emlakcepte.request.UserUpdateRequest;
import emlakcepte.response.RealtyResponse;
import emlakcepte.response.UserResponse;
import emlakcepte.service.RealtyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/realties")
public class RealtyController {

    @Autowired
    private RealtyService realtyService;

    // GET /realties
    @GetMapping
    public ResponseEntity<List<Realty>> getAll() {
        return ResponseEntity.ok(realtyService.getAll());
    }

    // POST /realties
    @PostMapping
    public ResponseEntity<Realty> create(@RequestBody RealtyRequest realtyRequest) {
        Realty realty = realtyService.create(realtyRequest);
        return new ResponseEntity<>(realty, HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<List<Realty>> getAllByUserId(@PathVariable int id) {
        List<Realty> realties = realtyService.getAllById(id);
        return ResponseEntity.ok(realties);
    }

    @GetMapping(value = "/status/active")
    public ResponseEntity<List<Realty>> getAllActiveRealties() {
        List<Realty> realties = realtyService.getAllActiveRealties();
        return ResponseEntity.ok(realties);
    }

    @GetMapping(value = "/status/passive")
    public ResponseEntity<List<Realty>> getAllPassiveRealties() {
        List<Realty> realties = realtyService.getAllPassiveRealties();
        return ResponseEntity.ok(realties);
    }


    @PutMapping
    public ResponseEntity<RealtyResponse> update(@RequestBody RealtyUpdateRequest realtyUpdateRequest) {
        RealtyResponse realty = realtyService.update(realtyUpdateRequest);
        return ResponseEntity.ok(realty);
    }

}
