package prototype.hifi.dnick.service;

import prototype.hifi.dnick.model.Topic;
import prototype.hifi.dnick.model.User;

import java.util.List;

public interface TopicService {
    Topic saveTopic(String id, String title, String videoUrl, String description);
    Topic getById(String id);
    List<Topic> findAll();
    Boolean changeStatusForUser(String topicId, User user);
    void setAllTopicsAsNotCompletedForUser(User user);
}
