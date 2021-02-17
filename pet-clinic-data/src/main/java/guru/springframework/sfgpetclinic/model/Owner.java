package guru.springframework.sfgpetclinic.model;

import java.util.HashSet;
import java.util.Set;

public class Owner extends Person {

    private String address;
    private String city;
    private String fone;
    private Set<Pet> pets = new HashSet<>();


    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getFone() {
        return this.fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }


    public Set<Pet> getPets() {
        return this.pets;
    }

    public void setPets(Set<Pet> pets) {
        this.pets = pets;
    }

    
    
}
