package edu.duke.summer.server.database.repository;

import edu.duke.summer.server.database.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {

    Player findById(String id);

    List<Player> findAllByGame(String game);

    boolean existsById(String id);

}