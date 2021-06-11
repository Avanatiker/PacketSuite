import com.lambda.client.plugin.api.Plugin

internal object PacketSuite : Plugin() {

    override fun onLoad() {
        commands.add(PacketSuiteCommand)
    }

    override fun onUnload() {
        //
    }
}