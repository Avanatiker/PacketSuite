import com.lambda.client.command.ClientCommand
import net.minecraft.network.play.client.CPacketAnimation
import net.minecraft.util.EnumHand

object PacketSuiteCommand : ClientCommand(
    name = "packet",
    description = "Analyzing anti cheats made easy"
) {

    init {
        literal("CPacketAnimation") {
            mc.connection?.sendPacket(CPacketAnimation(EnumHand.MAIN_HAND))
        }
    }
}