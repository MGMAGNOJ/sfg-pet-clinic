package guru.springframework.sfgpetclinic.services;

import org.springframework.data.repository.CrudRepository;

import guru.springframework.sfgpetclinic.model.Visit;

public interface VisitService extends CrudService<Visit, Long>{
    
}
