package com.example.carros.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CarroService {

    @Autowired
    private CarroRepository rep;

    public Iterable<Carro> getCarros() {
        return rep.findAll();
    }
    public Optional<Carro> getCarroById(Long id) {
        return rep.findById(id);
    }

    public Iterable<Carro> getCarroByTipo(String tipo) {
        return rep.findByTipo(tipo);
    }


    public List<Carro> getCarrosFake() {
        List<Carro> carros = new ArrayList<>();

        carros.add(new Carro(1L, "Fusca"));
        carros.add(new Carro(2L, "Brasilia"));
        carros.add(new Carro(3L, "Chevette"));

        return carros;
    }

    public Carro save(Carro carro) {
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
}
