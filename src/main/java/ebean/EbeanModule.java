package ebean;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import ebean.annotation.ReadEbeanServer;
import ebean.annotation.WriteEbeanServer;
import io.ebean.Ebean;
import io.ebean.EbeanServer;
import io.ebean.EbeanServerFactory;
import io.ebean.config.ServerConfig;
import ninja.utils.NinjaProperties;

public class EbeanModule extends AbstractModule {

    private NinjaProperties ninjaProperties;

    public EbeanModule(NinjaProperties ninjaProperties) {
        this.ninjaProperties = ninjaProperties;
    }

    @Override
    protected void configure() {
        ServerConfig readConfig = new ServerConfig();
        readConfig.setName("read");
        readConfig.setRegister(true);
        readConfig.loadFromProperties(ninjaProperties.getAllCurrentNinjaProperties());

        ServerConfig writeConfig = new ServerConfig();
        writeConfig.setName("write");
        writeConfig.setRegister(true);
        writeConfig.loadFromProperties(ninjaProperties.getAllCurrentNinjaProperties());
        EbeanServerFactory.create(readConfig);
        EbeanServerFactory.create(writeConfig);
    }

    @Provides
    @ReadEbeanServer
    public EbeanServer provideReadEbeanServer() {
        return Ebean.getServer("read");
    }

    @Provides
    @WriteEbeanServer
    public EbeanServer provideWriteEbeanServer() {
        return Ebean.getServer("write");
    }
}
