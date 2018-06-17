package migration;

import io.ebean.Ebean;

public class ApplyDbMigration {
    public static void main(String[] args) {
        System.setProperty("disableTestProperties", "true");

        Ebean.getDefaultServer();
    }
}
