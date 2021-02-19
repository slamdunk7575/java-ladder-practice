package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class DirectionTest {
    @Test
    @DisplayName("Direction 생성")
    public void init_direction() {
        assertThat(Direction.of(true, false)).isEqualTo(Direction.of(true, false));
    }

    @Test
    @DisplayName("유효하지 않은 Direction 생성")
    public void invalid_direction() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    Direction.of(TRUE, TRUE);
                }).withMessage("같은 라인에 인접하게 생성될 수 없습니다.");
    }

    @Test
    @DisplayName("첫번째 Direction의 right가 true인 경우")
    public void first_direction_next() {
        Direction firstNext = Direction.first(TRUE).next();
        assertThat(firstNext).isEqualTo(Direction.of(TRUE, FALSE));
    }

    @Test
    @DisplayName("다음 Direction이 true인 경우")
    public void next_direction_true() {
        Direction nextDirection = Direction.of(TRUE, FALSE).next(TRUE);
        assertThat(nextDirection).isEqualTo(Direction.of(FALSE, TRUE));
    }

    @Test
    @DisplayName("다음 Direction이 false인 경우")
    public void next_direction_false() {
        Direction nextDirection = Direction.of(FALSE, TRUE).next(FALSE);
        assertThat(nextDirection).isEqualTo(Direction.of(TRUE, FALSE));
    }

    @Test
    @DisplayName("첫번째 Direction")
    public void first_direction() {
        Direction firstDirection = Direction.first(TRUE);
        assertThat(firstDirection.isLeft()).isEqualTo(FALSE);
    }

    @Test
    @DisplayName("마지막 Direction")
    public void last_direction() {
        Direction lastDirection = Direction.first(TRUE).last();
        assertThat(lastDirection).isEqualTo(Direction.of(TRUE, FALSE));
    }

}