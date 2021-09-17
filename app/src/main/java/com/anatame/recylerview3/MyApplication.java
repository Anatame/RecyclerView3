package com.anatame.recylerview3;

import android.app.Application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyApplication extends Application {
    private static List<President> presidentList = new ArrayList<>();
    private static int nextId = 8;

    public MyApplication() {
        fillPresidentList();
    }

    private void fillPresidentList() {
        President p0 = new President(0, "George Washington", 1788, "https://upload.wikimedia.org/wikipedia/commons/thumb/b/b6/Gilbert_Stuart_Williamstown_Portrait_of_George_Washington.jpg/240px-Gilbert_Stuart_Williamstown_Portrait_of_George_Washington.jpg");
        President p1 = new President(1, "George Washington", 1788, "https://upload.wikimedia.org/wikipedia/commons/thumb/b/b6/Gilbert_Stuart_Williamstown_Portrait_of_George_Washington.jpg/240px-Gilbert_Stuart_Williamstown_Portrait_of_George_Washington.jpg");
        President p2 = new President(2, "George Washington", 1788, "https://upload.wikimedia.org/wikipedia/commons/thumb/b/b6/Gilbert_Stuart_Williamstown_Portrait_of_George_Washington.jpg/240px-Gilbert_Stuart_Williamstown_Portrait_of_George_Washington.jpg");
        President p3 = new President(3, "George Washington", 1788, "https://upload.wikimedia.org/wikipedia/commons/thumb/b/b6/Gilbert_Stuart_Williamstown_Portrait_of_George_Washington.jpg/240px-Gilbert_Stuart_Williamstown_Portrait_of_George_Washington.jpg");
        President p4 = new President(4, "George Washington", 1788, "https://upload.wikimedia.org/wikipedia/commons/thumb/b/b6/Gilbert_Stuart_Williamstown_Portrait_of_George_Washington.jpg/240px-Gilbert_Stuart_Williamstown_Portrait_of_George_Washington.jpg");
        President p5 = new President(5, "George Washington", 1788, "https://upload.wikimedia.org/wikipedia/commons/thumb/b/b6/Gilbert_Stuart_Williamstown_Portrait_of_George_Washington.jpg/240px-Gilbert_Stuart_Williamstown_Portrait_of_George_Washington.jpg");
        President p6 = new President(6, "George Washington", 1788, "https://upload.wikimedia.org/wikipedia/commons/thumb/b/b6/Gilbert_Stuart_Williamstown_Portrait_of_George_Washington.jpg/240px-Gilbert_Stuart_Williamstown_Portrait_of_George_Washington.jpg");
        President p7 = new President(7, "George Washington", 1788, "https://upload.wikimedia.org/wikipedia/commons/thumb/b/b6/Gilbert_Stuart_Williamstown_Portrait_of_George_Washington.jpg/240px-Gilbert_Stuart_Williamstown_Portrait_of_George_Washington.jpg");
        President p8 = new President(8, "George Washington", 1788, "https://upload.wikimedia.org/wikipedia/commons/thumb/b/b6/Gilbert_Stuart_Williamstown_Portrait_of_George_Washington.jpg/240px-Gilbert_Stuart_Williamstown_Portrait_of_George_Washington.jpg");

        presidentList.addAll(Arrays.asList(p0,p1,p2,p3,p4,p5,p6,p7,p8));
    }

    public static List<President> getPresidentList() {
        return presidentList;
    }

    public static void setPresidentList(List<President> presidentList) {
        MyApplication.presidentList = presidentList;
    }

    public static int getNextId() {
        return nextId;
    }

    public static void setNextId(int nextId) {
        MyApplication.nextId = nextId;
    }
}
