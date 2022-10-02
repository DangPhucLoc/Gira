package cybersoft.Gira.user.service;

import cybersoft.Gira.common.service.GenericService;
import cybersoft.Gira.common.util.GiraMapper;
import cybersoft.Gira.user.dto.UserDTO;
import cybersoft.Gira.user.model.User;
import cybersoft.Gira.user.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

public interface UserService extends GenericService<User, UserDTO, UUID> {

}
@Service
class UserServiceImp implements UserService {
    private UserRepository userRepository;
    public GiraMapper giraMapper;

    UserServiceImp(UserRepository userRepository, GiraMapper giraMapper) {
        this.userRepository = userRepository;
        this.giraMapper = giraMapper;
    }
    @Override
    public JpaRepository<User, UUID> getRepository() {
        return userRepository;
    }

    @Override
    public ModelMapper getMapper() {
        return new GiraMapper();
    }
}
