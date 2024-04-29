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
public class CollabCompetenceId  implements Serializable {

    @Column(name = "collab_id")
    private Long collabId;

    @Column(name ="competence_id")
    private String competenceId;




    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass())
            return false;

        CollabCompetenceId that = (CollabCompetenceId) o;
        return Objects.equals(collabId, that.collabId) &&
                Objects.equals(competenceId, that.competenceId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(collabId, competenceId);
    }


}
