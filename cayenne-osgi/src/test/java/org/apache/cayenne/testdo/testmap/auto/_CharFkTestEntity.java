package org.apache.cayenne.testdo.testmap.auto;

/** Class _CharFkTestEntity was generated by Cayenne.
  * It is probably a good idea to avoid changing this class manually, 
  * since it may be overwritten next time code is regenerated. 
  * If you need to make any customizations, please use subclass. 
  */
public abstract class _CharFkTestEntity extends org.apache.cayenne.CayenneDataObject {

    public static final String NAME_PROPERTY = "name";
    public static final String TO_CHAR_PK_PROPERTY = "toCharPK";

    public static final String PK_PK_COLUMN = "PK";

    public void setName(String name) {
        writeProperty("name", name);
    }
    public String getName() {
        return (String)readProperty("name");
    }
    
    
    public void setToCharPK(org.apache.cayenne.testdo.testmap.CharPkTestEntity toCharPK) {
        setToOneTarget("toCharPK", toCharPK, true);
    }

    public org.apache.cayenne.testdo.testmap.CharPkTestEntity getToCharPK() {
        return (org.apache.cayenne.testdo.testmap.CharPkTestEntity)readProperty("toCharPK");
    } 
    
    
}
