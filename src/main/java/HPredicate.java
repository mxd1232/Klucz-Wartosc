import java.net.UnknownHostException;
import java.util.Collection;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.map.IMap;
import com.hazelcast.query.Predicate;
import com.hazelcast.query.Predicates;

public class HPredicate {

    public static void main( String[] args ) throws UnknownHostException {
        ClientConfig clientConfig = HConfig.getClientConfig();
		final HazelcastInstance client = HazelcastClient.newHazelcastClient(clientConfig);
		IMap<Long, Trip> students = client.getMap("trips");

		Predicate<?,?> placePredicate = Predicates.equal( "place", "GRECJA" );
		Predicate<?,?> datePredicate = Predicates.lessThan("date", 2021);
		Predicate<?,?> costPredicate = Predicates.lessThan("cost", 2021);


		Collection<Trip> trip = students.values(Predicates.and(placePredicate, datePredicate,costPredicate));
		for (Trip t : trip) {
			System.out.println(t);
		}
	}
}
