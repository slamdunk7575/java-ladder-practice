package ladder.domain.player;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PlayerTest {

    @Test
    @DisplayName("플레이어 이름이 5글자 이상인 경우 예외 발생")
    public void player_name_length_over() {
        // given
        String name = "ABCDEFG";
        int position = 2;

        // when & then
        assertThatThrownBy(() -> Player.builder()
        .name(name)
        .position(position)
        .build())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 최대 5글자까지 가능합니다." + name);
    }

}