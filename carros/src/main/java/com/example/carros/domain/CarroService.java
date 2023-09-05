package com.example.carros.domain;

import com.example.carros.domain.dto.CarroDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CarroService {

    @Autowired
    private CarroRepository rep;

    public List<CarroDTO> getCarros() {
        List<Carro> carros = rep.findAll();

        List<CarroDTO> list = carros.stream().map(c -> new CarroDTO(c)).collect(Collectors.toList());

        return list;
    }
    public Optional<Carro> getCarroById(Long id) {

        return rep.findById(id);
    }

    public List<CarroDTO> getCarroByTipo(String tipo) {
        return rep.findByTipo(tipo).stream().map(CarroDTO::new).collect(Collectors.toList());

    }


//    public List<Carro> getCarrosFake() {
//        List<Carro> carros = new ArrayList<>();
//
//        carros.add(new Carro(1L, "Fusca"));
//        carros.add(new Carro(2L, "Brasilia"));
//        carros.add(new Carro(3L, "Chevette"));
//
//        return carros;
//    }

    public Carro save(Carro carro) {
        return rep.save(carro);
    }

    public Carro insert(Carro carro) {
        Assert.isNull(carro.getId(), "Não foi possível inserir o registro");
        return rep.save(carro);
    }
    public Carro update(Carro carro, Long id) {
        Assert.notNull(id, "Não foi possível atualizar o registro!!");

        Optional<Carro> optional = getCarroById(id);
        if(optional.isPresent()) {
            Carro db = optional.get();

            db.setNome(carro.getNome());
            db.setTipo(carro.getTipo());
            System.out.println("Carro ID: "+db.getId());
            rep.save(db);

            return db;
        } else {
            throw new RuntimeException("Não foi possível atualizar o registro!");
        }
    }

    public void delete(Long id) {
        Optional<Carro> carro = getCarroById(id);
        if(carro.isPresent()) {
            rep.deleteById(id);
        }
    }
}
