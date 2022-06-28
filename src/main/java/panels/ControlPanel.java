package panels;

import application.ConfiguredApplication;
import imgui.ImGui;
import imgui.flag.ImGuiCond;

public class ControlPanel extends Panel {

    public static final float WINDOW_HEIGHT = 200;

    public ControlPanel(ConfiguredApplication application) {
        super(application, "Control");
    }

    @Override
    public void OnImGuiRender() {
//        ImGui.setNextWindowPos(0.0f, 0.0f, ImGuiCond.Always);
//        ImGui.setNextWindowSize(super.parentApplication.GetOSWindowWidth(), WINDOW_HEIGHT);
//
//        ImGui.begin(panelName, isOpen, STATIC_WINDOW_FLAGS);
//
//        ImGui.end();
    }
}
