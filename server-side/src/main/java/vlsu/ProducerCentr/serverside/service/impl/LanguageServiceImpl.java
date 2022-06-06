package vlsu.ProducerCentr.serverside.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import vlsu.ProducerCentr.serverside.model.Language;
import vlsu.ProducerCentr.serverside.repository.LanguageRepository;
import vlsu.ProducerCentr.serverside.service.LanguageService;

@Service
@RequiredArgsConstructor
public class LanguageServiceImpl implements LanguageService {
    private final LanguageRepository repository;

    @Override
    public boolean existsByCode(String code) {
        return repository.existsByCode(code);
    }

    @Override
    public Language findByCode(String code) {
        return repository.findByCode(code);
    }
}
