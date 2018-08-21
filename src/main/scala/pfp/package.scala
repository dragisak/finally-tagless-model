import java.util.UUID

package object pfp {

  type ImpressionId = UUID
  type CreativeId = UUID
  type CampaignId = UUID
  type DeviceId = String

  object ImpressionId {
    def apply(): ImpressionId = UUID.randomUUID()
  }

}
