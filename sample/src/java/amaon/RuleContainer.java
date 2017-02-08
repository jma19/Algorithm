package amaon;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by junm5 on 2/7/17.
 */
public class RuleContainer {
    interface Rule {
        boolean apply(int i);
    }

    private Map<Rule, String> ruleContainers = new HashMap();
    private Set<Rule> rules;

    public RuleContainer() {
        addRule(i -> i % 15 == 0, "FizzBuzz");
        addRule(i -> i % 3 == 0, "Fizz");
        addRule(i -> i % 5 == 0, "Buzz");
        rules = ruleContainers.keySet();

    }
    public void addRule(Rule rule, String res) {
        ruleContainers.put(rule, res);
    }

    public String getValue(int i) {
        for (Rule rule : rules) {
            if (rule.apply(i)) {
                return ruleContainers.get(rule);
            }
        }
        return String.valueOf(i);
    }



}
