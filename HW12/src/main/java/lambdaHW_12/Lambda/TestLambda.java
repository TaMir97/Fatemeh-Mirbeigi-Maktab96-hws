package lambdaHW_12.Lambda;

import java.util.function.Function;
import java.util.function.ToIntFunction;
import java.util.function.UnaryOperator;

public class TestLambda {
    public static UnaryOperator<Function<String, String>> composeWithTrimFunction() {
        return new UnaryOperator() {
            @Override
            public Object apply(Object o) {
                return new Function<String, String>() {
                    @Override
                    public String apply(String s) {
                        return s.trim();
                    }
                };
            }
        };
    }





}
