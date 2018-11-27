package cn.novedu.result;

import cn.novedu.bean.Post;
import cn.novedu.bean.PostReply;

import java.util.List;

public class PostResult {
    private Post post;
    private List<PostReply> replies;

    public PostResult(Post post, List<PostReply> replies) {
        this.post = post;
        this.replies = replies;
    }

    public PostResult() {
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public List<PostReply> getReplies() {
        return replies;
    }

    public void setReplies(List<PostReply> replies) {
        this.replies = replies;
    }
}
