package startrack.app;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.annotations.QuarkusMain;

@QuarkusMain
public class APPMain {
        public static void main(String[] args) {
            System.out.println("Running APP main method");
            Quarkus.run(args);
        }
}
