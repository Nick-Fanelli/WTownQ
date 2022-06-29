package cue;

import java.util.TreeMap;
import java.util.function.BiConsumer;

public class CueList {

    private final TreeMap<Float, CueData> cueList = new TreeMap<>();

    public void AddCue(float cueNumber, CueData data) {
        cueList.put(cueNumber, data);
    }

    public void DeleteCue(float cueNumber) {
        cueList.remove(cueNumber);
    }

    public TreeMap<Float, CueData> GetRawCueList() { return this.cueList; }
    public void ForEachCue(BiConsumer<? super Float, ? super CueData> action) { cueList.forEach(action); }
}
