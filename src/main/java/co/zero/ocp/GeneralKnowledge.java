package co.zero.ocp;

class GeneralKnowledge {
    public static final String SHORT = "Short";
    public static final String INT = "int";
    public static final String INTEGER = "Integer";
    public static final String OBJECT = "Object";
    public static final String STRING = "String";


    static String overloadingPrint(short number) {
        return SHORT;
    }

    static String overloadingPrint(String number) {
        return STRING;
    }

    static String overloadingPrint(Object number) {
        return OBJECT;
    }


    static String overloadingPrint(int number) {
        return INT;
    }


    static String overloadingUp(short number) {
        return SHORT;
    }

    static String overloadingUp(Integer number) {
        return INTEGER;
    }

    static String overloadingUp(Object number) {
        return OBJECT;
    }

    static String overloadingDown(short number) {
        return SHORT;
    }

    static String overloadingDown(Object number) {
        return OBJECT;
    }
}
