package vlsu.ProducerCentr.serverside.service;

import vlsu.ProducerCentr.serverside.model.User;

import java.util.List;
import java.util.UUID;

public interface UserService {
    User findByLogin(String login);
}
