package uk.co.and.dailymail.hornetq;

import com.google.common.collect.Maps;
import java.util.Map;
import javax.jms.ConnectionFactory;
import org.hornetq.api.core.TransportConfiguration;
import org.hornetq.jms.client.HornetQXAConnectionFactory;

/**
 * Hello world!
 *
 */
public class HornetQConnectionFactory 
{    
    public static ConnectionFactory makeConnectionFactory (String host, Long port, Long timeout) {
        Map<String,Object> params = Maps.newHashMap();
        params.put("host", host);
        params.put("port", port);
            
        TransportConfiguration transportConf  =  new TransportConfiguration(
                        "org.hornetq.core.remoting.impl.netty.NettyConnectorFactory",
                        params);
        TransportConfiguration [] confs = new TransportConfiguration[1];
        confs[0] = transportConf;
                        
        HornetQXAConnectionFactory connFactory = new HornetQXAConnectionFactory(false, confs);
        connFactory.setCallTimeout(timeout);
        return connFactory;
    }
}
