package edu.duke.summer.server.algorithm.absyn;

import edu.duke.summer.server.algorithm.StateInfo;
import edu.duke.summer.server.algorithm.RuleInfo;
import edu.duke.summer.server.algorithm.VarEntry;
import edu.duke.summer.server.algorithm.value.OptionValue;
import edu.duke.summer.server.algorithm.value.Value;
import edu.duke.summer.server.algorithm.value.VoidValue;

import java.util.HashMap;
import java.util.Random;

public class OptionExp extends Exp{
    Boolean bool;
    Exp val;

    public OptionExp(Boolean b, Exp v){
        bool = b;
        val = v;
    }

    public OptionExp(Boolean b){
        bool = b;
    }
    @Override
    public Value eval(VarEntry varEntry, Random randNumGen, RuleInfo info, StateInfo state) {
        if(bool.equals(true)) {
            Value value = val.eval(varEntry, randNumGen, info, state);
            return new OptionValue(bool, value);
        }else{
            return new OptionValue(false, new VoidValue());
        }
    }
}
