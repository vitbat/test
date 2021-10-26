package kz.example.springrestful.repository;

import kz.example.springrestful.entity.Action;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActionRepo extends CrudRepository<Action, Long> {

}
