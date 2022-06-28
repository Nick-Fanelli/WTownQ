package application;

import imgui.*;
import imgui.app.Application;
import imgui.app.Configuration;
import imgui.flag.ImGuiCol;
import utils.IOUtils;

public abstract class ConfiguredApplication extends Application {

    public static final ImVec4 ACCENT_COLOR = new ImVec4(0.396078f, 0.803921f, 0.992156f, 1.0f);


    @Override
    protected void initImGui(Configuration config) {
        super.initImGui(config);

        ImGuiIO io = ImGui.getIO();

        ImFontConfig fontConfig = new ImFontConfig();
        fontConfig.setOversampleH(3);
        fontConfig.setOversampleV(3);

        byte[] ttfBytes = IOUtils.LoadApplicationResourceAsBytes("fonts/segoe-ui.ttf");

        assert ttfBytes != null;
        io.setFontDefault(io.getFonts().addFontFromMemoryTTF(ttfBytes, 18.0f));

        SetImGuiTheme();
    }

    // FIXME: Causing crash when disposing of ImGui (related to setting the default font)
    @Override
    protected void disposeImGui() {
//        super.disposeImGui();
    }

    private void SetImGuiTheme() {
        ImGuiStyle style = ImGui.getStyle();

        style.setColor(ImGuiCol.DockingPreview, ACCENT_COLOR.x, ACCENT_COLOR.y, ACCENT_COLOR.z, ACCENT_COLOR.w);
        style.setColor(ImGuiCol.DragDropTarget, ACCENT_COLOR.x, ACCENT_COLOR.y, ACCENT_COLOR.z, ACCENT_COLOR.w);
        style.setColor(ImGuiCol.NavHighlight, ACCENT_COLOR.x, ACCENT_COLOR.y, ACCENT_COLOR.z, ACCENT_COLOR.w);
        style.setColor(ImGuiCol.ResizeGripActive, ACCENT_COLOR.x, ACCENT_COLOR.y, ACCENT_COLOR.z, ACCENT_COLOR.w);

        style.setColor(ImGuiCol.WindowBg, 0.1f, 0.105f, 0.11f, 1.0f);

        // Headers
        style.setColor(ImGuiCol.Header, 0.2f, 0.205f, 0.21f, 1.0f);
        style.setColor(ImGuiCol.HeaderHovered, 0.3f, 0.305f, 0.31f, 1.0f);
        style.setColor(ImGuiCol.HeaderActive, 0.15f, 0.1505f, 0.151f, 1.0f);

        // Buttons
        style.setColor(ImGuiCol.Button, 0.2f, 0.205f, 0.21f, 1.0f);
        style.setColor(ImGuiCol.ButtonHovered, 0.3f, 0.305f, 0.31f, 1.0f);
        style.setColor(ImGuiCol.ButtonActive, 0.15f, 0.1505f, 0.151f, 1.0f);

        // Frame BG
        style.setColor(ImGuiCol.FrameBg, 0.2f, 0.205f, 0.21f, 1.0f);
        style.setColor(ImGuiCol.FrameBgHovered, 0.3f, 0.305f, 0.31f, 1.0f);
        style.setColor(ImGuiCol.FrameBgActive, 0.15f, 0.1505f, 0.151f, 1.0f);

        // Tabs
        style.setColor(ImGuiCol.Tab, 0.15f, 0.1505f, 0.151f, 1.0f);
        style.setColor(ImGuiCol.TabHovered, 0.38f, 0.3805f, 0.381f, 1.0f);
        style.setColor(ImGuiCol.TabActive, 0.28f, 0.2805f, 0.281f, 1.0f);
        style.setColor(ImGuiCol.TabUnfocused, 0.15f, 0.1505f, 0.151f, 1.0f);
        style.setColor(ImGuiCol.TabUnfocusedActive, 0.2f, 0.205f, 0.21f, 1.0f);

        // Title
        style.setColor(ImGuiCol.TitleBg, 0.15f, 0.1505f, 0.151f, 1.0f);
        style.setColor(ImGuiCol.TitleBgActive, 0.15f, 0.1505f, 0.151f, 1.0f);
        style.setColor(ImGuiCol.TitleBgCollapsed, 0.15f, 0.1505f, 0.151f, 1.0f);

    }
}
