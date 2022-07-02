package prototype.hifi.dnick.service.impl;

import org.springframework.stereotype.Service;
import prototype.hifi.dnick.model.Topic;
import prototype.hifi.dnick.model.TopicUser;
import prototype.hifi.dnick.model.User;
import prototype.hifi.dnick.repository.TopicRepository;
import prototype.hifi.dnick.repository.TopicUserRepository;
import prototype.hifi.dnick.service.TopicService;

import java.util.List;

@Service
public class TopicServiceImpl implements TopicService {
    private final TopicRepository topicRepository;
    private final TopicUserRepository topicUserRepository;

    public TopicServiceImpl(TopicRepository topicRepository, TopicUserRepository topicUserRepository) {
        this.topicRepository = topicRepository;
        this.topicUserRepository = topicUserRepository;
    }

    @Override
    public Topic saveTopic(String id, String title, String imageUrl, String videoUrl, String description) {
        Topic t=new Topic(id,title,imageUrl,videoUrl,description);
        topicRepository.save(t);
        return t;
    }

    @Override
    public Topic getById(String id) {
        return topicRepository.findById(id).get();
    }

    @Override
    public List<Topic> findAll() {
        return topicRepository.findAll();
    }

    @Override
    public Boolean changeStatusForUser(String topicId, User user) {
        Topic t=getById(topicId);
        TopicUser tu=topicUserRepository.findByTopicAndUser(t,user);
        tu.setCompleted(!tu.getCompleted());
        topicUserRepository.save(tu);
        return tu.getCompleted();
    }

    @Override
    public void setAllTopicsAsNotCompletedForUser(User user) {
        List<Topic> topics=findAll();
        for(Topic t: topics){
            topicUserRepository.save(new TopicUser(user,t,false));
        }
    }

    @Override
    public List<TopicUser> findAllForUser(User user) {
        return topicUserRepository.findAllByUser(user);
    }

    @Override
    public TopicUser findTopicForUser(String topicId, User user) {
        Topic t=getById(topicId);
        return topicUserRepository.findByTopicAndUser(t,user);
    }

    @Override
    public void markAsCompleted(String topicId, User user) {
        Topic t=getById(topicId);
        TopicUser tu=topicUserRepository.findByTopicAndUser(t,user);
        tu.setCompleted(true);
        topicUserRepository.save(tu);
    }

    @Override
    public void markAsNotCompleted(String topicId, User user) {
        Topic t=getById(topicId);
        TopicUser tu=topicUserRepository.findByTopicAndUser(t,user);
        tu.setCompleted(false);
        topicUserRepository.save(tu);
    }

}
