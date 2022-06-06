package vlsu.ProducerCentr.serverside.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@Entity(name = "texts")
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Accessors(chain = true)
public class Text extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "language_id")
    private Language language;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;

    @ManyToOne
    @JoinColumn(name = "answer_id")
    private Answer answer;

    @ManyToOne
    @JoinColumn(name = "test_id")
    private Test test;

    @Column(name = "test_title")
    private String testTitle;

    @Column(name = "test_time")
    private String testTime;

    @ManyToOne
    @JoinColumn(name = "result_id")
    private TestResult result;

    private String text;
}
