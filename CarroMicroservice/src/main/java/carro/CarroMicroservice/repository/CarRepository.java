package carro.CarroMicroservice.repository;

import carro.CarroMicroservice.entity.CarEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<CarEntity, Integer> {
    List<CarEntity> findByUserId(Integer userId );
}
