package guru.springframework.sfgpetclinic.services.springdatajpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import guru.springframework.sfgpetclinic.model.Visit;
import guru.springframework.sfgpetclinic.repositories.VisitRepository;
import guru.springframework.sfgpetclinic.services.VisitService;

@Service
@Profile("SPDJpa")
public class VisitSDJpaService implements VisitService {

    private final VisitRepository visitRepository;


    public VisitSDJpaService(VisitRepository visitRepository) {
        this.visitRepository = visitRepository;
    }


    @Override
    public Set<Visit> findAll() {
        Set <Visit> visits = new HashSet<>();
        visitRepository.findAll().forEach(visits::add);
        return visits;

    }


    @Override
    public Visit findById(Long id) {
        return visitRepository.findById(id).orElse(null);
        
    }


    @Override
    public Visit save(Visit object) {
        visitRepository.save(object);
        return null;
    }


    @Override
    public void delete(Visit object) {
        visitRepository.delete(object);
        
    }


    @Override
    public void deleteById(Long id) {
        visitRepository.deleteById(id);
        
    }
    
    
}
