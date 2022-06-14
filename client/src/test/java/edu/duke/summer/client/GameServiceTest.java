package edu.duke.summer.client;

import edu.duke.summer.client.config.SpringConfig;
import edu.duke.summer.client.database.model.DiceRolling;
import edu.duke.summer.client.database.model.Player;
import edu.duke.summer.client.database.repository.PlayerRepository;
import edu.duke.summer.client.dto.DiceRollingDto;
import edu.duke.summer.client.service.GameService;
import edu.duke.summer.client.service.GameServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

@ContextConfiguration(classes = SpringConfig.class)
@SpringBootTest
public class GameServiceTest {
    @Autowired
    private GameService gameService;

    @Autowired
    private PlayerRepository playerRepository;

    @Test
    public void getDiceRollingResultsTest() {
        List<String> visibles = new ArrayList<>();
        visibles.add("user1");
        visibles.add("user2");
        DiceRollingDto diceRollingDto = new DiceRollingDto("1", "user", "d4+20", visibles, true);
        DiceRolling diceRolling = gameService.getDiceRollingResults(diceRollingDto);
        String result = diceRolling.getResult();
        System.out.println("result: " + result);
    }

    @Test
    public void getPlayerResultsTest() {
        List<String> visible1 = new ArrayList<>();
        visible1.add("user3");
        List<String> visible2 = new ArrayList<>();
        visible1.add("user4");
        DiceRollingDto diceRollingDto1 = new DiceRollingDto("1", "user", "d4+20", visible1, true);
        DiceRolling diceRolling1 = gameService.getDiceRollingResults(diceRollingDto1);
        DiceRollingDto diceRollingDto2 = new DiceRollingDto("2", "user", "d4+20", visible1, true);
        DiceRolling diceRolling2 = gameService.getDiceRollingResults(diceRollingDto2);
        DiceRollingDto diceRollingDto3 = new DiceRollingDto("1", "user", "d4+20", visible2, true);
        DiceRolling diceRolling3 = gameService.getDiceRollingResults(diceRollingDto3);
        assertEquals(1, gameService.getPlayerResults("1", "user3").size());
    }

    @Test
    public void getMagicCheckDataTest() {
        List<String> visibles = new ArrayList<>();
        visibles.add("user5");
        visibles.add("user6");
        DiceRollingDto diceRollingDto1 = new DiceRollingDto("1", "user0", "d4+20", visibles, true);
        DiceRolling diceRolling1 = gameService.getDiceRollingResults(diceRollingDto1);
        DiceRollingDto diceRollingDto2 = new DiceRollingDto("1", "user0", "d4+20", visibles, false);
        DiceRolling diceRolling2 = gameService.getDiceRollingResults(diceRollingDto2);
        DiceRollingDto diceRollingDto3 = new DiceRollingDto("2", "user0", "d4+20", visibles, true);
        DiceRolling diceRolling3 = gameService.getDiceRollingResults(diceRollingDto3);
        assertEquals(1, gameService.getMagicCheckData("1", "user0").size());
    }

    @Test
    public void getAllPlayersTest() {
        Player player1 = new Player();
        player1.setGame("test1");
        player1.setUserId("user1");
        playerRepository.save(player1);
        Player player2 = new Player();
        player2.setGame("test2");
        player2.setUserId("user2");
        playerRepository.save(player2);
        Player player3 = new Player();
        player3.setGame("test1");
        player3.setUserId("user3");
        playerRepository.save(player3);
        assertEquals(2, gameService.getAllPlayers("test1").size());
    }

}
