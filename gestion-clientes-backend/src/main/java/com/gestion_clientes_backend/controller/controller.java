package com.gestion_clientes_backend.controller;


import com.gestion_clientes_backend.exceptions.excecion;
import com.gestion_clientes_backend.models.models;
import com.gestion_clientes_backend.repository.repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1")
public class controller {


    @Autowired
    private repository repositorys;

    @GetMapping("/clientes")
    public List<models> listarclientes(){
        return repositorys.findAll();
    }

    // la diferencia entre el requestbody y el pathvariable es que
    // el path es para capturar valores que que hacen parte de la url
    // es decir si quieres buscar a alguin por su nombre o id
    // para esto esta el path y por otro lado el request body es cuando
    // uno va ha actualizar o modificar un clientee. que esta haciendo una
    // entrada de datos
    @PostMapping("/clientes")
    public models guardarcliente(@RequestBody models model){
        return repositorys.save(model);
    }


    // la razon por la que se usa response entity
    // y no list es que esta metodo perimte crear excepciones personalisadas
    // como la que vemos aqui
    @GetMapping("/clientes/{id}")
    public ResponseEntity<models> mostrarclienteporid(@PathVariable Long id){
        models model = repositorys.findById(id)
                .orElseThrow(() -> new excecion("el cliente con ese ID no existe" + id));
        return ResponseEntity.ok(model);
    }
    @PutMapping("/clientes/{id}")
    public ResponseEntity<models> actualizarcliente(@PathVariable Long id , @RequestBody models modelrquest){
        models model  = repositorys.findById(id)
                .orElseThrow(() -> new excecion("el cliente con ese ID no existe" + id));
        model.setNombre(modelrquest.getNombre());
        model.setApellido(modelrquest.getApellido());
        model.setEmail(modelrquest.getEmail());

        models modelactualizado = repositorys.save(model);
        return ResponseEntity.ok(modelactualizado);
    }
    @DeleteMapping("/clientes/{id}")
    public ResponseEntity<Map<String,Boolean>> eliminarCliente(@PathVariable Long id){
        models model  = repositorys.findById(id)
                .orElseThrow(() -> new excecion("el cliente con ese ID no existe" + id));
        repositorys.delete(model);
        Map<String,Boolean> response = new HashMap<>();
        response.put("deleted",Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
