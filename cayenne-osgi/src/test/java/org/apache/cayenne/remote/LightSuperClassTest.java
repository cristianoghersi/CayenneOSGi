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
package org.apache.cayenne.remote;

import org.apache.cayenne.ObjectContext;
import org.apache.cayenne.di.Inject;
import org.apache.cayenne.query.RefreshQuery;
import org.apache.cayenne.query.SelectQuery;
import org.apache.cayenne.test.jdbc.DBHelper;
import org.apache.cayenne.testdo.persistent.Continent;
import org.apache.cayenne.testdo.persistent.Country;
import org.apache.cayenne.unit.di.client.ClientCase;
import org.apache.cayenne.unit.di.server.UseServerRuntime;

/**
 * Test for entites that are implemented in same class on client and server
 */
@UseServerRuntime(ClientCase.MULTI_TIER_PROJECT)
public class LightSuperClassTest extends RemoteCayenneCase {

    @Inject
    private DBHelper dbHelper;

    private boolean server;

    @Override
    public void setUpAfterInjection() throws Exception {
        super.setUpAfterInjection();

        dbHelper.deleteAll("CONTINENT");
        dbHelper.deleteAll("COUNTRY");
    }

    @Override
    public void runBare() throws Throwable {
        server = true;
        super.runBare();
        server = false;

        // testing ROP with all serialization policies
        runBareSimple();
    }

    private ObjectContext createContext() {
        if (server) {
            return serverContext;
        }
        else {
            return createROPContext();
        }
    }

    public void testServer() throws Exception {
        ObjectContext context = createContext();
        Continent continent = context.newObject(Continent.class);
        continent.setName("Europe");

        Country country = new Country();
        context.registerNewObject(country);

        // TODO: setting property before object creation does not work on ROP (CAY-1320)
        country.setName("Russia");

        country.setContinent(continent);
        assertEquals(continent.getCountries().size(), 1);

        context.commitChanges();

        context.deleteObjects(country);
        assertEquals(continent.getCountries().size(), 0);
        continent.setName("Australia");

        context.commitChanges();
        context.performQuery(new RefreshQuery());

        assertEquals(context.performQuery(new SelectQuery(Country.class)).size(), 0);
        assertEquals(context.performQuery(new SelectQuery(Continent.class)).size(), 1);
    }
}
