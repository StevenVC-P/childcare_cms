package teksystems.casestudy.database.entitymodels;


import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "age_groups")
public class AgeGroup {

    @Id
    @Column(name="id")
    private Integer id;

    @Column(name="group")
    private String group;

    @Column(name="cost")
    private Integer cost;
}
