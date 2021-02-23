package ladder.controller;

import ladder.domain.Ladder;
import ladder.game.LadderGame;
import ladder.player.Players;
import ladder.result.GameResults;
import ladder.reward.Rewards;
import ladder.rule.RandomDrawRule;
import ladder.view.InputView;
import ladder.view.ResultView;

public class LadderController {

    public void start() {
        Players players = Players.of(InputView.inputPlayerNames());
        Rewards rewards = Rewards.of(InputView.inputRewards());

        LadderGame ladderGame = LadderGame.builder()
                .players(players)
                .rows(InputView.inputRowCount())
                .build();

        Ladder ladder = ladderGame.makeLadder(new RandomDrawRule());

        ResultView.printAll(players, ladder, rewards);

        ResultView.printGameResults(GameResults.builder()
                .rewards(rewards)
                .positions(ladderGame.run(InputView.inputResultTarget()))
                .build());
    }
}
