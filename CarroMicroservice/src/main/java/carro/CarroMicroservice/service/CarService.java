package carro.CarroMicroservice.service;

import carro.CarroMicroservice.entity.CarEntity;
import carro.CarroMicroservice.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarService {
    private final CarRepository carRepository;

    public List<CarEntity> getAll(){
        return carRepository.findAll();
    }
    public CarEntity findById(Integer id){
        return carRepository.findById(id).orElse(null);
    }
    public CarEntity createCar(CarEntity car){
        return carRepository.save(car);
    }
    public List<CarEntity> carByUserId(Integer userId){
        return carRepository.findByUserId(userId);
    }
}
