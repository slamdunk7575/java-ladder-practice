package ladder.player;

import ladder.util.StringUtil;
import lombok.Builder;

public class Player {
    private static final int MAX_NAME_LENGTH = 5;
    private final String name;
    private final int position;

    @Builder
    public Player(String name, int position) {
        validateName(name);
        this.name = name;
        this.position = position;
    }

    private void validateName(String name) {
        if(StringUtil.isEmpty(name) || name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("이름은 최대 5글자까지 가능합니다." + name);
        }
    }

    public boolean matchName(String inputName) {
        return this.name.equals(inputName);
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
