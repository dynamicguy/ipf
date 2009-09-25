/*
 * Copyright 2008 the original author or authors.
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
package org.openehealth.ipf.platform.camel.flow.extend;

import org.openehealth.ipf.platform.camel.flow.builder.RouteBuilder;
import org.openehealth.ipf.platform.camel.flow.model.DedupeDefinition;
import org.openehealth.ipf.platform.camel.flow.model.FlowBeginProcessorDefinition;
import org.openehealth.ipf.platform.camel.flow.model.FlowEndProcessorDefinition;
import org.openehealth.ipf.platform.camel.flow.model.FlowErrorProcessorDefinition;
import org.openehealth.ipf.platform.camel.flow.model.SplitterDefinition;
import org.openehealth.ipf.platform.camel.flow.model.IpfDefinition;
import org.openehealth.ipf.platform.camel.core.closures.DelegatingExpression;
import org.apache.camel.Expression;

import org.apache.camel.model.ProcessorDefinition;
import org.apache.camel.spi.DataFormat;

/**
 * Flow DSL extensions for usage in a {@link RouteBuilder} using the {@code use} keyword.
 * @author Jens Riemschneider
 */
public class FlowExtension {
    /**
     * Starts recording a message flow
     * @ipfdoc Flow management#init-flow-extension
     * @dsl platform-camel-flow
     */
    public static FlowBeginProcessorDefinition initFlow(ProcessorDefinition self) {
        FlowBeginProcessorDefinition answer = new FlowBeginProcessorDefinition();
        self.addOutput(answer);
        return answer;
    }
    
    /**
     * Starts recording a message flow with a specific identifier
     * @param identifier
     * 			the identifier to use
     * @ipfdoc Flow management#init-flow-extension
     * @dsl platform-camel-flow
     */
    public static FlowBeginProcessorDefinition initFlow(ProcessorDefinition self, String identifier) {
        FlowBeginProcessorDefinition answer = new FlowBeginProcessorDefinition(identifier);
        self.addOutput(answer);
        return answer;
    }
    
    /**
     * Logs the successful delivery of a message
     * @ipfdoc Flow management#ack-flow-extension
     * @dsl platform-camel-flow
     */
    public static FlowEndProcessorDefinition ackFlow(ProcessorDefinition self) {
        FlowEndProcessorDefinition answer = new FlowEndProcessorDefinition();
        self.addOutput(answer);
        return answer;
    }

    /**
     * Logs the erroneous processing of a message
     * @ipfdoc Flow management#nak-flow-extension
     * @dsl platform-camel-flow
     */
    public static FlowErrorProcessorDefinition nakFlow(ProcessorDefinition self) {
        FlowErrorProcessorDefinition answer = new FlowErrorProcessorDefinition();
        self.addOutput(answer);
        return answer;
    }
    
    /**
     * Filters messages during flow replay operations to avoid delivery of duplicates
     * @ipfdoc Flow management#dedupe-extension
     * @dsl platform-camel-flow
     */
    public static DedupeDefinition dedupeFlow(ProcessorDefinition self) {
        DedupeDefinition answer = new DedupeDefinition();
        self.addOutput(answer);
        return answer;
    }
    
    public static IpfDefinition ipf(ProcessorDefinition self) {
        return new IpfDefinition(self)
    }
}