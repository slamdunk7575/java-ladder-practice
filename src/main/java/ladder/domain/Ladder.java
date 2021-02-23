package ladder.domain;

import ladder.domain.rule.DrawRule;
import lombok.Builder;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ladder {

    private final List<LadderLine> ladderLines;
    private final int columnCount;
    private final DrawRule drawRule;

    @Builder
    public Ladder(int rowCount, int columnCount, DrawRule drawRule) {
        this.ladderLines = initLadder(rowCount, columnCount, drawRule);
        this.columnCount = columnCount;
        this.drawRule = drawRule;
    }

    private List<LadderLine> initLadder(int rowCount, int columnCount, DrawRule drawRule) {
        return Stream.generate(() -> LadderLine.init(columnCount, drawRule))
                .limit(rowCount)
                .collect(Collectors.toList());
    }

    public int searchFinalPosition(int startPoint) {
        int currentPosition = startPoint;
        for (LadderLine line :  ladderLines) {
            currentPosition = line.move(currentPosition);
        }
        return currentPosition;
    }

    public List<LadderLine> getLadderLines() {
        return Collections.unmodifiableList(ladderLines);
    }

    public int getColumnCount() {
        return this.columnCount;
    }

}
