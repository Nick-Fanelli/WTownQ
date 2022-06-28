package application;

import imgui.app.Configuration;
import panels.ControlPanel;
import panels.CueListPanel;
import panels.PropertiesPanel;

public class ProgramApplication extends ConfiguredApplication {

    private final CueListPanel cueListPanel;
    private final ControlPanel controlPanel;
    private final PropertiesPanel propertiesPanel;

    public ProgramApplication() {
        cueListPanel = new CueListPanel(this);
        controlPanel = new ControlPanel(this);
        propertiesPanel = new PropertiesPanel(this);
    }

    @Override
    protected void configure(Configuration config) {
        super.configure(config);
        config.setTitle("WTownQ");
    }

    @Override
    public void process() {
        cueListPanel.Process();
        controlPanel.Process();
        propertiesPanel.Process();
    }

}
