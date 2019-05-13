import com.typesafe.config.{ConfigException, ConfigFactory}
import ec4.Settings
import org.scalatest._

class SettingsSpec extends FlatSpec with Matchers {

  "Settings" should "be properly loaded from config object" in {
    val configuration = """
      db.url = "testurl://"
      db.driver = "testdriver"
      db.connectionPool = "disabled"
      db.user = "user"
      db.password = "password"
      api.port = 8080
      api.apiKey = "secretkey"
      aws.accessKey = "awsaccesskey"
      aws.accessKeySecret = "awsaccesskeysecret"
    """

    val config = ConfigFactory.parseString(configuration).resolve()
    val settings = Settings.load(config)

    settings.dbSettings.url should be ("testurl://")
    settings.dbSettings.driver should be ("testdriver")
    settings.dbSettings.connectionPool should be ("disabled")
    settings.dbSettings.user should be ("user")
    settings.dbSettings.password should be ("password")
    settings.webapiSettings.port should be (8080)
    settings.webapiSettings.apiKey should be ("secretkey")
    settings.awsSettings.accessKey should be ("awsaccesskey")
    settings.awsSettings.accessKeySecret should be ("awsaccesskeysecret")
  }

  "Settings" should "fail on missing config values" in {
    val configuration = "bad.config = 123"
    val config = ConfigFactory.parseString(configuration).resolve()

    a [ConfigException.Missing] should be thrownBy {
      Settings.load(config)
    }
  }
}
