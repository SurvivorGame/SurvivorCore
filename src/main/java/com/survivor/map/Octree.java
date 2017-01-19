package com.survivor.map;

/**
 * 这是一个中心为原点,上下各增长minlength*2^maxDepth长的空间划分八叉树
 * 遵循每一个块都以前左下角点为起始,后右上角为终,前开后闭的空间
 * 写成区间则是[x1:y1:z1, x2:y2:z2),保证每一个项,前项都比后项小
 * 而其中最小节点的间隔则是minlength
 * 八叉树最深层次为maxDepth所定义的层数
 * Created by sxf on 15-2-18.
 */
public class Octree {
    public static final int UpFrontLeft = 0;
    public static final int UpFrontRight = 1;
    public static final int UpBackLeft = 2;
    public static final int UpBackRight = 3;
    public static final int DownFrontLeft = 4;
    public static final int DownFrontRight = 5;
    public static final int DownBackLeft = 6;
    public static final int DownBackRight = 7;

    protected OctNode rootNode;
    protected float minLength = 1.0f;
    protected int maxDepth = 8;
    protected OctInterval default_interval = new OctInterval(0,0,0, 256,256,256);

    public void add(OctPoint point) {
        rootNode.add(point, default_interval, 0, maxDepth);
    }

    public void setBlock(OctPoint point) {
        rootNode.add(point, default_interval, 0, maxDepth);
    }

    public void add(OctPoint point, OctInterval interval) {
        rootNode.add(point, interval, 0, maxDepth);
    }

    public void setBlock(OctPoint point, OctInterval interval) {
        rootNode.add(point, interval, 0, maxDepth);
    }

    /** setter and getter */

    public float getMinLength() {
        return minLength;
    }

    public void setMinLength(float minLength) {
        this.minLength = minLength;
    }

    public int getMaxDepth() {
        return maxDepth;
    }

    public void setMaxDepth(int maxDepth) {
        this.maxDepth = maxDepth;
    }

    public OctNode getRootNode() {
        return rootNode;
    }

    public void setRootNode(OctNode rootNode) {
        this.rootNode = rootNode;
    }
}
