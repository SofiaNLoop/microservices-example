package moto.MotoMicroservices.controller;

import lombok.RequiredArgsConstructor;
import moto.MotoMicroservices.entity.MotoEntity;
import moto.MotoMicroservices.service.MotoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/moto")
@RequiredArgsConstructor
public class MotoRestController {
    private final MotoService motoService;

    @GetMapping("/")
    public ResponseEntity<List<MotoEntity>> getAll() {
        if(motoService.getAll().isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(motoService.getAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<MotoEntity> findById(@PathVariable Integer id) {
        if(motoService.findById(id)==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(motoService.findById(id));
    }
    @PostMapping("/new")
    public ResponseEntity<MotoEntity> createMoto(@RequestBody MotoEntity moto) {
        return ResponseEntity.ok(motoService.createMoto(moto));
    }
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<MotoEntity>> motoByUserId(@PathVariable Integer userId) {
        if(motoService.motoByUserId(userId).isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(motoService.motoByUserId(userId));
    }
}
