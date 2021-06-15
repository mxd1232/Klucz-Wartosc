import java.io.Serializable;
import java.net.UnknownHostException;
import java.util.Map.Entry;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.map.IMap;
import com.hazelcast.map.EntryProcessor;

public class HExecuteOnEntries {

    public static void main( String[] args ) throws UnknownHostException {
        ClientConfig clientConfig = HConfig.getClientConfig();
		final HazelcastInstance client = HazelcastClient.newHazelcastClient(clientConfig);

		IMap<Long, Trip> students = client.getMap("students");
		students.executeOnEntries(new HEntryProcessor());

		for (Entry<Long, Trip> e : students.entrySet()) {
			System.out.println(e.getKey() + " => " + e.getValue());
		}
	}
}

class HEntryProcessor implements EntryProcessor<Long, Trip, String>, Serializable {
	private static final long serialVersionUID = 1L;

	@Override
	public String process(Entry<Long, Trip> e) {
		Trip trip = e.getValue();
		String place = trip.getPlace();
		if (place.equals(place.toLowerCase())) {
			place = place.toUpperCase();
			trip.setPlace(place);
		} else{
			place = place.toLowerCase();
			trip.setPlace(place);
		}
		
		System.out.println("Processing = " + trip);
		e.setValue(trip);
		
		return place;
	}
}
