package com.drhbase.webapinew.DAL;

import com.drhbase.webapinew.Model.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends CrudRepository<Client,Integer> {
    @Override
    <S extends Client> S save(S entity);


    @Override
    Optional<Client> findById(Integer integer);

    @Override
    Iterable<Client> findAll();

    @Override
    void deleteById(Integer integer);
}
