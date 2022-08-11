package edu.duke.summer.server.algorithm.absyn;

import edu.duke.summer.server.algorithm.StateInfo;
import edu.duke.summer.server.algorithm.RuleInfo;
import edu.duke.summer.server.algorithm.Symbol.Symbol;
import edu.duke.summer.server.algorithm.TypeInfo;
import edu.duke.summer.server.algorithm.VarEntry;
import edu.duke.summer.server.algorithm.value.*;

import java.util.HashMap;
import java.util.Random;

public class TypeDec extends Dec {
   public Symbol typeId;

   public Ty ty;

   public TypeDec(int p, Symbol n, Ty t) {pos=p; typeId=n; ty=t;}

   @Override
   public Value eval(VarEntry varEntry, Random randNumGen, RuleInfo info, StateInfo state) {
       ty.eval(varEntry, randNumGen, info, state);
     if(ty instanceof FieldsTy){
        TypeInfo typeinfo = new TypeInfo(typeId.toString(), ty, info);
        info.addTypes(typeinfo);
     }else if(ty instanceof NameTy){
         //check whether the type exists
         ty.eval(varEntry,randNumGen,info,state);
         String id = ((NameTy) ty).name.toString();
        if(info.getTypes().containsKey(id)){
           TypeInfo referInfo = info.getTypes().get(id);
           TypeInfo newInfo = new TypeInfo(typeId.toString(), referInfo);
           info.addTypes(newInfo);
        }else{
            throw new IllegalArgumentException("Using undefined type!");
        }
     }else if((ty instanceof ArrayTy) || (ty instanceof OptionTy)){
        TypeInfo newInfo = new TypeInfo(typeId.toString(), ty, info);
        info.addTypes(newInfo);
     }else{
        throw new IllegalArgumentException("Invalid type declaration");
      }
      return new VoidValue();
   }
}
