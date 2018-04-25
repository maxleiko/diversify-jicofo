/*
 * Jicofo, the Jitsi Conference Focus.
 *
 * Copyright @ 2015 Atlassian Pty Ltd
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
package org.jitsi.impl.protocol.xmpp;

import net.java.sip.communicator.service.protocol.jabber.*;

import java.util.*;

/**
 * Account ID used by Jitsi Meet focus XMPP accounts.
 *
 * FIXME: move code related to account properties initialization here,
 * protocol provider or factory. Eventually remove this class.
 *
 * @author Pawel Domas
 */
public class XmppAccountID
    extends JabberAccountID
{
    public XmppAccountID(String id, Map<String, String> accountProperties)
    {
        super(id, accountProperties);
    }
}
