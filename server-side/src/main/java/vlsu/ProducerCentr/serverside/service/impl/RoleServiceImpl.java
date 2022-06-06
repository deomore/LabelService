package vlsu.ProducerCentr.serverside.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import vlsu.ProducerCentr.serverside.model.Role;
import vlsu.ProducerCentr.serverside.model.RoleTitle;
import vlsu.ProducerCentr.serverside.repository.RoleRepository;
import vlsu.ProducerCentr.serverside.service.RoleService;

@RequiredArgsConstructor
@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository repository;

    @Override
    public Role findByTitle(RoleTitle title) {
        return repository.findByTitle(title);
    }
}
