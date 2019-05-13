package ec4

// Instance states enumeration
sealed trait InstanceState
case object Pending extends InstanceState
case object Running extends InstanceState
case object ShuttingDown extends InstanceState
case object Terminated  extends InstanceState
case object Stopping extends InstanceState
case object Stopped extends InstanceState

// Reservation scope enumeration
sealed trait ReservationScope
case object AvailabilityZone extends ReservationScope
case object Region extends ReservationScope

// Reservation offering class enumeration, standard/convertible
sealed trait ReservationClass
case object Standard extends ReservationClass
case object Convertible extends ReservationClass

// Reservation offering type enumeration
sealed trait ReservationOfferingType
case object HeavyUtilization extends ReservationOfferingType
case object MediumUtilization extends ReservationOfferingType
case object LightUtilization extends ReservationOfferingType
case object NoUpfront extends ReservationOfferingType
case object PartialUpfront extends ReservationOfferingType
case object AllUpfront extends ReservationOfferingType

// Class represents a cloud computing instance
case class CloudInstance(
  id: String,
  instancetype: String,
  state: InstanceState,
  tags: Seq[String],
)

// Class represents a cloud computing capacity reservation
case class CloudReservation (
  id: String,
  instanceType: String,
  instanceCount: Int,
  region: String,
  availabilityZone: String,
  scope: ReservationScope,
  reservationClass: ReservationClass,
  offeringType: ReservationOfferingType,
  usagePrice: BigDecimal,
  upfrontAmount: BigDecimal,
)