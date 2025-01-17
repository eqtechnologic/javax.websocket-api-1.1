/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright (c) 2012-2013 Oracle and/or its affiliates. All rights reserved.
 *
 * The contents of this file are subject to the terms of either the GNU
 * General Public License Version 2 only ("GPL") or the Common Development
 * and Distribution License("CDDL") (collectively, the "License").  You
 * may not use this file except in compliance with the License.  You can
 * obtain a copy of the License at
 * http://glassfish.java.net/public/CDDL+GPL_1_1.html
 * or packager/legal/LICENSE.txt.  See the License for the specific
 * language governing permissions and limitations under the License.
 *
 * When distributing the software, include this License Header Notice in each
 * file and include the License file at packager/legal/LICENSE.txt.
 *
 * GPL Classpath Exception:
 * Oracle designates this particular file as subject to the "Classpath"
 * exception as provided by Oracle in the GPL Version 2 section of the License
 * file that accompanied this code.
 *
 * Modifications:
 * If applicable, add the following below the License Header, with the fields
 * enclosed by brackets [] replaced by your own identifying information:
 * "Portions Copyright [year] [name of copyright owner]"
 *
 * Contributor(s):
 * If you wish your version of this file to be governed by only the CDDL or
 * only the GPL Version 2, indicate your decision by adding "[Contributor]
 * elects to include this software in this distribution under the [CDDL or GPL
 * Version 2] license."  If you don't indicate a single choice of license, a
 * recipient has the option to distribute your version of this file under
 * either the CDDL, the GPL Version 2 or to extend the choice of license to
 * its licensees as provided above.  However, if you add GPL Version 2 code
 * and therefore, elected the GPL Version 2 license, then the option applies
 * only if the new code is made subject to such option by the copyright
 * holder.
 */
package jakarta.websocket;

import java.util.List;
import java.util.Map;

/**
 * The endpoint configuration contains all the information needed during the handshake process
 * for this end point. All endpoints specify, for example, a URI. In the case of a server endpoint,
 * the URI signifies the URI to which the endpoint will be mapped. In the case of a client application
 * the URI signifies the URI of the server to which the client endpoint will attempt to connect.
 *
 * @author dannycoward
 */
public interface EndpointConfig {

    /**
     * Return the Encoder implementation classes configured. These
     * will be instantiated by the container to encode custom objects passed into
     * the send() methods on remote endpoints.
     *
     * @return the encoder implementation classes, an empty list if none.
     */
    List<Class<? extends Encoder>> getEncoders();

    /**
     * Return the Decoder implementation classes configured. These
     * will be instantiated by the container to decode incoming messages
     * into the expected custom objects on {@link MessageHandler.Whole#onMessage(Object)}
     * callbacks.
     *
     * @return the decoder implementation classes, the empty list if none.
     */
    List<Class<? extends Decoder>> getDecoders();
    
    /**
     * This method returns a modifiable Map that the developer may use to store application
     * specific information relating to the endpoint that uses this
     * configuration instance. Web socket applications running on distributed 
     * implementations of the web container should make any application 
     * specific objects stored here java.io.Serializable, or the object may 
     * not be recreated after a failover.
     *
     * @return a modifiable Map of application data.
     */ 
     Map<String, Object> getUserProperties();
}
