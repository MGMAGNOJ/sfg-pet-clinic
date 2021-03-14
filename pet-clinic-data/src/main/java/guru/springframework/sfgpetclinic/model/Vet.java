package guru.springframework.sfgpetclinic.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "vets")
public class Vet extends Person {

    /**
     *
     */
    private static final long serialVersionUID = 2949144664188938902L;
    @ManyToMany
    @JoinTable(name = "vet_specialities", joinColumns = @JoinColumn(name = "vet_id"), inverseJoinColumns = @JoinColumn(name = "speciality_id"))
    private Set<Speciality> specialties = new HashSet<>();

    public Set<Speciality> getSpecialties() {
        return this.specialties;
    }

    public void setSpecialties(Set<Speciality> specialties) {
        this.specialties = specialties;
    }

}
