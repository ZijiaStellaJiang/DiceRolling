package edu.duke.summer.client.service;

import java.util.List;

import edu.duke.summer.client.algorithm.RuleInfo;
import edu.duke.summer.client.database.model.Game;
import edu.duke.summer.client.database.model.DiceRolling;
import edu.duke.summer.client.database.model.MagicCheck;
import edu.duke.summer.client.database.model.Player;
import edu.duke.summer.client.dto.*;
import org.springframework.stereotype.Service;

@Service
public interface GameService {
  
  Game createNewGame(final CreateGameDto createGameDto);

  List<Game> filterGame(final GameFilterDto gameFilterDto);

  Game joinGame(final CreateGameDto createGameDto);

  void deleteGame(final Game game);

  /**
   * Get result of the dice-rolling
   *
   * @param diceRollingDto the diceRollingDto contains information of player, game and raw string with visibilities and the choice of magicCheck
   *        diceRollingDto {
   *          game: the game that the player is involved in
   *          player: the player who did this dice-rolling
   *          rawData: the raw string of this dice-rolling
   *          visibles: which players could view this dice-rolling result
   *          magicCheck: whether this dice-rolling would conduct magicCheck or not
   *        }
   * @return result of dice-rolling after parsing
   */
  DiceRolling getDiceRollingResults(DiceRollingDto diceRollingDto);


  /**
   * Get the recent 20 visible dice-rolling results of one player in the game
   *
   * @param game the game that the player is involved in
   * @param player the player that seek for recent 20 visible dice-rolling results
   * @return recent 20 visible dice-rolling results
   */
  List<DiceRolling> getPlayerResults(String game, String player);

  /**
   * Get the magic check of one player in the game
   *
   * @param game the game that the player is involved in
   * @param player the player that seek for magic check
   * @return list of magic check
   */
  List<MagicCheck> getMagicCheckData(String game, String player);

  /**
   * Get all players that are involved in the game
   *
   * @param game the game that the player is involved in
   * @return list of players in the game
   */
  List<Player> getAllPlayers(String game);

  /**
   * Create and store object types & fields through the code provided by the game creator
   *
   * @param gameId the game that the creator is involved in
   * @param code the code that contains the description of objects
   */
  void createObjects(String gameId, String code);

  /**
   * Get all object types in the game
   *
   * @param gameId the game to get all the object types involved in
   * @return list of object types in the game
   */
  List<String> getObjectsList(String gameId);

  /**
   * Get all field names & field types of one object type in the game
   *
   * @param gameId the game to get the object fields
   * @param typeName the object type to get its field name & field type
   * @return objectFieldDto that contains all field information of the object type in this game
   */
  ObjectFieldDto getObjectFields(String gameId, String typeName);

  /**
   * Check whether a new object is required to be created for this object field
   * @param type the type of this object field
   * @return TRUE if this field type is int/string/bool, FALSE otherwise
   */
  Boolean checkWhetherNewObjectRequired(String type);

  /**
   * delete user specified fields of one object
   * @param gameId specify the gameId of delete operation
   * @param objectName specify the object in the game
   * @param toDelete the field name that user wants to delete
   */
  void deleteObjectField(String gameId, String objectName, String toDelete);

  /**
   * add some other fields when the object is already exist
   * @param gameId specify the gameId of the insert operation
   * @param code the code that contains the description of the object and fields
   *             should be the same format as createObjects function
   */
  void addObjectFields(String gameId, String code);

  /**
   * Store field values of one object
   *
   * @param objectValueDto the Dto that contains all the information of one specific object,
   * including game ID, type name and field values
   * @return the value number of the object in database
   */
  String saveObjects(ObjectValueDto objectValueDto);

  /**
   * Store field values of one array
   *
   * @param objectValueDto the Dto that contains all the information of one specific array,
   * including game ID, elt name and field values
   * @return the value number of the array in database
   */
  String saveArrays(ObjectValueDto objectValueDto);

  /**
   * Get all field values of one object type in the game
   *
   * @param gameId the game which the object is created in
   * @param typeName the object type to get its field values
   * @param valueNum the value number of the object
   * @return objectFieldDto that contains all field information of the object in this game
   */
  ObjectValueDto getObjectValues(String gameId, String typeName, String valueNum);

  /**
   * Get all field values of one array object type in the game
   *
   * @param gameId the game which the array is created in
   * @param valueNum the value number of the array
   * @return objectFieldDto that contains all field information of the array in this game
   */
  ObjectValueDto getArrayValues(String gameId, String valueNum);

  public void createFunction(String gameId, String code);
}
