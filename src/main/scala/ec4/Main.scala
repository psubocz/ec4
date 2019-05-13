package ec4

import com.typesafe.config.ConfigFactory

object Main extends App {
  // Load app config
  val config = ConfigFactory.load()
  val settings = Settings.load(config)

  // Instantiate cloud provider and analytics class
  val provider = new EC2Provider(settings.awsSettings)
  val analytics = new Analytics(settings.generalSettings, provider)
}
