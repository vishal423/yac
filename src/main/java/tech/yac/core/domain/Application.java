package tech.yac.core.domain;

/**
 * Represents YAC Application.
 *
 * @author Vishal Mahajan
 */
public class Application {

    private String name;
    private String location;
    private YacApplication application;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLocation() {
        return location;
    }

    public void setApplication(YacApplication application) {
        this.application = application;
    }

    public YacApplication getApplication() {
        return application;
    }
}
