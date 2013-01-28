package org.apache.cayenne.testdo.testmap.auto;

/** Class _GeneratedColumnDep was generated by Cayenne.
  * It is probably a good idea to avoid changing this class manually, 
  * since it may be overwritten next time code is regenerated. 
  * If you need to make any customizations, please use subclass. 
  */
public abstract class _GeneratedColumnDep extends org.apache.cayenne.CayenneDataObject {

    public static final String NAME_PROPERTY = "name";
    public static final String TO_MASTER_PROPERTY = "toMaster";

    public static final String GENERATED_COLUMN_FK_PK_COLUMN = "GENERATED_COLUMN_FK";

    public void setName(String name) {
        writeProperty("name", name);
    }
    public String getName() {
        return (String)readProperty("name");
    }
    
    
    public void setToMaster(org.apache.cayenne.testdo.testmap.GeneratedColumnTestEntity toMaster) {
        setToOneTarget("toMaster", toMaster, true);
    }

    public org.apache.cayenne.testdo.testmap.GeneratedColumnTestEntity getToMaster() {
        return (org.apache.cayenne.testdo.testmap.GeneratedColumnTestEntity)readProperty("toMaster");
    } 
    
    
}
