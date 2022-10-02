package cybersoft.Gira.common.util;

import cybersoft.Gira.user.dto.UserDTO;
import cybersoft.Gira.user.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GiraMapperTest {
    GiraMapper giraMapper = new GiraMapper();
    @Test
    void testUserMapper() {
        UserDTO userDTO = UserDTO.builder().accountName("kid")
                                            .email("phuc123@gmail.com")
                .build();

        User user = giraMapper.map(userDTO, User.class);

        Assertions.assertEquals(userDTO.getAccountName(), user.getAccountName());
    }
}
