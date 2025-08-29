package ddg.walking_rabbit.mission.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import ddg.walking_rabbit.global.domain.entity.ParkEntity;
import ddg.walking_rabbit.global.domain.repository.ParkRepository;
import ddg.walking_rabbit.mission.dto.ParkDto;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.List;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final ParkRepository parkRepository;
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        if (parkRepository.count() > 0) {
            return;
        }
        InputStream in = new ClassPathResource("parks.json").getInputStream();
        List<ParkDto> parks = objectMapper.readValue(
                in,
                new TypeReference<List<ParkDto>>() {}
        );

        for (ParkDto p : parks) {
            ParkEntity park = ParkEntity.builder()
                    .mngNo(p.getMngNo())
                    .parkNm(p.getParkNm())
                    .lat(p.getLat())
                    .lon(p.getLon())
                    .area(p.getArea())
                    .build();
            parkRepository.save(park);
        }
    }
}
