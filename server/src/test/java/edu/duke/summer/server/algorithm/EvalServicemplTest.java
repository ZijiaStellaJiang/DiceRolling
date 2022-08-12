package edu.duke.summer.server.algorithm;

import edu.duke.summer.server.algorithm.absyn.FieldList;
import edu.duke.summer.server.algorithm.value.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class EvalServicemplTest {

    @Test
    void evalRoll() {
        EvalServicempl input = new EvalServicempl();
        HashMap vars = new HashMap<String, Integer>();
        Random randGen = mock(Random.class);
        when(randGen.nextInt(10)).thenReturn(1);
        when(randGen.nextInt(12)).thenReturn(10);
        vars.put("invisible", 0);
        vars.put("test", 1);
        assertEquals(14, input.evalRoll("(1 + invisible?0:1 + d10 * 6)", vars, randGen));
        assertEquals(13, input.evalRoll("(1 + test?0:1 + d10 * 6)", vars, randGen));
        assertEquals(67, input.evalRoll("(1 + 2d12 * 6)", vars, randGen));
        assertEquals(194, input.evalRoll("(1 + invisible?0:1 + 32 * 6)", vars, new Random()));
        assertEquals(1, input.evalRoll("(1 - invisible?0:1 + 6 / 6)", vars, new Random()));
        assertThrows(IllegalArgumentException.class, ()->input.evalRoll("(1 - notexist?0:1 + 6 / 6)", vars, new Random()));

    }

    @Test
    void saveRules() {
        new EvalServicempl().saveRules("{type rollwithmod {\n" +
                                "    numdice:int,\n" +
                                "    numsides:int option option [],\n" +
                                "    modifier:int [][][] option\n" +
                                "    }\n" +
                                "type test = rollwithmod;\n" +
                                "type newType {\n" +
                                "    a:rollwithmod,\n" +
                                "    b:string option [] option,\n" +
                                "    c:boolean option []\n" +
                                "    }\n" +
                                "}");
    }
    @Test
    public void test_evalRoll() {
        EvalServicempl input = new EvalServicempl();
        HashMap<String, Value> vars = new HashMap<String, Value>();
        Random randGen = mock(Random.class, withSettings().withoutAnnotations());
        when(randGen.nextInt(10)).thenReturn(1);
        when(randGen.nextInt(12)).thenReturn(10);
        vars.put("invisible", new IntValue(0));
        vars.put("test", new IntValue(1));
        assertEquals(14, ((IntValue)input.evalRoll("(1 + invisible?0:1 + d10 * 6)", vars, randGen)).getValue());
        assertEquals(13, ((IntValue)input.evalRoll("(1 + test?0:1 + d10 * 6)", vars, randGen)).getValue());
        assertEquals(133, ((IntValue)input.evalRoll("(1 + 2d12 * 6)", vars, randGen)).getValue());
        assertEquals(194, ((IntValue)input.evalRoll("(1 + invisible?0:1 + 32 * 6)", vars, new Random())).getValue());
        assertEquals(1, ((IntValue)input.evalRoll("(1 - invisible?0:1 + 6 / 6)", vars, new Random())).getValue());
        assertThrows(IllegalArgumentException.class,
                () -> input.evalRoll("(1 - notexist?0:1 + 6 / 6)", vars, new Random()));

    }

    @Test
    public void testFun(){
        RuleInfo info = new EvalServicempl().saveRules("{type rollwithmod {\n" +
                "    numdice:int,\n" +
                "    numsides:int option option [],\n" +
                "    modifier:int [][][] option\n" +
                "    }\n" +
                " type test = rollwithmod;\n" +
                " type newType {\n" +
                "    a:test,\n" +
                "    b:string option [] option,\n" +
                "    c:boolean option []\n" +
                "    }\n" +
                " fun int cal(int a, int x, int y, int z){\n" +
                "    var b = 0;\n" +
                "    var anArray:int [] = {1};\n" +
                "    var sum = 0;\n" +
                "    var opti: int option;\n" +
                "    var userTest : newType;\n" +
                "    userTest.a.numdice = 5;\n" +
                "    opti = SOME(1);\n" +
                "    opti = NONE;\n" +
                "    anArray = {1,2,3,7,10};\n" +
                "    anArray[3] = 10;\n" +
                "    output(a);\n" +
                "    for(i : anArray){\n" +
                "        sum = sum + i;\n" +
                "        if (sum > 10) then { break;}\n" +
                "    }\n" +
                "    a = 1;\n" +
                "    output(a);\n" +
                "    return sum;\n" +
                "    }\n" +
                "   \n" +
                "    fun int test(int i){\n" +
                "        i = 1;\n" +
                "        while(i < 10){\n" +
                "            i = i + 1;\n" +
                "        }\n" +
                "        return i;\n" +
                "    }\n" +
                "    fun int testCallExp(){\n" +
                "        var i = test(20);\n" +
                "        return i;\n" +
                "    }\n" +
                "    fun int testRoll(){\n" +
                "        var i = roll(\"d100\");\n" +
                "        output(i);\n" +
                "        if(userOption(\"Reroll?\")) then{\n" +
                "            var i = 1;\n" +
                "            output(i);\n" +
                "        }\n" +
                "        if(i > 1) then {\n" +
                "            output(\"roll:\" + roll(\"3d4\"));\n" +
                "        }else{\n" +
                "            var i = roll(\"d100\");   \n" +
                "            output(i);\n" +
                "        }\n" +
                "        output(\"force reroll\");\n" +
                "        return i;\n" +
                "   }\n" +
                "}");

        HashMap<String, Value> params = new HashMap<>();

        HashMap<String, Value> params1 = new HashMap<>();
        HashMap<String, Value> params2 = new HashMap<>();
        IntValue value = new IntValue(10);
        IntValue value1 = new IntValue(20);
        params.put("a", value);
        params.put("x", value);
        params.put("y", value);
        params.put("z", value);
        params1.put("i", value1);
//        FuncCallResult res = info.getFuncs().get("cal").getResult(params, new StateInfo());
//        FuncInfo calInfo = info.getFuncs().get("cal");
//        FieldList list = calInfo.getParams();
//        System.out.println("list------");
//        list.printInfo();
//        System.out.println("list------");
//        Value returnValue = res.getVal();
//        FuncCallResult res1 = info.getFuncs().get("test").getResult(params1, new StateInfo());
//        FuncCallResult res2 = info.getFuncs().get("testCallExp").getResult(params2, new StateInfo());
        StateInfo state = new StateInfo();
        state.addTrueUserOption("ru");
        state.addReRollDice("r");
        state.addRoll("r", 41);
        state.addRoll("ruitr", 9);
        FuncCallResult res3 = info.getFuncs().get("testRoll").getResult(params2, state);
        System.out.println("----finalResult----");
//        System.out.println(((IntValue)returnValue).getValue());
//        System.out.println(((IntValue)res1.val).getValue());
//        System.out.println(((IntValue)res2.val).getValue());
        System.out.println(((IntValue)res3.val).getValue());
        res3.printInfo();
        System.out.println("----resInfo----");
        //res3.printInfo();
        ArrayList<String> outputs = res3.getOutput();
        System.out.println("----outputMsg----");
        for(String str : outputs){
            System.out.println(str);
        }

        System.out.println("----testInterface----");
        FuncCallResult funRes = new EvalServicempl().getFunResult("{type rollwithmod {\n" +
                "    numdice:int,\n" +
                "    numsides:int option option [],\n" +
                "    modifier:int [][][] option\n" +
                "    }\n" +
                " type test = rollwithmod;\n" +
                " type newType {\n" +
                "    a:test,\n" +
                "    b:string option [] option,\n" +
                "    c:boolean option []\n" +
                "    }\n" +
                " fun int cal(int a, int x, int y, int z){\n" +
                "    var b = 0;\n" +
                "    var anArray:int [] = {1};\n" +
                "    var sum = 0;\n" +
                "    var opti: int option;\n" +
                "    var userTest : newType;\n" +
                "    userTest.a.numdice = 5;\n" +
                "    opti = SOME(1);\n" +
                "    opti = NONE;\n" +
                "    anArray = {1,2,3,7,10};\n" +
                "    anArray[3] = 10;\n" +
                "    output(a);\n" +
                "    for(i : anArray){\n" +
                "        sum = sum + i;\n" +
                "        if (sum > 10) then { break;}\n" +
                "    }\n" +
                "    a = 1;\n" +
                "    output(a);\n" +
                "    return sum;\n" +
                "    }\n" +
                "   \n" +
                "    fun int test(int i){\n" +
                "        i = 1;\n" +
                "        while(i < 10){\n" +
                "            i = i + 1;\n" +
                "        }\n" +
                "        return i;\n" +
                "    }\n" +
                "    fun int testCallExp(){\n" +
                "        var i = test(20);\n" +
                "        return i;\n" +
                "    }\n" +
                "    fun int testRoll(){\n" +
                "        var i = roll(\"d100\");\n" +
                "        if(userOption(\"Reroll?\")) then{\n" +
                "            var i = 1;\n" +
                "            output(i);\n" +
                "        }\n" +
                "        if(i > 1) then {\n" +
                "            output(\"roll:\" + roll(\"3d4\"));\n" +
                "        }else{\n" +
                "            var i = roll(\"d100\");   \n" +
                "            output(i);\n" +
                "        }\n" +
                "        output(\"force reroll\");\n" +
                "        return i;\n" +
                "   }\n" +
                "}", "cal", params, state);
        System.out.println("finalResult:" + ((IntValue)funRes.val).getValue());
    }


}