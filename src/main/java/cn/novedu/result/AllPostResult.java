package cn.novedu.result;

import cn.novedu.bean.Clazz;
import cn.novedu.bean.Post;

import java.util.List;

public class AllPostResult {
    private Clazz clazz;
    private List<Post> allPost;
    private List<Post> teamPost;

    public AllPostResult(Clazz clazz, List<Post> allPost, List<Post> teamPost) {
        this.clazz = clazz;
        this.allPost = allPost;
        this.teamPost = teamPost;
    }

    public AllPostResult() {
    }

    public Clazz getClazz() {
        return clazz;
    }

    public void setClazz(Clazz clazz) {
        this.clazz = clazz;
    }

    public List<Post> getAllPost() {
        return allPost;
    }

    public void setAllPost(List<Post> allPost) {
        this.allPost = allPost;
    }

    public List<Post> getTeamPost() {
        return teamPost;
    }

    public void setTeamPost(List<Post> teamPost) {
        this.teamPost = teamPost;
    }
}
