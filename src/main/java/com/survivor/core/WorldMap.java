package com.survivor.core;

import com.survivor.map.Octree;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by sxf on 15-2-13.
 */
public class WorldMap {
    protected Map<Point2d,Octree> worldmap = new TreeMap<>();


    /**
     * 获取某一个坐标点为中心的Octree
     * @param x x轴
     * @param y y轴
     * @return 以该点为中心的Octree块
     */
    public Octree getOctree(int x, int y) {
        return worldmap.get(new Point2d(x,y));
    }

    /**
     * 获取某一个坐标点为中心的Octree
     * @param p 该坐标点
     * @return 以该点为中心的Octree块
     */
    public Octree getOctree(Point2d p) {
        return worldmap.get(p);
    }


    public void setObj(GameObject obj,Position pos) {
        Octree octree = worldmap.get(new Point2d(0, 0));

    }
}
