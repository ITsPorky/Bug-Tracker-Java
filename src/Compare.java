//import com.sun.jdi.Value;
//
//import java.util.Comparator;
//import java.util.Map;
//
//public class ValueComparator {
//    // ----------------------------------
//    // Variables/Fields
//    // ----------------------------------
//    Map<Integer, Employee> entry;
//
//
//    // ----------------------------------
//    // Constructors
//    // ----------------------------------
//
//    // Default Constructor
//    public ValueComparator() {
//
//    }
//
//    // Argument constructor
//    public ValueComparator(Map<Integer, Employee> employees) {
//        this.entry = employees;
//    }
//
//    // -----------------------------------
//    // Methods
//    // -----------------------------------
//
//    // Note: this comparator imposes orderings that are inconsistent with
//    // equals.
//    public int compareExpiry(Employee a, Employee b) {
//        if (entry.get(a.programs.get(0).grabExpiryDate()) >= entry.get(b.programs.get().grabExpiryDate())) {
//            return -1;
//        } else {
//            return 1;
//        } // returning 0 would merge keys
//    }
//
//}
