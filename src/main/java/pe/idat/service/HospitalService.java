package pe.idat.service;

import java.util.List;

import pe.idat.dto.HospitalDTO;

public interface HospitalService {
	
    List<HospitalDTO>listar();
    HospitalDTO obtenerId(Integer id);
    void guardar(HospitalDTO hospital);
    void eliminar(Integer id);
    void actualizar(HospitalDTO hospital);

}
