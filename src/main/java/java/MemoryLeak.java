package java;

import java.util.ArrayList;
import java.util.List;

public class MemoryLeak {
    List<String> arrayList = new ArrayList<String>();

    public void addtoArrayList() {
        arrayList.add("hello");
    }

    public static void main(String[] args) {
        MemoryLeak memoryLeak = new MemoryLeak();
        while (true) {
            memoryLeak.addtoArrayList();
        }
    }
}
