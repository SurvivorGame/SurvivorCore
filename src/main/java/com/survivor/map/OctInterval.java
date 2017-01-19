package com.survivor.map;

/**
 * Created by sxf on 15-2-22.
 */
class OctInterval {
    public float minX, minY, minZ, maxX, maxY, maxZ;

    public OctInterval(float minX, float minY, float minZ, float maxX, float maxY, float maxZ) {
        this.minX = minX;
        this.minY = minY;
        this.minZ = minZ;
        this.maxX = maxX;
        this.maxY = maxY;
        this.maxZ = maxZ;
    }

    public float getMidX() {
        return (minX + maxX)/2.0f;
    }
    public float getMidY() {
        return (minY + maxY)/2.0f;
    }
    public float getMidZ() {
        return (minZ + maxZ)/2.0f;
    }

}
