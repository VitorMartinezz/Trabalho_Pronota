package business;

import DAO.ContentMySQLDAO;
import common.VO.Content;

public class ContentBusiness {
    public boolean create(Content content) {
        return ContentMySQLDAO.insert(content);
    }
}
