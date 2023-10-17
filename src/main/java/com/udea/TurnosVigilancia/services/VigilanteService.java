package com.udea.TurnosVigilancia.services;


import com.udea.TurnosVigilancia.entity.Vigilante;
import com.udea.TurnosVigilancia.repository.VigilanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;


@Service
public class VigilanteService {


    @Autowired  //inyecto todo lo que ofrece el repositorio
    private VigilanteRepository vigilanterepository;


    public List<Vigilante> getVigilante(){

        return  vigilanterepository.findAll();
    }
    public Vigilante getVigilanteById(Integer id){
        return  vigilanterepository.findById(id).orElse(null);
    }



    public  Vigilante saveVigilante(Vigilante vigilante){

        return vigilanterepository.save(vigilante);
    }



    public List<Vigilante> saveVigilants(List<Vigilante> vigilante){

        return vigilanterepository.saveAll(vigilante);
    }

    public Vigilante updateVigilante (Vigilante vigilante){
        Vigilante existingVigilante = vigilanterepository.findById(vigilante.getId()).orElse(null);
        existingVigilante.setName(vigilante.getName());
        existingVigilante.setAge(vigilante.getAge());
        existingVigilante.setCompany(vigilante.getCompany());
        existingVigilante.setDisponible(vigilante.isDisponible());
        existingVigilante.setTelefono(vigilante.getTelefono());
        existingVigilante.setDia(vigilante.getDia());
        existingVigilante.setHoras(vigilante.getHoras());
        return vigilanterepository.save(existingVigilante);
    }












    public String deleteVigilante(Integer id){
        vigilanterepository.deleteById(id);
        return  "Has eliminado al Vigilante con el ID: "+ id;

    }







     //CRUD: ver Vigilante añadir Vigilante, modificar, eliminar


}
