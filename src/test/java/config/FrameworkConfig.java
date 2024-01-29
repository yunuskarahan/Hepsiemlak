package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "file:${user.dir}/configuration.properties"
})
public interface FrameworkConfig extends Config {

    @Key("${environment}.status")
    String status();
}