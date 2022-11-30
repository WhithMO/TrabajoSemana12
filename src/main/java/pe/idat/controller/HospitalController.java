package pe.idat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pe.idat.dto.HospitalDTO;
import pe.idat.service.HospitalService;

@Controller
@RequestMapping("api/hospital/v1")
public class HospitalController {
	
    @Autowired
    private HospitalService service;

    @GetMapping("/listar")
    public @ResponseBody List<HospitalDTO> listar(){
        return service.listar();
    }

    @GetMapping("/listar/{id}")
    public @ResponseBody HospitalDTO obtenerId(@PathVariable Integer id){
        return  service.obtenerId(id);
    }

    @PostMapping("/guardar")
    public @ResponseBody void guardar(@RequestBody HospitalDTO dto){
        service.guardar(dto);
    }

    @PutMapping("/actualizar")
    public @ResponseBody void actualizar (@RequestBody HospitalDTO dto){
        service.actualizar(dto);
    }

    @DeleteMapping("/eliminar/{id}")
    public @ResponseBody void eliminar(@PathVariable Integer id){
        service.eliminar(id);
    }

}
