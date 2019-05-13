import ec4._
import org.scalatest._

class CloudProviderSpec extends FlatSpec with Matchers {

  "Cloud provider" should "return a list of instances" in {
    val instances = List(
      CloudInstance("inst1", "r4.large", Running, List("tag1", "tag2")),
      CloudInstance("inst2", "c4.large", Running, List("tag1"))
    )
    val provider = new MockCloudProvider(instances, List[CloudReservation]())

    provider.getInstances() should be (instances)
  }

  "Cloud provider" should "return a list of reservations" in {
    val reservations = List(
      CloudReservation("res1", "r4.large", 5, "us-east-1", "us-east-1a", Region, Standard, PartialUpfront, 2.1, 100),
      CloudReservation("res2", "c4.large", 1, "us-east-1", "us-east-1a", Region, Standard, PartialUpfront, 1.5, 20)
    )
    val provider = new MockCloudProvider(List[CloudInstance](), reservations)

    provider.getReservations() should be (reservations)
  }

}
