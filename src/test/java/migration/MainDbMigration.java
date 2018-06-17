package migration;


import io.ebean.annotation.Platform;
import io.ebean.dbmigration.DbMigration;
import io.ebeaninternal.dbmigration.DefaultDbMigration;

import java.io.IOException;

public class MainDbMigration {


    public static void main(String[] args) throws IOException {
        System.setProperty("ddl.migration.version", "1.0");
        System.setProperty("ddl.migration.name", "initial");

        //        System.setProperty("ddl.migration.pendingDropsFor", "1.2");


        DbMigration dbMigration = new DefaultDbMigration();
        dbMigration.setPlatform(Platform.MYSQL);

        dbMigration.generateMigration();
    }
}
