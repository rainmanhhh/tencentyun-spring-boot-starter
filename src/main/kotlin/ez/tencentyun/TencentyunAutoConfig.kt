package ez.tencentyun

import com.tencentyun.TLSSigAPIv2
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import kotlin.properties.Delegates

@ConfigurationProperties("tencentyun")
@Configuration
class TencentyunAutoConfig {
  var sdkAppId by Delegates.notNull<Long>()
  lateinit var secretKey: String

  @Bean
  fun tencentSigApi(): TLSSigAPIv2 = TLSSigAPIv2(sdkAppId, secretKey)
}
