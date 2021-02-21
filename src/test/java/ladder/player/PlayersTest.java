package ladder.player;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayersTest {

    @ParameterizedTest
    @CsvSource(value = {
            "YKJ,AAA=2",
            "BBB,CCC,DDD=3",
            "EEE,FFF,GGG,HHH=4"
    }, delimiter = '=')
    @DisplayName("플레이어들이 잘 생성되는지 테스트")
    public void players_test(String name, int playersCount) {
        // given
        Players players = Players.of(name);

        // when & then
        assertThat(players.getPlayersCount()).isEqualTo(playersCount);
    }
}
