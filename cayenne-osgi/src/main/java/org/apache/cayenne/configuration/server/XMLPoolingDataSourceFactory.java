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
package org.apache.cayenne.configuration.server;

import javax.sql.DataSource;

import org.apache.cayenne.ConfigurationException;
import org.apache.cayenne.configuration.DataNodeDescriptor;
import org.apache.cayenne.conn.DataSourceInfo;
import org.apache.cayenne.conn.PoolManager;
import org.apache.cayenne.di.Inject;
import org.apache.cayenne.log.JdbcEventLogger;
import org.apache.cayenne.resource.ResourceLocator;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * A {@link DataSourceFactory} that loads JDBC connection information from an XML resource
 * associated with the DataNodeDescriptor, returning a DataSource with simple connection
 * pooling.
 * 
 * @since 3.1
 */
public class XMLPoolingDataSourceFactory implements DataSourceFactory {

    private static final Log logger = LogFactory
            .getLog(XMLPoolingDataSourceFactory.class);

    @Inject
    protected ResourceLocator resourceLocator;
    
    @Inject
    protected JdbcEventLogger jdbcEventLogger;

    public DataSource getDataSource(DataNodeDescriptor nodeDescriptor) throws Exception {

        DataSourceInfo dataSourceDescriptor = nodeDescriptor.getDataSourceDescriptor();
       

        if (dataSourceDescriptor == null) {
            String message = "Null dataSourceDescriptor for nodeDescriptor '"
                    + nodeDescriptor.getName()
                    + "'";
            logger.info(message);
            throw new ConfigurationException(message);
        }
        
        try {
            return new PoolManager(
                    dataSourceDescriptor.getJdbcDriver(),
                    dataSourceDescriptor.getDataSourceUrl(),
                    dataSourceDescriptor.getMinConnections(),
                    dataSourceDescriptor.getMaxConnections(),
                    dataSourceDescriptor.getUserName(),
                    dataSourceDescriptor.getPassword(),
                    jdbcEventLogger);
        }
        catch (Exception e) {
            jdbcEventLogger.logConnectFailure(e);
            throw e;
        }
    }
}
