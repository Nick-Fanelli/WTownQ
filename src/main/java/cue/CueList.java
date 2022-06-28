package cue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class CueList {

    private final HashMap<Float, CueData> cueList = new HashMap<Float, CueData>();

    public void AddCue(float cueNumber, CueData data) {
        cueList.put(cueNumber, data);
    }

    public void DeleteCue(float cueNumber) {
        cueList.remove(cueNumber);
    }

    

}
