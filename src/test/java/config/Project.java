package config;
import org.aeonbits.owner.ConfigFactory;

public class Project {
    public static MobileProject config = ConfigFactory.create(MobileProject.class, System.getProperties());
}
