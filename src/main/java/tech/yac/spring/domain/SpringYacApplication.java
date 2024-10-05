package tech.yac.spring.domain;

import tech.yac.core.domain.BackendYacApplication;
import tech.yac.core.domain.FrameworkType;

public class SpringYacApplication extends BackendYacApplication {

    @Override
    public FrameworkType getFrameworkType() {
        return FrameworkType.SPRING;
    }
}
