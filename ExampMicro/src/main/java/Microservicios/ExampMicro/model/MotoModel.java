package Microservicios.ExampMicro.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MotoModel {
    private String brand;
    private String model;
    private Integer userId;
}
