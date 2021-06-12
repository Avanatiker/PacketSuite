import com.lambda.client.plugin.api.Plugin

internal object PacketSuite : Plugin() {

    override fun onLoad() {
        modules.add(PacketSuiteModule)
        commands.add(PacketSuiteCommand)
    }

    override fun onUnload() {
        //
    }
}