package pe.idat.service;


import pe.idat.dto.HospitalDTO;
import pe.idat.model.Hospital;
import pe.idat.repository.HospitalRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HospitalServiceImpl implements HospitalService{

    @Autowired
    private HospitalRepository repository;

    @Override
    public List<HospitalDTO> listar() {

        List<HospitalDTO> listadto = new ArrayList<>();
        HospitalDTO dto = null;

        for (Hospital hospital : repository.findAll()) {
            dto = new HospitalDTO();
            
            dto.setNombre(hospital.getNombre());
            dto.setUbicacion(hospital.getUbicacion());
            listadto.add(dto);
        }


        return listadto;

    }

    @Override
    public HospitalDTO obtenerId(Integer id) {

    	Hospital hospital = repository.findById(id).orElse(null);

        HospitalDTO dto = new HospitalDTO();
        dto.setNombre(hospital.getNombre());
        dto.setUbicacion(hospital.getUbicacion());

        return dto;
    }

    @Override
    public void guardar(HospitalDTO hospital) {

        Hospital hos = new Hospital();
        hos.setNombre(hospital.getNombre());
        hos.setUbicacion(hospital.getUbicacion());

        repository.save(hos);
    }

    @Override
    public void eliminar(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public void actualizar(HospitalDTO Hospital) {

    	Hospital hos = new Hospital();
    	hos.setNombre(hos.getNombre());
    	hos.setUbicacion(hos.getUbicacion());

        repository.saveAndFlush(hos);
    }
}

