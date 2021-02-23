package ladder.domain;

import ladder.domain.rule.DrawRule;

import java.util.ArrayList;
import java.util.List;

public class LadderLine {
    private final List<Point> points;

    public LadderLine(List<Point> points) {
        this.points = points;
    }

    // 사다리 라인 한줄씩 생성
    // first---body---last
    public static LadderLine init(int sizeOfPerson, DrawRule drawRule) {
        List<Point> points = new ArrayList<>();
        Point point = initFirst(points, drawRule);
        point = initBody(sizeOfPerson, points, point);
        initLast(points, point);
        return new LadderLine(points);
    }

    private static Point initFirst(List<Point> points, DrawRule drawRule) {
        Point point = Point.first(drawRule.isDrawable());
        points.add(point);
        return point;
    }

    private static Point initBody(int sizeOfPerson, List<Point> points, Point point) {
        for (int i = 1; i < sizeOfPerson - 1; i++) {
            point = point.next();
            points.add(point);
        }
        return point;
    }

    private static void initLast(List<Point> points, Point point) {
        point = point.last();
        points.add(point);
    }

    public int move(int position) {
        return points.get(position).move();
    }

    public boolean hasLine(int column) {
        return this.points.get(column).getDirection().isRight() &&
                this.points.get(column + 1).getDirection().isLeft();
    }
}
