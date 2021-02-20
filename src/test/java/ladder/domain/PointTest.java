package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.assertj.core.api.Assertions.assertThat;

class PointTest {
    @Test
    @DisplayName("첫번째 Point 이동")
    public void first_point_move() {
        assertThat(Point.first(TRUE).move()).isEqualTo(1);
        assertThat(Point.first(FALSE).move()).isEqualTo(0);
    }

    @Test
    @DisplayName("Point 이동안함")
    public void next_point_stay() {
        Point secondPoint = Point.first(FALSE).next(FALSE);
        assertThat(secondPoint.move()).isEqualTo(1);
        assertThat(secondPoint.getDirection()).isEqualTo(Direction.of(FALSE, FALSE));
    }

    @Test
    @DisplayName("Point 왼쪽 이동 (1 -> 0)")
    public void next_point_left() {
        Point secondPoint = Point.first(TRUE).next(FALSE);
        assertThat(secondPoint.move()).isEqualTo(0);
    }

    @Test
    @DisplayName("Point 오른쪽 이동 (1 -> 2)")
    public void next_point_right() {
        Point secondPoint = Point.first(FALSE).next(TRUE);
        assertThat(secondPoint.move()).isEqualTo(2);
    }

    @Test
    @DisplayName("두번째 Point에서 첫번째 Point 이동")
    public void next_point() {
        Point secondPoint = Point.first(TRUE).next();
        assertThat(secondPoint.move()).isEqualTo(0);
    }

}