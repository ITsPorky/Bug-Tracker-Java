import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Iterator;

public class BugMap {
    // ----------------------------------
    // Variables/Fields
    // ----------------------------------

    private Map<Integer, Bug> bugs;
    private Set<Map.Entry<Integer, Bug>> entries;
    private Iterator<Map.Entry<Integer, Bug>> iterator;
    private Map.Entry<Integer, Bug> entry;

    // ----------------------------------
    // Constructors
    // ----------------------------------

    // Default Constructor
    public BugMap() {
        bugs = new HashMap<Integer, Bug>();
    }

    // Argument Constructor
    public BugMap(Map<Integer, Bug> bugs) {
        this.bugs = bugs;
    }

    // -----------------------------------
    // Methods
    // -----------------------------------

    // Setters and Getters
    private void setBugs(Map<Integer, Bug> bugs) {
        this.bugs = bugs;
    }
    private Map<Integer, Bug> getBugs() {
        return bugs;
    }
    public void inputBugs(Map<Integer, Bug> bugs) {
        setBugs(bugs);
    }
    public Map<Integer, Bug> grabBugs() {
        return getBugs();
    }

    // Insert Employees to Map
    public void addBug(Map<Integer, Bug> map, Bug bug) {
        map.put(bug.grabID(), bug);
    }

}
