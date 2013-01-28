package org.apache.cayenne.testdo.inheritance_flat.auto;

import org.apache.cayenne.testdo.inheritance_flat.Role;
import org.apache.cayenne.testdo.inheritance_flat.UserProperties;

/**
 * Class _User was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _User extends Role {

    public static final String USER_PROPERTIES_PROPERTY = "userProperties";

    public static final String ID_PK_COLUMN = "id";

    public void setUserProperties(UserProperties userProperties) {
        setToOneTarget(USER_PROPERTIES_PROPERTY, userProperties, true);
    }

    public UserProperties getUserProperties() {
        return (UserProperties)readProperty(USER_PROPERTIES_PROPERTY);
    }


}
