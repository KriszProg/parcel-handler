package hu.foxpost.parcel_handler.repository;

import hu.foxpost.parcel_handler.entity.Client;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Integer>, JpaSpecificationExecutor<Client> {

    List<Client> findAll(Specification<Client> spec);

}
