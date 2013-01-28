package org.apache.cayenne.testdo.locking.auto;

import org.apache.cayenne.CayenneDataObject;
import org.apache.cayenne.testdo.locking.RelLockingTestEntity;

/**
 * Class _LockingHelper was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _LockingHelper extends CayenneDataObject {

    public static final String NAME_PROPERTY = "name";
    public static final String TO_REL_LOCKING_TEST_PROPERTY = "toRelLockingTest";

    public static final String LOCKING_HELPER_ID_PK_COLUMN = "LOCKING_HELPER_ID";

    public void setName(String name) {
        writeProperty(NAME_PROPERTY, name);
    }
    public String getName() {
        return (String)readProperty(NAME_PROPERTY);
    }

    public void setToRelLockingTest(RelLockingTestEntity toRelLockingTest) {
        setToOneTarget(TO_REL_LOCKING_TEST_PROPERTY, toRelLockingTest, true);
    }

    public RelLockingTestEntity getToRelLockingTest() {
        return (RelLockingTestEntity)readProperty(TO_REL_LOCKING_TEST_PROPERTY);
    }


}
