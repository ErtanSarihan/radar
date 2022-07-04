package com.erta.radar.service.vehicle;

import com.erta.radar.dto.VehicleDto;
import com.erta.radar.mapper.VehicleMapper;
import com.erta.radar.model.Vehicle;
import com.erta.radar.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehicleServiceImpl implements VehicleService {

    private final VehicleRepository vehicleRepository;
    private final VehicleMapper vehicleMapper;

    @Autowired
    public VehicleServiceImpl(VehicleRepository vehicleRepository, VehicleMapper vehicleMapper) {
        this.vehicleRepository = vehicleRepository;
        this.vehicleMapper = vehicleMapper;
    }

    @Override
    public List<VehicleDto> getAllVehicles() {
        return vehicleMapper.mapToDtoList(vehicleRepository.getAllByIdNotNull());
    }

    @Override
    public VehicleDto addVehicle(VehicleDto vehicleDto) {
        Vehicle savedVehicle = vehicleRepository.save(vehicleMapper.mapToModel(vehicleDto));
        return vehicleMapper.mapToDto(savedVehicle);
    }
}
