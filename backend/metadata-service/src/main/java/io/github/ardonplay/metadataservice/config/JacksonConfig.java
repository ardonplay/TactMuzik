package io.github.ardonplay.metadataservice.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import io.github.ardonplay.metadataservice.util.friendlyid.FriendlyIdDeserializer;
import io.github.ardonplay.metadataservice.util.friendlyid.FriendlyIdSerializer;
import java.text.SimpleDateFormat;
import java.util.UUID;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JacksonConfig {

    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        SimpleModule module = new SimpleModule();
        SimpleDateFormat df = new SimpleDateFormat();
        module.addSerializer(UUID.class, new FriendlyIdSerializer());
        module.addDeserializer(UUID.class, new FriendlyIdDeserializer());
        objectMapper.registerModule(module);
        objectMapper.setDateFormat(df);
        return objectMapper;
    }
}