package com.survivor.map;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by sxf on 15-2-18.
 */
class OctNode {
    OctNode[] childList;
    float midX = Float.NaN;
    float midY = Float.NaN;
    float midZ = Float.NaN;

    protected void add(OctPoint point, OctInterval interval, int nowdepth, int maxdepth) {

        if (midX == Float.NaN) {
            midX = interval.getMidX();
            midY = interval.getMidY();
            midZ = interval.getMidZ();
        }
        Integer pList = 0;
        OctInterval nextinterval = getPlist(point, pList);

        if (childList == null) {
            childList = new OctNode[8];
        }
        if (childList[pList] == null) {
            if (nowdepth == maxdepth) {
                childList[pList] = new OctLeafNode();
            } else {
                childList[pList] = new OctNode();
            }
        }

        childList[pList].add(point, nextinterval, nowdepth + 1, maxdepth);
    }

    protected void setBlock(OctPoint point, OctInterval interval, int nowdepth, int maxdepth) {
        if (midX == Float.NaN) {
            midX = interval.getMidX();
            midY = interval.getMidY();
            midZ = interval.getMidZ();
        }
        Integer pList = 0;
        OctInterval nextinterval = getPlist(point, pList);

        if (childList == null) {
            childList = new OctNode[8];
        }
        if (childList[pList] == null) {
            if (nowdepth == maxdepth) {
                childList[pList] = new OctLeafNode();
            } else {
                childList[pList] = new OctNode();
            }
        }

        childList[pList].add(point, nextinterval, nowdepth + 1, maxdepth);
    }


    protected OctInterval getPlist(OctPoint point, Integer pList) {
        OctInterval nextinterval = null;
        if (point.getZ() < midZ) {
            if (point.getY() < midY) {
                if (point.getX() < midX) {
                    pList = Octree.UpFrontLeft;
                    nextinterval = new OctInterval(point.getX(), point.getY(), point.getZ(), midX, midY, midZ);
                } else {
                    pList = Octree.UpBackLeft;
                    nextinterval = new OctInterval(midX, point.getY(), point.getZ(), point.getX(), midY, midZ);
                }
            } else {
                if (point.getX() < midX) {
                    pList = Octree.UpFrontRight;
                    nextinterval = new OctInterval(point.getX(), midY, point.getZ(), midX, point.getY(), midZ);
                } else {
                    pList = Octree.UpBackRight;
                    nextinterval = new OctInterval(midX, midY, point.getZ(), point.getX(), point.getY(), midZ);
                }
            }
        } else {
            if (point.getY() < midY) {
                if (point.getX() < midX) {
                    pList = Octree.DownFrontLeft;
                    nextinterval = new OctInterval(point.getX(), point.getY(), midZ, midX, midY, point.getZ());
                } else {
                    pList = Octree.DownBackLeft;
                    nextinterval = new OctInterval(midX, point.getY(), midZ, point.getX(), midY, point.getZ());
                }
            } else {
                if (point.getX() < midX) {
                    pList = Octree.DownFrontRight;
                    nextinterval = new OctInterval(point.getX(), midY, midZ, midX, point.getY(), point.getZ());
                } else {
                    pList = Octree.DownBackRight;
                    nextinterval = new OctInterval(midX, midY, midZ, point.getX(), point.getY(), point.getZ());
                }
            }
        }
        return nextinterval;
    }

}

class OctLeafNode extends OctNode {
    List<OctPoint> dataList;
    OctPoint block;

    @Override
    protected void add(OctPoint point, OctInterval interval, int nowdepth, int maxdepth) {
        if (dataList == null) {
            dataList = new LinkedList<>();
            dataList.add(point);
        }
    }

    @Override
    protected void setBlock(OctPoint point, OctInterval interval, int nowdepth, int maxdepth) {
        this.block = point;
    }
}