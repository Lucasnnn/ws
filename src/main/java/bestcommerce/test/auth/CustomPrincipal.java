package bestcommerce.test.auth;

import java.security.Principal;

public class CustomPrincipal implements Principal {
    private String id;

    public CustomPrincipal(String id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return id;
    }
}