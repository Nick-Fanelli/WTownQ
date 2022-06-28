import core.DockableApplication;
import imgui.ImGui;
import imgui.app.Configuration;

public class WTownQ extends DockableApplication {


    @Override
    protected void configure(Configuration config) {
        super.configure(config);

        config.setTitle("WTownQ");
    }

    @Override
    public void process() {
        ImGui.begin("Test Window");
        ImGui.text("Hello World");
        ImGui.end();
    }

    public static void main(String[] args) {
        launch(new WTownQ());
    }

}
