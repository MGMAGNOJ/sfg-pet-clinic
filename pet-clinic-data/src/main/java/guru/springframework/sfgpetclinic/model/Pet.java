package guru.springframework.sfgpetclinic.model;

import java.time.LocalDate;

public class Pet extends BaseEntity {

    private String nome;
    private PetType petType;
    private Owner owner;
    private LocalDate birthDate;

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public PetType getPetType() {
        return this.petType;
    }

    public void setPetType(PetType petType) {
        this.petType = petType;
    }

    public Owner getOwner() {
        return this.owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public LocalDate getBirthDate() {
        return this.birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

}
