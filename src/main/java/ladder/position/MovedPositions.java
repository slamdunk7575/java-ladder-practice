package ladder.position;

import java.util.Collections;
import java.util.List;

public class MovedPositions {
    private final List<MovedPosition> positions;

    public MovedPositions(List<MovedPosition> positions) {
        this.positions = positions;
    }

    public static MovedPositions of(List<MovedPosition> positions) {
        return new MovedPositions(positions);
    }

    public List<MovedPosition> getPositions() {
        return Collections.unmodifiableList(positions);
    }
}
