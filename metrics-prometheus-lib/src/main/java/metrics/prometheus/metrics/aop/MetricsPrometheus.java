package metrics.prometheus.metrics.aop;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MetricsPrometheus {

    String success() default "";
    String fail() default "";
    String help() default "";
}
