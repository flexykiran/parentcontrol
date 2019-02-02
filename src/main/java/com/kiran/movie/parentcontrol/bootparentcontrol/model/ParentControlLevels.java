package com.kiran.movie.parentcontrol.bootparentcontrol.model;

/**
 * 
 * @author flexykiran
 *
 */
public enum ParentControlLevels {

	U(1,"U"),
    PG(2, "PG"),
    A_12(3, "12"),
    A_15(4, "15"),
    A_18(5, "18");

    private String levelName;
    private int level;

    ParentControlLevels(int level, String levelName) {
        this.level = level;
        this.levelName = levelName;
    }

    public String levelName() {
        return levelName;
    }
    
    public int level() {
        return level;
    }
}
