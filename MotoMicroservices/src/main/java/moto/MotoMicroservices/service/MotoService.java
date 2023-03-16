package moto.MotoMicroservices.service;

import lombok.RequiredArgsConstructor;
import moto.MotoMicroservices.entity.MotoEntity;
import moto.MotoMicroservices.repository.MotoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MotoService {
    private final MotoRepository motoRepository;

    public List<MotoEntity> getAll() {
        return motoRepository.findAll();
    }
    public MotoEntity findById(Integer id) {
        return motoRepository.findById(id).orElse(null);
    }

    public MotoEntity createMoto(MotoEntity entity) {
        return motoRepository.save(entity);
    }

    public List<MotoEntity> motoByUserId(Integer userId) {
        return motoRepository.findByUserId(userId);
    }
}
