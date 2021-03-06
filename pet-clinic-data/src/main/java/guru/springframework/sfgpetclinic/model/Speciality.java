package guru.springframework.sfgpetclinic.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "specialities")
public class Speciality extends BaseEntity{

    /**
     *
     */
    private static final long serialVersionUID = -1900857801577707939L;
    @Column(name = "description")
    private String description;


    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
