import java.net.UnknownHostException;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.map.IMap;

public class HMapEvict {
    public static void main( String[] args ) throws UnknownHostException {
        ClientConfig clientConfig = HConfig.getClientConfig();
        HazelcastInstance client = HazelcastClient.newHazelcastClient( clientConfig );

        IMap<Long, Trip> trips = client.getMap( "trips" );
        trips.evictAll();
    }

    public static void deleteTrip( String[] args ) throws UnknownHostException {
        ClientConfig clientConfig = HConfig.getClientConfig();
        HazelcastInstance client = HazelcastClient.newHazelcastClient( clientConfig );


        IMap<Long, Trip> trips = client.getMap( "trips" );
        trips.evictAll();
    }
}
