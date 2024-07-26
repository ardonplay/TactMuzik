package io.github.ardonplay.tactmuzik.metadata.api.spring.webmvc.utils;

import com.devskiller.friendly_id.FriendlyId;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/v1/utils")
public class UtilController {

  @GetMapping("/generate/{uuid}")
  public String generateFriendlyId(@PathVariable UUID uuid) {
    log.info("Generate UUID: {}", uuid);
    return FriendlyId.toFriendlyId(uuid);
  }
}
