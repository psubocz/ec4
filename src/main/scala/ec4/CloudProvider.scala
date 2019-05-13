package ec4

// A trait for a cloud computing provider
trait CloudProvider {
  def getInstances(): Seq[CloudInstance]
  def getReservations(): Seq[CloudReservation]
}

// Mock provider for tests. One can pass pre-made lists of instances and capacity reservations
class MockCloudProvider(instances: Seq[CloudInstance], reservations: Seq[CloudReservation]) extends CloudProvider {
  def getInstances() = instances
  def getReservations() = reservations
}