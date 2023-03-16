package Microservicios.ExampMicro.service;

import Microservicios.ExampMicro.entity.UserEntity;
import Microservicios.ExampMicro.feignClient.CarFeignClient;
import Microservicios.ExampMicro.feignClient.MotoFeignClient;
import Microservicios.ExampMicro.model.CarModel;
import Microservicios.ExampMicro.model.MotoModel;
import Microservicios.ExampMicro.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final RestTemplate restTemplate;
    private final CarFeignClient carFeignClient;
    private final MotoFeignClient motoFeignClient;

    public List<UserEntity> getAll(){
        return userRepository.findAll();
    }

    public UserEntity getUserById(Integer id){
        return userRepository.findById(id).orElse(null);
    }

    public UserEntity createUser(UserEntity user){
        return userRepository.save(user);
    }

    public List<CarModel> getCars(Integer userId){
        return restTemplate.getForObject("http://localhost:8081/api/v1/car/user/"+userId, List.class);
    }
    public List<MotoModel> getMotos(Integer userId){
        return restTemplate.getForObject("http://localhost:8082/api/v1/moto/user/"+userId, List.class);
    }

    public CarModel saveCar(Integer userId, CarModel car){
        car.setUserId(userId);
        return carFeignClient.saveCar(car);
    }
    public MotoModel saveMoto(Integer userId, MotoModel moto){
        moto.setUserId(userId);
        return motoFeignClient.saveMoto(moto);
    }
}
