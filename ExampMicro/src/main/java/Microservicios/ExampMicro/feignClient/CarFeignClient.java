package Microservicios.ExampMicro.feignClient;

import Microservicios.ExampMicro.model.CarModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "service-car", url = "http://localhost:8081/api/v1/car")
public interface CarFeignClient {
    @RequestMapping(method = RequestMethod.POST, value = "/new")
    CarModel saveCar(@RequestBody CarModel car);
}
