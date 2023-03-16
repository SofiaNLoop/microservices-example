package Microservicios.ExampMicro.controller;

import Microservicios.ExampMicro.entity.UserEntity;
import Microservicios.ExampMicro.model.CarModel;
import Microservicios.ExampMicro.model.MotoModel;
import Microservicios.ExampMicro.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class AppRestController {
    private final UserService userService;

    @GetMapping("/")
    public ResponseEntity<List<UserEntity>> listUsers(){
        if(userService.getAll().isEmpty()){
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(userService.getAll());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserEntity> getUserById(@PathVariable Integer id){
        if(userService.getUserById(id) == null){
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(userService.getUserById(id));
        }
    }

    @PostMapping("/new")
    public ResponseEntity<UserEntity> createUser(@RequestBody UserEntity userEntity){
        return ResponseEntity.ok(userService.createUser(userEntity));
    }

    @GetMapping("/cars/{userId}")
    public ResponseEntity<List<CarModel>> getCars(@PathVariable Integer userId){
        if(userService.getUserById(userId)==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(userService.getCars(userId));
    }

    @GetMapping("/motos/{userId}")
    public ResponseEntity<List<MotoModel>> getMotos(@PathVariable Integer userId){
        if(userService.getUserById(userId)==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(userService.getMotos(userId));
    }
    @PostMapping("/car/{userId}")
    public ResponseEntity<CarModel> createCar(@PathVariable Integer userId, @RequestBody CarModel carModel){
        return ResponseEntity.ok(userService.saveCar(userId, carModel));
    }

    @PostMapping("/moto/{userId}")
    public ResponseEntity<MotoModel> createMoto(@PathVariable Integer userId, @RequestBody MotoModel motoModel){
        return ResponseEntity.ok(userService.saveMoto(userId, motoModel));
    }

}
