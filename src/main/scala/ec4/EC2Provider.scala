package ec4

class EC2Provider(settings: AWSSettings) extends CloudProvider {

  override def getInstances():Seq[CloudInstance] = ???
  override def getReservations():Seq[CloudReservation] = ???

}
