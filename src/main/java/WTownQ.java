import application.DockableApplication;
import imgui.app.Configuration;
import panels.ConfigurationPanel;
import panels.CueListPanel;

public class WTownQ extends DockableApplication {

    private final CueListPanel cueListPanel;
    private final ConfigurationPanel configurationPanel;

    public WTownQ() {
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

    public static void main(String[] args) {
        launch(new WTownQ());
    }

}
