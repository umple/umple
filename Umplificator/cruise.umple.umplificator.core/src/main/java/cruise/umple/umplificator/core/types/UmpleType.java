package cruise.umple.umplificator.core.types;

public enum UmpleType {
	STRING {
	    public String toString() {
	        return "String";
	    }
	},

	INTEGER {
	    public String toString() {
	        return "Integer";
	    }
	},
	BOOLEAN {
	    public String toString() {
	        return "boolean";
	    }
	},
	DATE {
	    public String toString() {
	        return "Date";
	    }
	},
	CONST {
	    public String toString() {
	        return "const";
	    }
	},
	TIME {
	    public String toString() {
	        return "Time";
	    }
	}
}
