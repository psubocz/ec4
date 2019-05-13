package ec4

import com.typesafe.config.Config
import slick.lifted.StringColumnExtensionMethods

/*
Main app settings case class. Contains separate classes for each functionality group
Create with Settings companion object's load function
 */
case class Settings(
  generalSettings: GeneralSettings,
  dbSettings: DbSettings,
  webapiSettings: WebAPISettings,
  awsSettings: AWSSettings,
)

// General app settings class
case class GeneralSettings(

)

// Database access settings
case class DbSettings(
  url: String,
  driver: String,
  user: String,
  password: String,
  connectionPool: String,
)

// Settings related to ec4's web api
case class WebAPISettings(
  port: Int,
  apiKey: String,
)

// AWS api access settings
case class AWSSettings(
  accessKey: String,
  accessKeySecret: String
)

/*
Settings class companion object.
Use it to load app's configuration
 */
object Settings {
  def load(config: Config): Settings =
    Settings(
      generalSettings = GeneralSettings(

      ),
      dbSettings = DbSettings(
        url = config.getString("db.url"),
        driver = config.getString("db.driver"),
        user = config.getString("db.user"),
        password = config.getString("db.password"),
        connectionPool = config.getString("db.connectionPool"),
      ),
      webapiSettings = WebAPISettings(
        port = config.getInt("api.port"),
        apiKey = config.getString("api.apiKey"),
      ),
      awsSettings = AWSSettings(
        accessKey = config.getString("aws.accessKey"),
        accessKeySecret = config.getString("aws.accessKeySecret"),
      )
    )
}