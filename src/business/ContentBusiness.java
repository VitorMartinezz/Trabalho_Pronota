package business;

import java.util.List;

import DAO.ContentMySQLDAO;
import common.VO.Content;
import common.VO.Subject;

public class ContentBusiness {
    public boolean create(Content content) {
        return ContentMySQLDAO.insert(content);
    }

    public List<Content> getAllBySubject(Subject subject) {
        return ContentMySQLDAO.getContentBySubject(subject);
    }

    public void addLike(int id) {
        Content c = ContentMySQLDAO.getContentById(id);
        c.setLikes(c.getLikes() + 1);
        this.create(c);
    }
}
