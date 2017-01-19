package com.survivor.core;

/**
 * Created by sxf on 15-3-29.
 */
public class Point2f {
    float x,y;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Point2f)) return false;

        Point2f point2f = (Point2f) o;

        if (Float.compare(point2f.x, x) != 0) return false;
        if (Float.compare(point2f.y, y) != 0) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (x != +0.0f ? Float.floatToIntBits(x) : 0);
        result = 31 * result + (y != +0.0f ? Float.floatToIntBits(y) : 0);
        return result;
    }


}
