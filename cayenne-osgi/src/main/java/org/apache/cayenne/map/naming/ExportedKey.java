/*****************************************************************
 *   Licensed to the Apache Software Foundation (ASF) under one
 *  or more contributor license agreements.  See the NOTICE file
 *  distributed with this work for additional information
 *  regarding copyright ownership.  The ASF licenses this file
 *  to you under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 ****************************************************************/
package org.apache.cayenne.map.naming;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * ExportedKey is an representation of relationship between two tables 
 * in database. It can be used for creating names for relationships
 * 
 */
public class ExportedKey {
    /**
     * Name of source table
     */
    String pkTable;
    
    /**
     * Name of source column
     */
    String pkColumn;
    
    /**
     * Name of destination table
     */
    String fkTable;
    
    /**
     * Name of destination column
     */
    String fkColumn;
    
    /**
     * Name of foreign key (might be null)
     */
    String fkName;
    
    /**
     * Name of primary key (might be null)
     */
    String pkName;
    
    public ExportedKey(String pkTable, String pkColumn, String pkName,
            String fkTable, String fkColumn, String fkName) {
       this.pkTable  = pkTable;
       this.pkColumn = pkColumn;
       this.pkName   = pkName;
       this.fkTable  = fkTable;
       this.fkColumn = fkColumn;
       this.fkName   = fkName;
    }
    
    /**
     * Extracts data from a resultset pointing to a exported key to
     * ExportedKey class instance
     * 
     * @param rs ResultSet pointing to a exported key, fetched using
     * DataBaseMetaData.getExportedKeys(...) 
     */
    public static ExportedKey extractData(ResultSet rs) throws SQLException {
        ExportedKey key = new ExportedKey(
                rs.getString("PKTABLE_NAME"),
                rs.getString("PKCOLUMN_NAME"),
                rs.getString("PK_NAME"),
                rs.getString("FKTABLE_NAME"),
                rs.getString("FKCOLUMN_NAME"),
                rs.getString("FK_NAME")
        );
        
        return key;
    }
    
    /**
     * @return source table name
     */
    public String getPKTableName() {
        return pkTable;
    }
    
    /**
     * @return destination table name
     */
    public String getFKTableName() {
        return fkTable;
    }
    
    /**
     * @return source column name
     */
    public String getPKColumnName() {
        return pkColumn;
    }
    
    /**
     * @return destination column name
     */
    public String getFKColumnName() {
        return fkColumn;
    }
    
    /**
     * @return PK name
     */
    public String getPKName() {
        return pkName;
    }
    
    /**
     * @return FK name
     */
    public String getFKName() {
        return fkName;
    }
}
