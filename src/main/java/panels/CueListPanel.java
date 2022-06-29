package panels;

import application.ConfiguredApplication;
import cue.CueData;
import cue.CueList;
import imgui.ImGui;
import imgui.flag.ImGuiCond;
import imgui.flag.ImGuiSelectableFlags;
import imgui.flag.ImGuiTableColumnFlags;
import imgui.flag.ImGuiTableFlags;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class CueListPanel extends Panel {

    public static final float WINDOW_HEIGHT = 600;

    private static final int TABLE_FLAGS = ImGuiTableFlags.SizingFixedFit | ImGuiTableFlags.RowBg | ImGuiTableFlags.Borders
            | ImGuiTableFlags.Resizable | ImGuiTableFlags.Reorderable | ImGuiTableFlags.Hideable | ImGuiTableFlags.ScrollY;

    private final ArrayList<Float> selectedCues = new ArrayList<>();

    private final CueList cueList;

    public CueListPanel(ConfiguredApplication application) {
        super(application, "Cue List");

        // TODO: Load from saved show file
        this.cueList = new CueList();
        this.cueList.AddCue(1, new CueData("Preshow Music"));
        this.cueList.AddCue(2, new CueData("First Song"));
        this.cueList.AddCue(3, new CueData("Second Song"));
        this.cueList.AddCue(100, new CueData("Postshow Music"));
    }

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
            ImGui.tableSetupScrollFreeze(0, 1);
            ImGui.tableHeadersRow();

            // Draw Each Cue in the Cue List
            cueList.ForEachCue((cueNumber, cueData) -> {

                ImGui.pushID("CueNumber: " + cueNumber);

                ImGui.tableNextRow();

                // Draw Cue Number
                ImGui.tableSetColumnIndex(0);

                if(ImGui.selectable(DECIMAL_FORMAT.format(cueNumber), selectedCues.contains(cueNumber), ImGuiSelectableFlags.SpanAllColumns)) {

                    // TODO: Mac support for super + shift func.
                    if(!ImGui.getIO().getKeyCtrl())
                        selectedCues.clear();

                    selectedCues.add(cueNumber);
                }

                RenderCue(cueNumber, cueData);

                ImGui.popID();
            });

            ImGui.endTable();
        }

//        ImGui.showDemoWindow();

        ImGui.end();
    }

    private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("0.###");

    private void RenderCue(float cueNumber, CueData cueData) {
        ImGui.tableSetColumnIndex(1);
        ImGui.text(cueData.cueLabel);

        ImGui.tableSetColumnIndex(2);
        ImGui.text("Test");

        ImGui.tableSetColumnIndex(3);
        ImGui.text("test");
    }
}
