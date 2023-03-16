package carro.CarroMicroservice.controller;

import carro.CarroMicroservice.entity.CarEntity;
import carro.CarroMicroservice.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/car")
@RequiredArgsConstructor
public class CarRestController {
    private final CarService carService;

    @GetMapping("/")
    public ResponseEntity<List<CarEntity>> getAll() {
        if(carService.getAll().isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(carService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarEntity> findById(@PathVariable Integer id) {
        if(carService.findById(id) == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(carService.findById(id));
    }

    @PostMapping("/new")
    public ResponseEntity<CarEntity> createCar(@RequestBody CarEntity car) {
        return ResponseEntity.ok(carService.createCar(car));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<CarEntity>> carByUserId(@PathVariable Integer userId) {
        if(carService.carByUserId(userId).isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(carService.carByUserId(userId));
    }

}
