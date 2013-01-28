package org.apache.cayenne.testdo.embeddable.auto;

import org.apache.cayenne.CayenneDataObject;
import org.apache.cayenne.testdo.embeddable.Embeddable1;

/**
 * Class _EmbedEntity1 was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _EmbedEntity1 extends CayenneDataObject {

    public static final String EMBEDDED1_PROPERTY = "embedded1";
    public static final String EMBEDDED2_PROPERTY = "embedded2";
    public static final String NAME_PROPERTY = "name";

    public static final String ID_PK_COLUMN = "ID";

    public void setEmbedded1(Embeddable1 embedded1) {
        writeProperty(EMBEDDED1_PROPERTY, embedded1);
    }
    public Embeddable1 getEmbedded1() {
        return (Embeddable1)readProperty(EMBEDDED1_PROPERTY);
    }

    public void setEmbedded2(Embeddable1 embedded2) {
        writeProperty(EMBEDDED2_PROPERTY, embedded2);
    }
    public Embeddable1 getEmbedded2() {
        return (Embeddable1)readProperty(EMBEDDED2_PROPERTY);
    }

    public void setName(String name) {
        writeProperty(NAME_PROPERTY, name);
    }
    public String getName() {
        return (String)readProperty(NAME_PROPERTY);
    }

}
