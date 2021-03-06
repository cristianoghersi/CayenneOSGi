package org.apache.cayenne.testdo.testmap.auto;

/** Class _MeaningfulPKTest1 was generated by Cayenne.
  * It is probably a good idea to avoid changing this class manually, 
  * since it may be overwritten next time code is regenerated. 
  * If you need to make any customizations, please use subclass. 
  */
public abstract class _MeaningfulPKTest1 extends org.apache.cayenne.CayenneDataObject {

    public static final String DESCR_PROPERTY = "descr";
    public static final String PK_ATTRIBUTE_PROPERTY = "pkAttribute";
    public static final String MEANINGFUL_PKDEP_ARRAY_PROPERTY = "meaningfulPKDepArray";

    public static final String PK_ATTRIBUTE_PK_COLUMN = "PK_ATTRIBUTE";

    public void setDescr(String descr) {
        writeProperty("descr", descr);
    }
    public String getDescr() {
        return (String)readProperty("descr");
    }
    
    
    public void setPkAttribute(Integer pkAttribute) {
        writeProperty("pkAttribute", pkAttribute);
    }
    public Integer getPkAttribute() {
        return (Integer)readProperty("pkAttribute");
    }
    
    
    public void addToMeaningfulPKDepArray(org.apache.cayenne.testdo.testmap.MeaningfulPKDep obj) {
        addToManyTarget("meaningfulPKDepArray", obj, true);
    }
    public void removeFromMeaningfulPKDepArray(org.apache.cayenne.testdo.testmap.MeaningfulPKDep obj) {
        removeToManyTarget("meaningfulPKDepArray", obj, true);
    }
    public java.util.List getMeaningfulPKDepArray() {
        return (java.util.List)readProperty("meaningfulPKDepArray");
    }
    
    
}
