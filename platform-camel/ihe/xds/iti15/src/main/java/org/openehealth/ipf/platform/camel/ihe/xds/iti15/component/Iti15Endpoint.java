/*
 * Copyright 2009 the original author or authors.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *     
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.openehealth.ipf.platform.camel.ihe.xds.iti15.component;

import org.apache.camel.Consumer;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.Producer;
import org.openehealth.ipf.platform.camel.ihe.xds.commons.DefaultItiEndpoint;
import org.openehealth.ipf.platform.camel.ihe.xds.commons.ItiServiceInfo;
import org.openehealth.ipf.platform.camel.ihe.xds.iti15.service.Iti15PortType;

import javax.xml.namespace.QName;
import java.net.URISyntaxException;

/**
 * The Camel endpoint for the ITI-15 transaction.
 */
public class Iti15Endpoint extends DefaultItiEndpoint {
    private static final ItiServiceInfo<Iti15PortType> SERVICE_INFO = new ItiServiceInfo<Iti15PortType>(
            new QName("urn:ihe:iti:xds:2007", "DocumentRepository_Service", "ihe"),
            Iti15PortType.class,
            new QName("urn:ihe:iti:xds:2007", "DocumentRepository_Binding_Soap11", "ihe"),
            false,
            "wsdl/iti15.wsdl");

    /**
     * Constructs the endpoint.
     * @param endpointUri
     *          the endpoint URI.
     * @param address
     *          the endpoint address from the URI.
     * @param iti15Component
     *          the component creating this endpoint.
     * @throws URISyntaxException
     *          if the endpoint URI was not a valid URI.
     */
    public Iti15Endpoint(String endpointUri, String address, Iti15Component iti15Component) throws URISyntaxException {
        super(endpointUri, address, iti15Component);
    }

    public Producer<Exchange> createProducer() throws Exception {
        return new Iti15Producer(this, SERVICE_INFO);
    }

    public Consumer<Exchange> createConsumer(Processor processor) throws Exception {
        return new Iti15Consumer(this, processor, SERVICE_INFO);
    }
}