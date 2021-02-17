package guru.springframework.sfgpetclinic.bootstrap;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.Pet;
import guru.springframework.sfgpetclinic.model.PetType;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.services.PetService;
import guru.springframework.sfgpetclinic.services.PetTypeService;
import guru.springframework.sfgpetclinic.services.VetService;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {

        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        Long i = (long) 1;

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType saveDogPetType = petTypeService.save(dog);

        System.out.println("Save Pet Type DOG: " + i++);

        PetType cat = new PetType();
        dog.setName("Cat");
        PetType saveCatPetType = petTypeService.save(cat);

        System.out.println("Save Pet Type CAT: " + i++);

        i = (long) 0;

        Owner owner1 = new Owner();
        owner1.setId(++i);
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");
        owner1.setAddress("Rx");
        owner1.setFone("555");
        owner1.setCity("Fpolis");

        Pet mikesPet = new Pet();
        mikesPet.setPetType(saveDogPetType);
        mikesPet.setBirthDate(LocalDate.now());
        mikesPet.setOwner(owner1);
        mikesPet.setNome("Dog1");
        mikesPet.setOwner(owner1);
        owner1.getPets().add(mikesPet);
        ownerService.save(owner1);

        System.out.println("Loaded Owner: " + i);

        Owner owner2 = new Owner();
        owner2.setId(++i);
        owner2.setFirstName("Fiona");
        owner2.setLastName("Glenanne");
        owner2.setAddress("Rx");
        owner2.setFone("555");
        owner2.setCity("Fpolis");

        Pet fionasCat = new Pet();
        fionasCat.setPetType(saveCatPetType);
        fionasCat.setBirthDate(LocalDate.now());
        fionasCat.setOwner(owner2);
        fionasCat.setNome("Gato1");
        owner2.getPets().add(fionasCat);
        ownerService.save(owner2);

        System.out.println("Loaded Owner: " + i);

        i = (long) 0;
        
        Vet vet1 = new Vet();
        vet1.setId(++i);
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");

        vetService.save(vet1);

        

        System.out.println("Loaded Vets...." + i);

        Vet vet2 = new Vet();
        vet2.setId(++i);
        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");

        System.out.println("Loaded Vets...."+ i);
        vetService.save(vet2);
    }

}
