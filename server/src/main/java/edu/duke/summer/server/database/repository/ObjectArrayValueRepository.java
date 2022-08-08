package edu.duke.summer.server.database.repository;

import edu.duke.summer.server.database.model.ObjectArrayValue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;

import java.util.*;

@Repository
public interface ObjectArrayValueRepository extends JpaRepository<ObjectArrayValue, Long> {

    List<ObjectArrayValue> findByGameId(String gameId);

    @Query("select o from ObjectArrayValue o where o.gameId = :gameId and  o.valueNum = :valueNum order by o.index")
    List<ObjectArrayValue> findArrayValue(@Param("gameId") String gameId, @Param("valueNum") String valueNum);


}