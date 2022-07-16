package edu.duke.summer.client.algorithm.absyn;

import edu.duke.summer.client.algorithm.RollState;
import edu.duke.summer.client.algorithm.RuleInfo;
import edu.duke.summer.client.algorithm.value.Value;

import java.util.HashMap;
import java.util.Random;

public class NilExp extends Exp {
  public NilExp(int p) {pos=p;}

  @Override
  public Value eval(HashMap<String, Value> vars, Random randNumGen, RuleInfo info, RollState state) {
    return null;
  }
}
