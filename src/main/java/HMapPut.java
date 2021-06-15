import java.net.UnknownHostException;
import java.util.Map;
import java.util.Random;

import com.hazelcast.config.Config;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;

public class HMapPut {

	final private static Random r = new Random(System.currentTimeMillis());

	public static void put(String place, int date, double money) throws UnknownHostException {

		Config config = HConfig.getConfig();
		HazelcastInstance instance = Hazelcast.newHazelcastInstance(config);

		Map<Long, Trip> trips = instance.getMap("trips");
		Long key1 = (long) Math.abs(r.nextInt());
		Trip trip1 = new Trip(place, date,money);
		System.out.println("PUT " + key1 + " => " + trip1);
		trips.put(key1, trip1);

	}

	public static void main(String[] args) throws UnknownHostException {
		Config config = HConfig.getConfig();
		HazelcastInstance instance = Hazelcast.newHazelcastInstance(config);

		Map<Long, Trip> trips = instance.getMap("trips");
		Long key1 = (long) Math.abs(r.nextInt());
		Trip trip1 = new Trip("Grecja", 2021,3000);
		System.out.println("PUT " + key1 + " => " + trip1);
		trips.put(key1, trip1);


		Long key2 = (long) Math.abs(r.nextInt());
		Trip trip2 = new Trip("Japonia", 2022,10000);
		trips.put(key2, trip2);
		System.out.println("PUT " + key2 + " => " + trip2);
	}


}
