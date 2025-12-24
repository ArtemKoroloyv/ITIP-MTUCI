import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface DataProcessor {

    // порядок применения процессоров
    int order() default 0;

    // можно ли обрабатывать данные параллельно кусками
    boolean chunkable() default true;
}
