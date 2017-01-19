package com.survivor.core;

/**
 * Created by sxf on 15-3-29.
 */
public class Point3f {
    public float x,y,z;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Point3f)) return false;

        Point3f point3f = (Point3f) o;

        if (Float.compare(point3f.x, x) != 0) return false;
        if (Float.compare(point3f.y, y) != 0) return false;
        if (Float.compare(point3f.z, z) != 0) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (x != +0.0f ? Float.floatToIntBits(x) : 0);
        result = 31 * result + (y != +0.0f ? Float.floatToIntBits(y) : 0);
        result = 31 * result + (z != +0.0f ? Float.floatToIntBits(z) : 0);
        return result;
    }
}
