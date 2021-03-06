package ladder.domain;

import ladder.domain.rule.RandomDrawRule;

public class LadderPointGenerator {
    public static boolean generatePoint() {
        return generatePoint(new RandomDrawRule());
    }

    private static boolean generatePoint(RandomDrawRule randomDrawRule) {
        return randomDrawRule.isDrawable();
    }
}
