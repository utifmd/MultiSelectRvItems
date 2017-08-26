package com.doricovix.utif.multiselectrvitems;

/**
 * Created by utif on 8/26/2017.
 */

public class Model {
    private String title, desc;

    public Model(String title, String desc) {
        this.title = title;
        this.desc = desc;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
