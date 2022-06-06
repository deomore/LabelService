package vlsu.ProducerCentr.serverside.service;

import vlsu.ProducerCentr.serverside.model.Role;
import vlsu.ProducerCentr.serverside.model.RoleTitle;

public interface RoleService {
    Role findByTitle(RoleTitle title);
}
