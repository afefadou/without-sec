package org.modulemob.postesservice.embadded;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;
import java.util.Objects;


@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString
@Embeddable
public class PosteCompetenceId  implements Serializable {

    @Column(name = "poste_id")
    private String posteId;

    @Column(name ="competence_id")
    private String competenceId;




    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass())
            return false;

        PosteCompetenceId that = (PosteCompetenceId) o;
        return Objects.equals(posteId, that.posteId) &&
                Objects.equals(competenceId, that.competenceId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(posteId, competenceId);
    }


}
