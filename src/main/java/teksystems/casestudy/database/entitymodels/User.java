package teksystems.casestudy.database.entitymodels;


import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="username")
    private String userName;

    @Column(name="password")
    private String password;

    @Column(name="email")
    private String email;

    @Column(name = "daycare_name")
    private String dayCareName;

    @Column(name="create_date")
    private Date createDate;

//    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
//    private Set<Parent> parents;
}
