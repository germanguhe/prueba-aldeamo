package com.aldeamo.bar.repositories;

import com.aldeamo.bar.models.ArraysModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArrayRepository extends CrudRepository<ArraysModel, Long> {
}
