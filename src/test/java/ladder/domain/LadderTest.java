package ladder.domain;

import ladder.game.LadderGame;
import ladder.player.Players;
import ladder.rule.DrawRule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {

    private Ladder ladder;

    // AAA   BBB   CCC
    // |-----|     |
    // |-----|     |
    // |-----|     |
    // |-----|     |
    // |-----|     |

    @BeforeEach
    void setUp() {
        int rowCount = 4;
        Players players = Players.of("AAA,BBB,CCC");
        DrawRule alwaysDrawRule = () -> true;

        LadderGame ladderGame = LadderGame.builder()
                .rows(rowCount)
                .players(players)
                .build();

        ladder = ladderGame.makeLadder(alwaysDrawRule);
    }

    @Test
    @DisplayName("Line 생성 테스트")
    public void ladder_line_test() {
        // given
        int curColumn = 0;

        // when
        LadderLine ladderLine = ladder.getLadderLines().get(0);

        // then
        assertThat(ladderLine.hasLine(curColumn)).isTrue();
    }

    @Test
    @DisplayName("인접하게 Line이 생성되지 않는지 테스트")
    public void adjacent_ladder_line_test() {
        // given
        int currentRow = 0;
        int nextColumn = 1;

        // when
        LadderLine ladderLine = ladder.getLadderLines().get(currentRow);

        // then
        assertThat(ladderLine.hasLine(nextColumn)).isFalse();
    }

    @Test
    @DisplayName("사다리 길찾기 테스트")
    public void search_line_test() {
        assertThat(ladder.searchFinalPosition(0)).isEqualTo(0);
        assertThat(ladder.searchFinalPosition(1)).isEqualTo(1);
        assertThat(ladder.searchFinalPosition(2)).isEqualTo(2);
    }
}
