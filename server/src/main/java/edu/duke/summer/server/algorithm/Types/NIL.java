package edu.duke.summer.server.algorithm.Types;

public class NIL extends Type {
	public NIL () {}
	public boolean coerceTo(Type t) {
	    Type a = t.actual();
	    return (a instanceof STRUCT) || (a instanceof NIL);
        }
}

