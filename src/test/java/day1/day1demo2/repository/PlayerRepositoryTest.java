package day1.day1demo2.repository;

import day1.day1demo2.entity.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class PlayerRepositoryTest {

    @Autowired
    PlayerRepository playerRepository;
    boolean isInitialized = false;

    @BeforeEach
    void setUp() {
        if(!isInitialized) {
            playerRepository.deleteAll();
            playerRepository.save((new Player("Lionel Messi", "Argentina", "Forward")));
            playerRepository.save((new Player("Kylian Mbappe", "France", "Forward")));
            isInitialized = true;
        }
    }

    @Test
    public void deleteAll() {
        playerRepository.deleteAll();
        assertEquals(0, playerRepository.count());
    }
    @Test
    public void testAll() {
        Long count = playerRepository.count();
        assertEquals(2, count);
    }

    @Test
    void findByName() {
        Player p1 = playerRepository.findByName("Lionel Messi");
        assertEquals("Lionel Messi", p1.getName());
    }


    @Test
    void findByNameLike() {
        Player p = playerRepository.findByNameLike("%Mbappe");
        assertEquals("Kylian Mbappe", p.getName());
    }
}