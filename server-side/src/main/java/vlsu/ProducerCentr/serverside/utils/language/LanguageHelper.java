package vlsu.ProducerCentr.serverside.utils.language;

import lombok.experimental.UtilityClass;
import org.springframework.stereotype.Component;
import vlsu.ProducerCentr.serverside.model.Answer;
import vlsu.ProducerCentr.serverside.model.Question;
import vlsu.ProducerCentr.serverside.model.Test;

import java.util.List;


@UtilityClass
public class LanguageHelper {
    public static void specifyLanguageInTest(Test test, String languageCode) {
        test.getDescriptions().removeIf(text -> !text.getLanguage().getCode().equals(languageCode));
        test.getQuestions().forEach(
                question -> {
                    specifyLanguageInQuestion(question, languageCode);
                    question.getAnswers().forEach(answer -> specifyLanguageInAnswer(answer, languageCode));
                }
        );
    }

    public static void specifyLanguageInQuestion(Question question, String languageCode) {
        question.getTexts().removeIf(text -> !text.getLanguage().getCode().equals(languageCode));
    }

    public static void specifyLanguageInAnswer(Answer answer, String languageCode) {
        answer.getTexts().removeIf(text -> !text.getLanguage().getCode().equals(languageCode));
    }
}
