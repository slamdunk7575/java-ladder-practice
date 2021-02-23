package ladder.result;

import ladder.position.MovedPositions;
import ladder.reward.Rewards;
import lombok.Builder;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class GameResults {
    private final List<GameResult> gameResults;

    @Builder
    private GameResults(Rewards rewards, MovedPositions positions) {
        this.gameResults = generateResult(rewards, positions);
    }

    private List<GameResult> generateResult(Rewards rewards, MovedPositions positions) {
        return positions.getPositions().stream()
                .map(position -> GameResult.builder()
                        .name(position.getName())
                        .reward(rewards.getNameByPosition(position.getFinalPosition()))
                        .build())
                .collect(Collectors.toList());
    }

    public List<GameResult> getGameResults() {
        return Collections.unmodifiableList(gameResults);
    }
}
