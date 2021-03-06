package ma.emsi.patientsmvc.sec.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.emsi.patientsmvc.sec.entities.AppRole;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class AppUser {
    @Id
    private String UserId;
    @Column(unique = true)
    private String username;
    private String password;
    private boolean active;

    @ManyToMany( fetch = FetchType.EAGER)
    private List<AppRole> appRoles=new ArrayList<>();
}
