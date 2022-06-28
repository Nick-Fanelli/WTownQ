package application;

import imgui.app.Configuration;
import panels.ConfigurationPanel;
import panels.CueListPanel;

public class ProgramApplication extends DockableApplication {

    private final CueListPanel cueListPanel;
    private final ConfigurationPanel configurationPanel;

    public ProgramApplication() {
        cueListPanel = new CueListPanel();
        configurationPanel = new ConfigurationPanel();
    }

    @Override
    protected void configure(Configuration config) {
        super.configure(config);
        config.setTitle("WTownQ");
    }

    @Override
    public void process() {
        cueListPanel.Process();
        configurationPanel.Process();
    }

}
