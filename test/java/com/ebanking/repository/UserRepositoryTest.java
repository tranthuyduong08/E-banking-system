package com.ebanking.repository;

import lombok.Data;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@Data
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TestEntityManager entityManager;

//    @Test
//    void findUserEntityByUsernamePositive() {
//        List<Role> roles = new ArrayList<>();
//        roles.add(new Role((long) 1, "Admin"));
//        User detachedEntity = new User((long)1, "username", "password", roles);
//        entityManager.persist(detachedEntity);
//        entityManager.flush();
//
//        Optional<UserEntity> userEntity = userRepository.findUserEntityByUsername("username");
//        assertEquals(userEntity.isPresent(), true);
//        assertEquals(userEntity.get().getUsername(), "username");
//    }
//
//    @Test
//    void findUserEntityByUsernameNegative() {
//        Optional<UserEntity> userEntity = userRepository.findUserEntityByUsername("username");
//        assertEquals(userEntity.isPresent(), false);
//        assertEquals(userEntity.get().getUsername(), "username");
//    }
}