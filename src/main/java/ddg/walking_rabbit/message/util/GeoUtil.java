package ddg.walking_rabbit.message.util;

import ddg.walking_rabbit.global.domain.entity.ParkEntity;
import org.springframework.stereotype.Component;

@Component
public class GeoUtil {
    private static final double EARTH_RADIUS = 6371000.0;

    public static double haversineMeters(double lat1, double lon1, double lat2, double lon2) {
        double phi1 = Math.toRadians(lat1);
        double phi2 = Math.toRadians(lat2);
        double dPhi = Math.toRadians(lat2 - lat1);
        double dLam = Math.toRadians(lon2 - lon1);
        double a = Math.sin(dPhi / 2) * Math.sin(dPhi / 2) + Math.cos(phi1) * Math.cos(phi2) * Math.sin(dLam / 2) * Math.sin(dLam / 2);
        double c = 2.0 * Math.asin(Math.min(1.0, Math.sqrt(a)));
        return EARTH_RADIUS * c;
    }


    public boolean confirmMissionComplete(Double lat, Double lon, ParkEntity park) {

        Double area = park.getArea();
        double radius = Math.sqrt(area / Math.PI);
        double epsilon = 20.0;

        double distance = GeoUtil.haversineMeters(lat, lon, park.getLat(), park.getLon());
        return distance <= (radius + epsilon);
    }
}
