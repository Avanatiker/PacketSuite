import com.lambda.client.manager.managers.PlayerPacketManager.sendPlayerPacket
import com.lambda.client.module.Category
import com.lambda.client.plugin.api.PluginModule
import com.lambda.client.util.threads.safeListener
import net.minecraftforge.fml.common.gameevent.TickEvent

internal object PacketSuiteModule : PluginModule(
    name = "PacketSuite",
    description = "Analyzing anti cheats made easy",
    category = Category.MISC,
    pluginMain = PacketSuite
) {
    private val cancelAll by setting("Cancel all", true, description = "Cancels any CPacketPlayer packets")
    private val cancelMove by setting("Cancel move", false, description = "Cancels move CPacketPlayer packets")
    private val cancelRotate by setting("Cancel rotate", false, description = "Cancels rotate CPacketPlayer packets")

    init {
        safeListener<TickEvent.ClientTickEvent> { event ->
            if (event.phase != TickEvent.Phase.START) return@safeListener

            sendPlayerPacket {
                if (cancelAll) cancelAll()
                if (cancelMove) cancelMove()
                if (cancelRotate) cancelRotate()
            }
        }
    }
}