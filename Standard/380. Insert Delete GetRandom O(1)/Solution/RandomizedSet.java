import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

public class RandomizedSet {

    HashMap<Integer, Integer> hashMap;
    ArrayList<Integer> arrayList;
    Random random = new Random();

    public RandomizedSet() {
        hashMap = new HashMap<>();
        arrayList = new ArrayList<>();
    }
    
    public boolean insert(int val) {
        if (hashMap.containsKey(val)) {
            return false;
        } else {
            hashMap.put(val, arrayList.size());
            arrayList.add(val);
            return true;
        }
    }
    
    public boolean remove(int val) {
        if (hashMap.containsKey(val)) {
            int index = hashMap.get(val);
            int last = arrayList.getLast();
            arrayList.set(index, last);
            hashMap.put(last, index);
            hashMap.remove(val);
            arrayList.removeLast();
            return true;
        } else {
            return false;
        }
    }
    
    public int getRandom() {
        return arrayList.get(random.nextInt(arrayList.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
