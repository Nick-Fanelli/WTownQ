package panels;

import application.ConfiguredApplication;
import imgui.ImGui;
import imgui.flag.ImGuiWindowFlags;
import imgui.type.ImBoolean;

public abstract class Panel {

    public static final int STATIC_WINDOW_FLAGS = ImGuiWindowFlags.NoTitleBar | ImGuiWindowFlags.NoCollapse
            | ImGuiWindowFlags.NoMove | ImGuiWindowFlags.NoResize;

    protected final ConfiguredApplication parentApplication;

    protected final String panelName;
    protected ImBoolean isOpen = new ImBoolean(true);

    public Panel(ConfiguredApplication application, String panelName) {
        this.parentApplication = application;
        this.panelName = panelName;
    }

    public void Process() {
        if(!isOpen.get())
            return;

        OnImGuiRender();
    }

    public abstract void OnImGuiRender();

}
