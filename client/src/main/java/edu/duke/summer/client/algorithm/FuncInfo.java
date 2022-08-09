package edu.duke.summer.client.algorithm;

import edu.duke.summer.client.algorithm.absyn.*;
import edu.duke.summer.client.algorithm.value.Value;

import java.util.HashMap;
import java.util.Map;

public class FuncInfo {
    String funcName;
    FieldList params;
    Ty returnType;

    CalInfo calInfo;

    Stmt body;

    public void setCalInfo(CalInfo calInfo) {
        this.calInfo = calInfo;
    }

    public FuncInfo(String s, FieldList p){
        params = p;
        funcName = s;
        body = new BuildInFuncStmt(s, params);
    }

    public FuncInfo(String s, FieldList p, Ty rt, CalInfo i, Stmt b){
        funcName = s;
        params = p;
        returnType = rt;
        calInfo = i;
        body = b;
    }

    public String getFuncName() {
        return funcName;
    }

    public FieldList getParams() {
        return params;
    }

    public void setBody(Stmt body) {
        this.body = body;
    }

    public void setFuncName(String funcName) {
        this.funcName = funcName;
    }

    public void setInfo(CalInfo info) {
        this.calInfo = info;
    }

    public void setParams(FieldList params) {
        this.params = params;
    }

    public void setReturnType(Ty returnType) {
        this.returnType = returnType;
    }

    public FuncCallResult getResult(HashMap<String, Value> params, StateInfo info){
        calInfo.varEntry.getVars(info.getBlockId()).putAll(params);
        Value returnValue = body.eval(calInfo.varEntry, calInfo.randNumGen, calInfo.info, info);
        for(Map.Entry<String, Value> entry : params.entrySet()){
            calInfo.varEntry.getVars(info.getBlockId()).remove(entry.getKey());
        }
        info.setReturnMark(false);
        info.setBreakMark(false);

        return new FuncCallResult(returnValue, calInfo.info, info);
    }

}