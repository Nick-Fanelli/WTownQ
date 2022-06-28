package panels;

import application.ConfiguredApplication;
import imgui.ImGui;
import imgui.flag.ImGuiCond;
import imgui.flag.ImGuiTableColumnFlags;
import imgui.flag.ImGuiTableFlags;

import java.util.HashMap;
import java.util.SortedMap;

public class CueListPanel extends Panel {

    public static final float WINDOW_HEIGHT = 600;

    private static final int TABLE_FLAGS = ImGuiTableFlags.SizingFixedFit | ImGuiTableFlags.RowBg | ImGuiTableFlags.Borders
            | ImGuiTableFlags.Resizable | ImGuiTableFlags.Reorderable | ImGuiTableFlags.Hideable;

    public CueListPanel(ConfiguredApplication application) { super(application, "Cue List"); }

    @Override
    public void OnImGuiRender() {
        ImGui.setNextWindowPos(0.0f, 0.0f, ImGuiCond.Always);
        ImGui.setNextWindowSize(super.parentApplication.GetOSWindowWidth(), WINDOW_HEIGHT, ImGuiCond.Always);

        ImGui.begin("Cue List", isOpen, STATIC_WINDOW_FLAGS);

        if(ImGui.beginTable("Cue List", 4, TABLE_FLAGS)) {

            ImGui.tableSetupColumn("Cue", ImGuiTableColumnFlags.WidthFixed);
            ImGui.tableSetupColumn("Label", ImGuiTableColumnFlags.WidthFixed);
            ImGui.tableSetupColumn("Pre-Wait", ImGuiTableColumnFlags.WidthFixed);
            ImGui.tableSetupColumn("Duration", ImGuiTableColumnFlags.WidthStretch);
            ImGui.tableHeadersRow();

            for(int row = 0; row < 5; row++) {
                ImGui.tableNextRow();

                for(int column = 0; column < 4; column++) {
                    ImGui.tableSetColumnIndex(column);
                    ImGui.text("Something");
                }
            }

            ImGui.endTable();
        }

        ImGui.end();

//        ImGui.showDemoWindow();
    }
}
