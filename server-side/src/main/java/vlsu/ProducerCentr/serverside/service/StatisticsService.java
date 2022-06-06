package vlsu.ProducerCentr.serverside.service;

import vlsu.ProducerCentr.serverside.dto.test.taken.ResultQuantityStatisticDto;
import vlsu.ProducerCentr.serverside.dto.test.taken.TakenTestDetailsDto;
import vlsu.ProducerCentr.serverside.dto.test.taken.TakenTestTimeStatisticDto;

import java.util.UUID;

public interface StatisticsService {
    TakenTestTimeStatisticDto getResultsInTime(UUID testExternalId, String languageCode);
    TakenTestTimeStatisticDto getResultOfClient(UUID testExternalId, String languageCode, UUID clientExternalId);
    ResultQuantityStatisticDto getResultQuantity(UUID testExternalId, String languageCode);
    ResultQuantityStatisticDto getMyResults(String languageCode, UUID testExternalId);
}
