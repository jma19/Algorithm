package LinkedIn;

import java.util.List;

/**
 * Created by junm5 on 12/26/16.
 */
 interface NestedInteger {
    public boolean isInteger();

    public Integer getInteger();

    public void setInteger(int value);

    public void add(NestedInteger ni);

    public List<NestedInteger> getList();
}
