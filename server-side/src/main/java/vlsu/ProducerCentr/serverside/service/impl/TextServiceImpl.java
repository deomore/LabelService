package vlsu.ProducerCentr.serverside.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import vlsu.ProducerCentr.serverside.model.Language;
import vlsu.ProducerCentr.serverside.model.TestResult;
import vlsu.ProducerCentr.serverside.model.Text;
import vlsu.ProducerCentr.serverside.repository.TextRepository;
import vlsu.ProducerCentr.serverside.service.LanguageService;
import vlsu.ProducerCentr.serverside.service.TextService;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TextServiceImpl implements TextService {
    private final TextRepository repository;
    private final LanguageService languageService;

    @Override
    @Transactional
    public void save(Text text) {
        repository.save(text);
    }

    @Override
    public void saveForResult(String text, String languageCode, TestResult result) {
        Language language = languageService.findByCode(languageCode);
        Text textObj = new Text();
        textObj.setText(text);
        textObj.setResult(result);
        textObj.setLanguage(language);
        save(textObj);
    }

    @Override
    public List<Text> findByTestId(Integer testExternalId) {
        return repository.findByTestId(testExternalId);
    }
}
