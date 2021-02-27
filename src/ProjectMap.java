import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Iterator;

public class ProjectMap {
    // ----------------------------------
    // Variables/Fields
    // ----------------------------------

    private Map<Integer, Project> projects;
    private Set<Map.Entry<Integer, Project>> entries;
    private Iterator<Map.Entry<Integer, Project>> iterator;
    private Map.Entry<Integer, Project> entry;

    // ----------------------------------
    // Constructors
    // ----------------------------------

    // Default Constructor
    public ProjectMap() {
        projects = new HashMap<Integer, Project>();
    }

    // Argument Constructor
    public ProjectMap(Map<Integer, Project> projects) {
        this.projects = projects;
    }

    // -----------------------------------
    // Methods
    // -----------------------------------

    // Setters and Getters
    private void setProjects(Map<Integer, Project> projects) {
        this.projects = projects;
    }
    private Map<Integer, Project> getProjects() {
        return projects;
    }
    public void inputProjects(Map<Integer, Project> projects) {
        setProjects(projects);
    }
    public Map<Integer, Project> grabProjects() {
        return getProjects();
    }

    // Insert Employees to Map
    public void addProject(Map<Integer, Project> map, Project project) {
        map.put(project.grabID(), project);
    }
}
