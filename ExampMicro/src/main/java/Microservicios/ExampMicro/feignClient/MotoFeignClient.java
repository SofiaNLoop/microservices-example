package Microservicios.ExampMicro.feignClient;

import Microservicios.ExampMicro.model.MotoModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "service-moto", url = "http://127.0.0.1:8082/api/v1/moto")
public interface MotoFeignClient {
    @RequestMapping(method = RequestMethod.POST, value = "/new")
    MotoModel saveMoto(@RequestBody MotoModel moto);
}
