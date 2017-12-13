package Applovin;

import java.util.*;

class RandomizedSet {

    private Map<Integer, Integer> indexMap;
    private List<Integer> valList;
    private Random random;
    /** Initialize your data structure here. */
    public RandomizedSet() {
        indexMap = new HashMap();
        valList = new ArrayList();
        random = new Random();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(indexMap.containsKey(val)){
            return false;
        }
        valList.add(val);
        indexMap.put(val, valList.size() - 1);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!indexMap.containsKey(val)){
            return false;
        }
        int orgIndex = indexMap.get(val);
        if(orgIndex != valList.size() - 1){
            valList.set(orgIndex, valList.get(valList.size() - 1));
            indexMap.put(valList.get(valList.size() - 1), orgIndex);
        }
        indexMap.remove(val);
        valList.remove(valList.size() - 1);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {

        int index = random.nextInt(valList.size());
        return valList.get(index);
    }

    public static void main(String[] args) {
        RandomizedSet randomizedSet= new RandomizedSet();

        randomizedSet.insert(0);
        randomizedSet.remove(0);

        randomizedSet.insert(-1);

        randomizedSet.remove(0);

        TreeSet<Node> treeSet = new TreeSet<>((o1, o2) -> 0);

//        System.out.println(randomizedSet.getRandom());

    }


}