package bitcamp.myapp;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Configuration
@PropertySource("classpath:/naver.properties")
@ConfigurationProperties(prefix="ncp")
@Getter
@Setter
@ToString
public class NaverConfig {

  //  Logger log = LogManager.getLogger(getClass());
  //  public NaverConfig() {
  //    log.debug("NaverConfig 객체 생성");
  //  }

  private String endPoint;
  private String regionName;
  private String accessKey;
  private String secretKey;
}
