package guru.springframework.sfgpetclinic.services.springdatajpa;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.repositories.OwnerRepository;
import guru.springframework.sfgpetclinic.repositories.PetRepository;
import guru.springframework.sfgpetclinic.repositories.PetTypeRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
@Slf4j

public class OwnerSDJpaServiceTest {

    @Mock 
    OwnerRepository ownerRepository;
    @Mock
    PetRepository petRepository;
    @Mock
    PetTypeRepository petTypeRepository;

    @InjectMocks
    OwnerSDJpaService ownerSDJpaService;


    @BeforeEach

    void setUp(){

    }

    // TESTE usando as funções de auto teste do Mockito e do Lombok


    @Test
    void findByLastName(){

        Owner owner = Owner.builder()
                .id(1L)
                .firstName("Jhon")
                .build();


        when(ownerRepository.findByLastName(any())).thenReturn(owner);

        Owner someOne = ownerSDJpaService.findByLastName("Weston");

        log.warn("Passei neste teste");
        log.info(someOne.getFirstName());
        assertEquals("Jhon", someOne.getFirstName());
    }

    @Test
    void findAll(){
        Set<Owner> owners = new HashSet<>();
        owners.add(Owner.builder().id(1L).firstName("Mad").lastName("Man").build());
        owners.add(Owner.builder().id(2L).firstName("Crazy").lastName("Woman").build());

        when(ownerRepository.findAll()).thenReturn(owners);

        Set<Owner> returnOwners = ownerSDJpaService.findAll();

        assertNotNull(returnOwners);

        assertEquals(2, returnOwners.size());

    }

    @Test
    void findById(){
        Owner owner = Owner.builder()
                .id(1L)
                .firstName("Jhon")
                .build();

        when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(owner));

        Owner returnedOwner = ownerSDJpaService.findById(1L);

        assertNotNull(returnedOwner);

    }

    @Test
    void findByIdNotFound(){
        Owner owner = Owner.builder()
                .id(1L)
                .firstName("Jhon")
                .build();

        when(ownerRepository.findById(anyLong())).thenReturn(Optional.empty());

        Owner returnedOwner = ownerSDJpaService.findById(1L);

        assertNull(returnedOwner);

    }

    @Test
    void save(){
        Owner ownerToSave = Owner.builder().id(1L).firstName("Mad").lastName("Man").build();

        when(ownerRepository.save(any())).thenReturn(ownerToSave);

        Owner savedOwner = ownerSDJpaService.save(ownerToSave);

        assertNotNull(savedOwner);

        verify(ownerRepository).save(any());

    }

    @Test
    void delete(){
        Owner owner = Owner.builder()
                .id(1L)
                .firstName("Jhon")
                .build();

        ownerSDJpaService.delete(owner);

        verify(ownerRepository, times(1)).delete(any());


    }
    @Test
    void deleteById(){
        Owner owner = Owner.builder()
                .id(1L)
                .firstName("Jhon")
                .build();

        ownerSDJpaService.deleteById(owner.getId());

        verify(ownerRepository, times(1)).deleteById(anyLong());


    }

}
