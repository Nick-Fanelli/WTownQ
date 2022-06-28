package panels;

import imgui.ImGui;

public class ConfigurationPanel extends Panel {

    @Override
    public void Process() {
        ImGui.begin("Configuration");



        ImGui.end();
    }

}
