package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LadderLineTest {

    @Test
    @DisplayName("line 생성")
    public void init_ladder_line() {
        int sizeOfPerson = 2;
        LadderLine ladderLine = LadderLine.init(sizeOfPerson, () -> true);
        assertThat(ladderLine.hasLine(0)).isEqualTo(true);
    }

    @Test
    @DisplayName("line 이동")
    public void move_ladder_line() {
        LadderLine ladderLine = LadderLine.init(2, () -> true);
        assertThat(ladderLine.move(0)).isEqualTo(1);
    }

}