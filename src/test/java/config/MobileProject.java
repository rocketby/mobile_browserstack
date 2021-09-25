package config;

import org.aeonbits.owner.Config;
@Config.Sources({
        "classpath:mobile.properties"
})
public interface MobileProject extends Config {
    @Key("browserstack_url")
    String browserstack_url();

    @Key("username")
    String username();

    @Key("password")
    String password();

    @Key("app")
    String app();

    @DefaultValue("Google Pixel 3")
    @Key("device")
    String device();

    @DefaultValue("9.0")
    @Key("os_version")
    String os_version();

}
