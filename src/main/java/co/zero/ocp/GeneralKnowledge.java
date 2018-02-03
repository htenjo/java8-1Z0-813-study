package co.zero.ocp;

class GeneralKnowledge {
    static final String SHORT = "Short";
    static final String INT = "int";
    static final String INTEGER = "Integer";
    static final String OBJECT = "Object";
    static final String STRING = "String";


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


    /**
     * Helper classes to create examples of java features
     */
    public static class ShapeEqualsWrong {
        private int x, y;

        public ShapeEqualsWrong(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public boolean equals(ShapeEqualsWrong shape) {
            return (shape instanceof ShapeEqualsWrong && shape.x == this.x && shape.y == this.y);
        }
    }

    public static class ShapeEqualsOk {
        private int x, y;

        public ShapeEqualsOk(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public boolean equals(Object shape) {
            return (shape instanceof ShapeEqualsOk
                    && ((ShapeEqualsOk) shape).x == this.x
                    && ((ShapeEqualsOk) shape).y == this.y);
        }
    }


    public static class Shape {
        private int x, y;

        public Shape(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public String getName(int param) {
            return Shape.class.getSimpleName() + param;
        }

        public String getWrapperName(Long param) {
            return Shape.class.getSimpleName() + "Long";
        }
    }

    public static class Circle extends Shape {
        public Circle(int x, int y) {
            super(x, y);
        }

        public String getName(int param) {
            return "OverrideOK";
        }

        public String getName(Integer param) {
            return "OverrideInteger";
        }

        public String getName(Object param) {
            return "OverrideObject";
        }
    }

    public static class Triangle extends Shape {
        public Triangle(int x, int y) {
            super(x, y);
        }

        public String getWrapperName(Long param) {
            return "OverrideOK";
        }

        public String getWrapperName(long param) {
            return "OverrideLowerLong";
        }
    }

    public static class Figure {
        public Shape drawFigure() {
            return new Shape(0, 0);
        }
    }

    public static class Figure3D extends Figure {
        @Override
        public Circle drawFigure() {
            return new Circle(2, 2);
        }
    }

    public static final class MyFunction {
        public final int getRandomInt() {
            return 0;
        }

        @Override
        public Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
    }

    public static final class MyFunctionCloneable implements Cloneable {
        public final int getRandomInt() {
            return 0;
        }

        @Override
        public Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
    }
}
