package moto.MotoMicroservices.repository;

import moto.MotoMicroservices.entity.MotoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MotoRepository extends JpaRepository<MotoEntity, Integer> {
    List<MotoEntity> findByUserId(Integer userId);
}
