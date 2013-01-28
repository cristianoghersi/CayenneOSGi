package org.apache.cayenne.testdo.mt.auto;

import org.apache.cayenne.CayenneDataObject;
import org.apache.cayenne.testdo.mt.MtTable1;
import org.apache.cayenne.testdo.mt.MtTable3;

/**
 * Class _MtTable2 was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _MtTable2 extends CayenneDataObject {

    public static final String GLOBAL_ATTRIBUTE_PROPERTY = "globalAttribute";
    public static final String TABLE1_PROPERTY = "table1";
    public static final String TABLE3_PROPERTY = "table3";

    public static final String TABLE2_ID_PK_COLUMN = "TABLE2_ID";

    public void setGlobalAttribute(String globalAttribute) {
        writeProperty(GLOBAL_ATTRIBUTE_PROPERTY, globalAttribute);
    }
    public String getGlobalAttribute() {
        return (String)readProperty(GLOBAL_ATTRIBUTE_PROPERTY);
    }

    public void setTable1(MtTable1 table1) {
        setToOneTarget(TABLE1_PROPERTY, table1, true);
    }

    public MtTable1 getTable1() {
        return (MtTable1)readProperty(TABLE1_PROPERTY);
    }


    public void setTable3(MtTable3 table3) {
        setToOneTarget(TABLE3_PROPERTY, table3, true);
    }

    public MtTable3 getTable3() {
        return (MtTable3)readProperty(TABLE3_PROPERTY);
    }


}
