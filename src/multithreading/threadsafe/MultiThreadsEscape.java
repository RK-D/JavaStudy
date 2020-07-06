package multithreading.threadsafe;


import com.sun.javafx.geom.Matrix3f;
import java.util.HashMap;
import java.util.Map;
/**
 * @author rookie
 * @date 2020/7/6
 */
public class MultiThreadsEscape {
    private Map<String, String> states;

    public MultiThreadsEscape() {
        states = new HashMap<>();
        states.put("1", "周一");
        states.put("2", "周二");
        states.put("3", "周三");
        states.put("4", "周四");
    }

    //这里就是发布逸出
    public Map<String, String> getStates() {
        return states;
    }

    public Map<String, String> getStatesImproved() {
        return new HashMap<>(states);
    }

    public static void main(String[] args) {
        MultiThreadsEscape multiThreadsEscape = new MultiThreadsEscape();
        Map<String, String> states = multiThreadsEscape.getStates();
//        System.out.println(states.get("1"));
//        states.remove("1");
//        System.out.println(states.get("1"));

        System.out.println(multiThreadsEscape.getStatesImproved().get("1"));
        multiThreadsEscape.getStatesImproved().remove("1");
        System.out.println(multiThreadsEscape.getStatesImproved().get("1"));

    }
}
