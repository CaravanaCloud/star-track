package startrack.api;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.annotations.QuarkusMain;

@QuarkusMain
public class APIMain {
    public static void main(String[] args) {
        System.out.println("Running API main method");
        Quarkus.run(args);
    }
}
