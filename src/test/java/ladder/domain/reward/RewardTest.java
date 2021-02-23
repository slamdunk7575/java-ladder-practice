package ladder.domain.reward;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class RewardTest {

    @Test
    @DisplayName("당첨결과 생성되는지 확인")
    public void reward_test() {
        // given
        String name = "1등";

        // when
        Reward reward = Reward.of(name);

        // then
        assertThat(reward.getName()).isEqualTo(name);
    }

    @Test
    @DisplayName("잘못된 상금을 입력한 경우 예외발생")
    public void reward_input_error_test() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                   Reward.of(null);
                   Reward.of("");
                }).withMessageMatching("당첨결과 이름이 없습니다.");
    }
}