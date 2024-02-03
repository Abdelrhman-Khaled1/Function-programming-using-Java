package functionalInterface;

import java.util.function.BiFunction;
import java.util.function.Function;

public class _Function {
    public static void main(String[] args) {
        int increment = incrementByOne(0);
        System.out.println(increment);

        int increment2 = incrementByOneFunction.apply(1);
        System.out.println(increment2);

        int multiplyBy10 = multiplyBy10Function.apply(increment2);
        System.out.println(multiplyBy10);

        //combine two functions together
        Function<Integer, Integer> add1AndThenMultiplyBy10 = incrementByOneFunction.andThen(multiplyBy10Function);
        Integer apply = add1AndThenMultiplyBy10.apply(1);
        System.out.println(apply);

        System.out.println(incrementByOneFunction.andThen(multiplyBy10Function).apply(10));//11*10=110

        //BiFunction
        System.out.println(incrementByOneAndMultiply(1, 3));
        System.out.println(incrementByOneAndMultiplyBiFunction.apply(1, 3));

    }

    static Function<Integer, Integer> incrementByOneFunction = number -> number + 1;
    static Function<Integer, Integer> multiplyBy10Function = number -> number * 10;

    static int incrementByOne(int num) {
        return num + 1;
    }


    static BiFunction<Integer, Integer, Integer> incrementByOneAndMultiplyBiFunction =
            (num, numToMultiplyBy) -> (num + 1) * numToMultiplyBy;

    static int incrementByOneAndMultiply(int num, int numToMultiplyBy) {
        return (num + 1) * numToMultiplyBy;
    }
}
