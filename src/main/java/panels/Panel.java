package panels;

import imgui.ImGui;
import imgui.type.ImBoolean;

public abstract class Panel {

    protected final String panelName;

    private ImBoolean isOpen = new ImBoolean(true);

    public Panel(String panelName) {
        this.panelName = panelName;
    }

    public void Process() {
        if(!isOpen.get())
            return;

        ImGui.begin(panelName, isOpen);
        OnImGuiRender();
        ImGui.end();
    }

    public abstract void OnImGuiRender();

}
