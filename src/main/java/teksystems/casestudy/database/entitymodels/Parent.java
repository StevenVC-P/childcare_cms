package teksystems.casestudy.database.entitymodels;


import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "parents")
public class Parent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "primary_contact")
    private String priContact;

    @Column(name = "secondary_contact")
    private String secContact;

    @Column(name = "primary_phone_number")
    private String priPhoneNumber;

    @Column(name = "secondary_phone_number")
    private String secPhoneNumber;

    @Column(name = "email")
    private String eMail;

    @Column(name = "street_address")
    private String streetAddress;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "zip")
    private String zip;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

}
