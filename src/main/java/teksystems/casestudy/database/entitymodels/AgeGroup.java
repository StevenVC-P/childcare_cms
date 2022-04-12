package teksystems.casestudy.database.entitymodels;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "age_groups")
public class AgeGroup implements Comparable<AgeGroup>{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="cost")
    private Integer cost;

    @Column(name="age_group")
    private String ageGroup;

    @Column(name="age")
    private Integer age;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Override
    public int compareTo(AgeGroup o) {
        if (getAge()== null || o.getAge()==null) {
            return 0;
        }
        return getAge().compareTo(o.getAge());
    }
}
