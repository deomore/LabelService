package vlsu.ProducerCentr.serverside.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Data
@Entity(name = "tests")
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Test extends BaseEntity {
    @Column(name = "external_id")
    private UUID externalId = UUID.randomUUID();
    @Column(name = "gender_depending")
    private Boolean isGenderDepending;
    @Column(name = "re_answer_enabled")
    private Boolean isReAnswerEnabled;
    @Column(name = "proceeding_type")
    @Enumerated(value = EnumType.STRING)
    private ProceedingType proceedingType;
    @OneToMany(mappedBy = "test")
    private List<Question> questions;
    @OneToMany(mappedBy = "test")
    private List<Text> descriptions;
    @OneToMany(mappedBy = "test")
    private List<TestResult> results;
}
