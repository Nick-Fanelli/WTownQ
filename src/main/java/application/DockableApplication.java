package application;

import imgui.ImGui;
import imgui.app.Application;
import imgui.app.Configuration;
import imgui.flag.*;
import imgui.type.ImBoolean;

import static org.lwjgl.glfw.GLFW.glfwGetWindowSize;
import static org.lwjgl.glfw.GLFW.glfwSetWindowSizeCallback;

public abstract class DockableApplication extends ConfiguredApplication {

    private int currentWindowWidth;
    private int currentWindowHeight;

    private static final int DOCKSPACE_IMGUI_WINDOW_FLAGS = ImGuiWindowFlags.NoTitleBar | ImGuiWindowFlags.NoCollapse
            | ImGuiWindowFlags.NoResize | ImGuiWindowFlags.NoMove | ImGuiWindowFlags.NoBringToFrontOnFocus | ImGuiWindowFlags.NoNavFocus
            | ImGuiWindowFlags.None;

    private static final int IMGUI_DOCKING_FLAGS = ImGuiDockNodeFlags.None;

    @Override
    protected void initWindow(Configuration config) {
        super.initWindow(config);

        final long windowPtr = getHandle();

        int[] startingWidth = new int[1];
        int[] startingHeight = new int[1];

        glfwGetWindowSize(windowPtr, startingWidth, startingHeight);

        currentWindowWidth = startingWidth[0];
        currentWindowHeight = startingHeight[0];

        glfwSetWindowSizeCallback(windowPtr, (final long window, final int width, final int height) -> {
            super.runFrame(); // Mimic ImGui Behavior (because we are overriding glfw window callback)

            this.currentWindowWidth = width;
            this.currentWindowHeight = height;
        });
    }

    @Override
    protected void initImGui(Configuration config) {
        super.initImGui(config);

        ImGui.getIO().addConfigFlags(ImGuiConfigFlags.DockingEnable);
    }

    @Override
    protected void preProcess() {
        super.preProcess();

        ImGui.setNextWindowPos(0.0f, 0.0f, ImGuiCond.Always);
        ImGui.setNextWindowSize(currentWindowWidth, currentWindowHeight);

        ImGui.pushStyleVar(ImGuiStyleVar.WindowRounding, 0.0f);
        ImGui.pushStyleVar(ImGuiStyleVar.WindowBorderSize, 0.0f);
        ImGui.pushStyleVar(ImGuiStyleVar.WindowPadding, 0.0f, 0.0f);

        ImGui.begin("Dockspace", new ImBoolean(true), DOCKSPACE_IMGUI_WINDOW_FLAGS);

        ImGui.popStyleVar(3);

        int dockspaceID = ImGui.getID("Dockspace");
        ImGui.dockSpace(dockspaceID, 0.0f, 0.0f, IMGUI_DOCKING_FLAGS);

        ImGui.end();
    }

    @Override
    protected void postProcess() {

        super.postProcess();
    }
}
