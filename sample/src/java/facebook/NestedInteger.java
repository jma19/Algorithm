package facebook;

import java.util.ArrayList;
import java.util.List;

public class NestedInteger {
    private boolean isInteger;
    private List<NestedInteger> list;
    private Integer vlaue;

    public NestedInteger(){

    }
    public NestedInteger(int value) {
        this.vlaue = value;
        this.list = new ArrayList();
    }

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger() {
        return isInteger;
    }

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger() {
        return vlaue;
    }

    // Set this NestedInteger to hold a single integer.
    public void setInteger(int value) {
        this.vlaue = value;
    }

    // Set this NestedInteger to hold a nested list and adds a nested integer to it.
    public void add(NestedInteger ni) {
        this.list.add(ni);
    }

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    public List<NestedInteger> getList() {
        return list;
    }
}
